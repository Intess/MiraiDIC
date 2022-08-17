package com.kagg886.miraidic.function.core;

import com.kagg886.miraidic.MiraiDIC;
import com.kagg886.miraidic.function.AbstractFunction;
import com.kagg886.miraidic.helper.DICModule;
import com.kagg886.miraidic.util.IOUtil;

import java.io.IOException;

public class Read implements AbstractFunction {
    //name default putVar
    @Override
    public void hook(DICModule module, String[] args) {
        String rtn;
        try {
            rtn = IOUtil.loadStringFromFile(IOUtil.getFilePath(MiraiDIC.INSTANCE.dataFile,"cache",args[0]));
        } catch (IOException e) {
            rtn = args[1];
        }
        module.getObjectPool().put(args[2], rtn);
    }

    @Override
    public String getRoot() {
        return "读";
    }
}
