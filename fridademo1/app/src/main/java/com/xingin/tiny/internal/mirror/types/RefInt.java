package com.xingin.tiny.internal.mirror.types;

import com.xingin.tiny.internal.k;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class RefInt {

    /* renamed from: a  reason: collision with root package name */
    public final Field f10655a;

    public RefInt(Class cls, Field field) throws NoSuchFieldException {
        Field a2 = k.a(cls, field.getName());
        this.f10655a = a2;
        a2.setAccessible(true);
    }
}