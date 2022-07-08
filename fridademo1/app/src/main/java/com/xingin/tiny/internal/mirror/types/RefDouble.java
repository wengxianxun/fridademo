package com.xingin.tiny.internal.mirror.types;

import com.xingin.tiny.internal.k;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class RefDouble {
    public RefDouble(Class cls, Field field) throws NoSuchFieldException {
        k.a(cls, field.getName()).setAccessible(true);
    }
}