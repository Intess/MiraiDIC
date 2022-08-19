package com.kagg886.miraidic.function.core;

import com.kagg886.miraidic.function.AbstractFunction;
import com.kagg886.miraidic.helper.DICSession;

public class putVar implements AbstractFunction {
    @Override
    //name input
    public void hook(DICSession module, String[] args) {
        module.getObjectPool().put(args[0], args[1]);
    }

    @Override
    public String getRoot() {
        return "存变量";
    }
}
