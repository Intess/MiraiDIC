package com.kagg886.miraidic;

import com.kagg886.miraidic.helper.DICFile;
import com.kagg886.miraidic.helper.DICModule;
import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.jetbrains.annotations.NotNull;

public class DICMessageListener extends SimpleListenerHost {
    public static DICMessageListener INSTANCE = new DICMessageListener();

    @EventHandler
    public void onMessage(GroupMessageEvent event) {
        for (DICFile file : MiraiDIC.INSTANCE.dicList) {
            for (DICModule module : file.getModules()) {
                if (event.getMessage().contentToString().matches(module.getTriggerWord())) {
                    module.createSession(event).invoke();
                }
            }
        }
    }

    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        exception.printStackTrace();
    }
}
