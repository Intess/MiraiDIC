package com.kagg886.miraidic.helper;

import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.MessageEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

//DICModule存储功能，一个功能由多个指令构成。
public class DICModule {

    //存储指令用的列表
    private final ArrayList<DICCommand> commandList = new ArrayList<>();

    //触发关键词(正则表达式)
    private String triggerWord;

    public String getTriggerWord() {
        return triggerWord;
    }

    public ArrayList<DICCommand> getCommandList() {
        return commandList;
    }

    public DICModule(String moduleSource) {
        String[] commands = moduleSource.split("\n");

        //设置触发词
        this.triggerWord = commands[0];
        commands[0] = null;
        for (String commandSource : commands) {
            if (commandSource == null) continue;
            commandList.add(new DICCommand(commandSource));
        }
    }


    public DICSession createSession(GroupMessageEvent event) {
        return new DICSession(event,this);
    }
}
