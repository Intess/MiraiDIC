package com.kagg886.miraidic.helper;

import com.kagg886.miraidic.util.IOUtil;
import com.kagg886.miraidic.util.StringUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DICFile {

    //存储功能列表
    private ArrayList<DICModule> moduleList = new ArrayList<>();
    private DICSetting setting;

    public ArrayList<DICModule> getModules() {
        return moduleList;
    }

    public DICSetting getSetting() {
        return setting;
    }

    public DICFile(File absolutePath) {
        String content;
        try {
            content = IOUtil.loadStringFromFile(absolutePath);
        } catch (IOException e) {
            throw new RuntimeException(String.format("加载文件:%s 时出现异常!"),e);
        }

        //规范化词库的排布
        content = content.replace("\r","");
        content = StringUtil.replace(content,"\n\n\n","\n\n");

        //分割并装入模块表
        String[] modules = content.split("\n\n");
        this.setting = new DICSetting(modules[0]);
        modules[0] = null;
        for (String moduleSource : modules) {
            if (moduleSource == null) {
                continue;
            }
            moduleList.add(new DICModule(moduleSource));
        }

    }
}
