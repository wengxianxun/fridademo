package com.xingin.tiny.internal.mirror.types;

import com.xingin.tiny.internal.k;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class RefStaticObject<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Field f10661a;

    public RefStaticObject(Class<?> cls, Field field) throws NoSuchFieldException {
        Field a2 = k.a(cls, field.getName());
        this.f10661a = a2;
        a2.setAccessible(true);
    }

    public void a(T t) {
        try {
            this.f10661a.set(null, t);
        } catch (Exception unused) {
        }
    }
}