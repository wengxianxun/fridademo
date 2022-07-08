package com.xingin.tiny.internal.mirror.types;

import com.xingin.tiny.internal.k;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class RefObject<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Field f10658a;

    public RefObject(Class<?> cls, Field field) throws NoSuchFieldException {
        Field a2 = k.a(cls, field.getName());
        this.f10658a = a2;
        a2.setAccessible(true);
    }
}