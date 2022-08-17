package com.kagg886.miraidic;

import com.kagg886.miraidic.function.AbstractFunction;
import com.kagg886.miraidic.function.core.Read;
import com.kagg886.miraidic.function.core.Write;
import com.kagg886.miraidic.function.core.putVar;
import com.kagg886.miraidic.helper.DICFile;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.utils.MiraiLogger;

import java.io.File;
import java.util.ArrayList;

public final class MiraiDIC extends JavaPlugin {
    public static final MiraiDIC INSTANCE = new MiraiDIC();

    public final String configFile = getConfigFolder() + File.separator;

    public final String dataFile = getDataFolder() + File.separator;


    //存放dic对象
    public ArrayList<DICFile> dicList = new ArrayList<>();

    //存放指令的解释器
    public ArrayList<AbstractFunction> functionList = new ArrayList<>();

    public MiraiLogger logger = getLogger();

    private MiraiDIC() {
        super(new JvmPluginDescriptionBuilder("com.kagg886.miraidic", "0.0.1")
                .name("MiraiDIC")
                .author("kagg886")
                .build());
    }

    @Override
    public void onEnable() {
        logger.info("插件开始加载dic!");
        File dicDictionaryPath = new File(configFile + "dicList");
        if (!dicDictionaryPath.isDirectory()) {
            dicDictionaryPath.mkdirs();
        }
        for (File dic : dicDictionaryPath.listFiles()) {
            DICFile file;
            try {
                file = new DICFile(dic);
                dicList.add(file);
            } catch (Exception e) {
                logger.error(e);
                continue;
            }
            getLogger().info(String.format("DIC加载完毕!\n名称:%s(%s)\n版本:%s\n描述:%s",
                    file.getSetting().getName(),
                    file.getSetting().getAuthor(),
                    file.getSetting().getVersion(),
                    file.getSetting().getDescription()));

        }
        getLogger().info("DIC全部加载完成!");

        getLogger().info("开始加载核心指令实现!");
        functionList.add(new Read());
        functionList.add(new Write());
        functionList.add(new putVar());
        getLogger().info("核心指令实现加载完成!");
        GlobalEventChannel.INSTANCE.registerListenerHost(DICMessageListener.INSTANCE);
    }
}