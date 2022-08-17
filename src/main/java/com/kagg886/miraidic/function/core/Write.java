package com.kagg886.miraidic.function.core;

import com.kagg886.miraidic.MiraiDIC;
import com.kagg886.miraidic.function.AbstractFunction;
import com.kagg886.miraidic.helper.DICModule;
import com.kagg886.miraidic.util.IOUtil;

import java.io.IOException;

public class Write implements AbstractFunction {

    //name str
    @Override
    public void hook(DICModule module, String[] args) {
        try {
            IOUtil.writeStringToFile(IOUtil.getFilePath(MiraiDIC.INSTANCE.dataFile,"cache",args[0]),args[1]);
        } catch (IOException ignored) {}
    }

    @Override
    public String getRoot() {
        return "写";
    }
}
