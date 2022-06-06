package com.wxx.nativedemo;

public class MainActivity {
    public  native String stringFromJNI();

    {
        System.loadLibrary("nativedemo");
    }


}
