package com.kagg886.miraidic.function;

import com.kagg886.miraidic.helper.DICSession;

public interface AbstractFunction {
    void hook(DICSession module, String[] args);
    String getRoot();
}
