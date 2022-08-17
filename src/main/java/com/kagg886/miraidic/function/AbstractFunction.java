package com.kagg886.miraidic.function;

import com.kagg886.miraidic.helper.DICModule;

public interface AbstractFunction {
    void hook(DICModule module,String[] args);
    String getRoot();
}
