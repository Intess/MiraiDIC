package com.kagg886.miraidic.helper;

import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.MessageEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class DICModule {

    //存储指令用的列表
    private final ArrayList<DICCommand> commandList = new ArrayList<>();

    //变量池
    private HashMap<String, Object> objectPool;

    //触发关键词(正则表达式)
    private String triggerWord;

    public String getTriggerWord() {
        return triggerWord;
    }

    public HashMap<String, Object> getObjectPool() {
        return objectPool;
    }

    public DICModule(String moduleSource) {
        String[] commands = moduleSource.split("\n");

        //设置触发词
        this.triggerWord = commands[0];
        commands[0] = null;
        for (String commandSource : commands) {
            if (commandSource == null) continue;
            commandList.add(new DICCommand(this,commandSource));
        }
    }

    public void begin() {
        objectPool = new HashMap<>();
    }

    public void invoke(MessageEvent event) {
        for (DICCommand command : commandList) {
            command.invoke(event);
        }
    }

    public void close() {
        objectPool.clear();
        objectPool = null;
    }
    
}
