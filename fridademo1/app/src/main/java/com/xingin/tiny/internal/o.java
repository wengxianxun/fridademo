package com.xingin.tiny.internal;

import com.xingin.tiny.internal.mirror.types.RefBoolean;
import com.xingin.tiny.internal.mirror.types.RefConstructor;
import com.xingin.tiny.internal.mirror.types.RefDouble;
import com.xingin.tiny.internal.mirror.types.RefFloat;
import com.xingin.tiny.internal.mirror.types.RefInt;
import com.xingin.tiny.internal.mirror.types.RefLong;
import com.xingin.tiny.internal.mirror.types.RefMethod;
import com.xingin.tiny.internal.mirror.types.RefObject;
import com.xingin.tiny.internal.mirror.types.RefStaticInt;
import com.xingin.tiny.internal.mirror.types.RefStaticMethod;
import com.xingin.tiny.internal.mirror.types.RefStaticObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<Class<?>, Constructor<?>> f10662a;

    static {
        HashMap<Class<?>, Constructor<?>> hashMap = new HashMap<>();
        f10662a = hashMap;
        try {
            hashMap.put(RefObject.class, RefObject.class.getConstructor(Class.class, Field.class));
            hashMap.put(RefMethod.class, RefMethod.class.getConstructor(Class.class, Field.class));
            hashMap.put(RefInt.class, RefInt.class.getConstructor(Class.class, Field.class));
            hashMap.put(RefLong.class, RefLong.class.getConstructor(Class.class, Field.class));
            hashMap.put(RefFloat.class, RefFloat.class.getConstructor(Class.class, Field.class));
            hashMap.put(RefDouble.class, RefDouble.class.getConstructor(Class.class, Field.class));
            hashMap.put(RefBoolean.class, RefBoolean.class.getConstructor(Class.class, Field.class));
            hashMap.put(RefStaticObject.class, RefStaticObject.class.getConstructor(Class.class, Field.class));
            hashMap.put(RefStaticInt.class, RefStaticInt.class.getConstructor(Class.class, Field.class));
            hashMap.put(RefStaticMethod.class, RefStaticMethod.class.getConstructor(Class.class, Field.class));
            hashMap.put(RefConstructor.class, RefConstructor.class.getConstructor(Class.class, Field.class));
        } catch (Throwable unused) {
        }
    }

    public static <T> Class<T> a(Class<?> cls, Class<T> cls2) {
        Field[] fieldArr;
        Constructor<?> constructor;
        if (cls2 == null) {
            return null;
        }
        Map<String, Class<?>> map = k.f10650a;
        try {
            for (Field field : (Field[]) k.b.invoke(k.h, cls, new Object[0])) {
                try {
                    if (Modifier.isStatic(field.getModifiers()) && (constructor = f10662a.get(field.getType())) != null) {
                        field.setAccessible(true);
                        field.set(null, constructor.newInstance(cls2, field));
                    }
                } catch (Throwable unused) {
                }
            }
            return cls2;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw ((SecurityException) k.a(e));
        }
    }

    public static Class<?> a(Class<?> cls, String str) {
        try {
            return a(cls, k.a(str));
        } catch (Throwable unused) {
            return null;
        }
    }
}