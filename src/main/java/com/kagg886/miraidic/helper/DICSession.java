package com.kagg886.miraidic.helper;

import net.mamoe.mirai.event.events.MessageEvent;

import java.util.HashMap;

//DIC真正的解析类
public class DICSession {

    private MessageEvent event;
    private DICModule module;

    //对象池
    private HashMap<String,Object> objectPool = new HashMap<>();
    public DICSession(MessageEvent event, DICModule dicModule) {
        this.event = event;
        this.module = dicModule;

        //手动存入与当前环境有关的变量

        objectPool.put("群号",event.getSubject().getId());
        objectPool.put("内容",event.getMessage().contentToString());
        objectPool.put("机器人",event.getBot().getId());
        objectPool.put("QQ",event.getSender().getId());
        objectPool.put("昵称",event.getSender().getNick());
    }

    public HashMap<String, Object> getObjectPool() {
        return objectPool;
    }

    public void invoke() {
        for (DICCommand command : module.getCommandList()) {
            command.invoke(event,this);
        }
    }
}
