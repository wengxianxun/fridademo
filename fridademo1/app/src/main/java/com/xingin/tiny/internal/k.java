package com.xingin.tiny.internal;

import com.adjust.sdk.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Class<?>> f10650a;
    public static Method b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f10651c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f10652d;
    public static Method e;
    public static Method f;
    public static Method g;
    public static Method h;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f10650a = concurrentHashMap;
        concurrentHashMap.put("int", Integer.TYPE);
        concurrentHashMap.put(Constants.LONG, Long.TYPE);
        concurrentHashMap.put("boolean", Boolean.TYPE);
        concurrentHashMap.put("byte", Byte.TYPE);
        concurrentHashMap.put("short", Short.TYPE);
        concurrentHashMap.put("char", Character.TYPE);
        concurrentHashMap.put("float", Float.TYPE);
        concurrentHashMap.put("double", Double.TYPE);
        concurrentHashMap.put("void", Void.TYPE);
        concurrentHashMap.put("String", String.class);
        concurrentHashMap.put("int[]", int[].class);
        concurrentHashMap.put("long[]", long[].class);
        concurrentHashMap.put("boolean[]", boolean[].class);
        concurrentHashMap.put("byte[]", byte[].class);
        concurrentHashMap.put("short[]", short[].class);
        concurrentHashMap.put("char[]", char[].class);
        concurrentHashMap.put("float[]", float[].class);
        concurrentHashMap.put("double[]", double[].class);
        concurrentHashMap.put("String[]", String[].class);
        try {
            b = Method.class.getDeclaredMethod("invoke", Object.class, Object[].class);
        } catch (NoSuchMethodException unused) {
        }
        try {
            f10651c = Class.class.getDeclaredMethod("forName", String.class);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
        } catch (NoSuchMethodException unused3) {
        }
        try {
            Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
        } catch (NoSuchMethodException unused4) {
        }
        try {
            f10652d = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
        } catch (NoSuchMethodException unused5) {
        }
        try {
            e = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
        } catch (NoSuchMethodException unused6) {
        }
        try {
            f = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
        } catch (NoSuchMethodException unused7) {
        }
        try {
            g = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException unused8) {
        }
        try {
            h = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
        } catch (NoSuchMethodException unused9) {
        }
    }

    public static <T> Class<T> a(String str) throws ClassNotFoundException {
        try {
            Class<T> cls = (Class) ((ConcurrentHashMap) f10650a).get(str);
            return cls != null ? cls : (Class) b.invoke(f10651c, null, new Object[]{str});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw ((ClassNotFoundException) a(e2));
        }
    }

    public static Throwable a(Throwable th) {
        Throwable cause;
        while ((th instanceof InvocationTargetException) && (cause = th.getCause()) != null) {
            th = cause;
        }
        return th;
    }

    public static <T> Constructor<T> a(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        try {
            return (Constructor) b.invoke(f10652d, cls, new Object[]{clsArr});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            Throwable a2 = a(e2);
            if (!(a2 instanceof NoSuchMethodException)) {
                throw ((SecurityException) a2);
            }
            throw ((NoSuchMethodException) a2);
        }
    }

    public static Field a(Class<?> cls, String str) throws NoSuchFieldException {
        try {
            return (Field) b.invoke(g, cls, new Object[]{str});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw ((NoSuchFieldException) a(e2));
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
        try {
            return (Method) b.invoke(e, cls, new Object[]{str, clsArr});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            Throwable a2 = a(e2);
            if (!(a2 instanceof NoSuchMethodException)) {
                throw ((SecurityException) a2);
            }
            throw ((NoSuchMethodException) a2);
        }
    }

    public static Method[] a(Class<?> cls) throws SecurityException {
        try {
            return (Method[]) b.invoke(f, cls, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw ((SecurityException) a(e2));
        }
    }
}