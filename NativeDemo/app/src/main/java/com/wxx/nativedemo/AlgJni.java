package com.wxx.nativedemo;

public class AlgJni {

    static {
        System.loadLibrary("nativedemo");
    }
    public native static String GetTest(String filePath);
}
