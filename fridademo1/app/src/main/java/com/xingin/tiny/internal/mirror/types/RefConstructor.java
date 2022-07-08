package com.xingin.tiny.internal.mirror.types;

import com.xingin.tiny.internal.k;
import com.xingin.tiny.internal.l;
import com.xingin.tiny.internal.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class RefConstructor<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Constructor<?> f10654a;

    public RefConstructor(Class<?> cls, Field field) throws NoSuchMethodException {
        Constructor<?> a2;
        if (field.isAnnotationPresent(l.class)) {
            a2 = k.a(cls, ((l) field.getAnnotation(l.class)).params());
        } else {
            int i = 0;
            if (field.isAnnotationPresent(m.class)) {
                String[] params = ((m) field.getAnnotation(m.class)).params();
                Class[] clsArr = new Class[params.length];
                while (i < params.length) {
                    try {
                        Class<?> a3 = RefStaticMethod.a(params[i]);
                        clsArr[i] = a3 == null ? k.a(params[i]) : a3;
                        i++;
                    } catch (Throwable unused) {
                    }
                }
                a2 = k.a(cls, clsArr);
            } else {
                a2 = k.a(cls, new Class[0]);
            }
        }
        this.f10654a = a2;
        Constructor<?> constructor = this.f10654a;
        if (constructor == null || constructor.isAccessible()) {
            return;
        }
        this.f10654a.setAccessible(true);
    }
}