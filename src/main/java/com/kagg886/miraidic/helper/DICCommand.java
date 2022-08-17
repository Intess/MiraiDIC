package com.kagg886.miraidic.helper;


import com.kagg886.miraidic.MiraiDIC;
import com.kagg886.miraidic.function.AbstractFunction;
import net.mamoe.mirai.event.events.MessageEvent;

import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//存储单条指令
public class DICCommand {
    private DICModule binder;
    private String command;
    public DICCommand(DICModule bindToDICModule, String commandSource) {
        this.binder = bindToDICModule;
        this.command = commandSource;
    }

    //解析命令
    public void invoke(MessageEvent event) {
        //是否为指令,不是则认为是意欲发送的消息
        if (command.startsWith("$")) {
            for (AbstractFunction function : MiraiDIC.INSTANCE.functionList) {
                if (command.substring(1).startsWith(function.getRoot())) {
                    //得到真正的指令，剔除root，然后扔进处理器
                    function.hook(binder,getRealCommand().replace("$"+ function.getRoot() + " ","").split(" "));
                    return;
                }
            }
        } else {
            event.getSubject().sendMessage(getRealCommand().replace("\\n","\n"));
        }
    }

    private String getRealCommand() {
        //克隆一个String
        String source = new String(command.getBytes(StandardCharsets.UTF_8),StandardCharsets.UTF_8);
        Pattern pattern = Pattern.compile("%.*%");
        Matcher matcher = pattern.matcher(command);
        while (matcher.find()) {
            String var = matcher.group();
            String realVar = var.replace("%","");
            source = source.replace(var,binder.getObjectPool().get(realVar).toString());
        }
        return source;
    }
}
