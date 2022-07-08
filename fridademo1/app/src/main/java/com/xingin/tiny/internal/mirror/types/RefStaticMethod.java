package com.xingin.tiny.internal.mirror.types;

import com.adjust.sdk.Constants;
import com.xingin.tiny.internal.k;
import com.xingin.tiny.internal.l;
import com.xingin.tiny.internal.m;
//import d.e.b.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class RefStaticMethod<T> {

    /* renamed from: a  reason: collision with root package name */
    public Method f10659a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10660c;

    /* JADX WARN: Removed duplicated region for block: B:54:0x0107 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RefStaticMethod(Class<?> cls, Field field) throws NoSuchMethodException, ClassNotFoundException {
        Method method;
        Class<?> cls2;
        this.f10660c = field.getName();
        this.b = cls.getName();
        int i = 0;
        if (field.isAnnotationPresent(l.class)) {
            l lVar = (l) field.getAnnotation(l.class);
            Class<?>[] params = lVar.params();
            while (i < params.length) {
                Class<?> cls3 = params[i];
                if (cls3.getClassLoader() == getClass().getClassLoader()) {
                    try {
                        k.a(cls3.getName());
                        params[i] = (Class) cls3.getField("TYPE").get(null);
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                }
                i++;
            }
            String method2 = lVar.method();
            method = k.a(cls, method2.isEmpty() ? field.getName() : method2, params);
            this.f10659a = method;
        } else if (!field.isAnnotationPresent(m.class)) {
            Method[] a2 = k.a(cls);
            int length = a2.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method3 = a2[i];
                if (method3.getName().equals(field.getName())) {
                    this.f10659a = method3;
                    method3.setAccessible(true);
                    break;
                }
                i++;
            }
            if (this.f10659a != null) {
                throw new NoSuchMethodException(field.getName());
            }
            return;
        } else {
            m mVar = (m) field.getAnnotation(m.class);
            String[] params2 = mVar.params();
            Class[] clsArr = new Class[params2.length];
            Class[] clsArr2 = new Class[params2.length];
            boolean z = false;
            while (i < params2.length) {
                Class<?> a3 = a(params2[i]);
                if (a3 == null) {
                    try {
                        a3 = k.a(params2[i]);
                    } catch (Throwable unused) {
                    }
                }
                clsArr[i] = a3;
                if ("java.util.HashSet".equals(params2[i])) {
                    try {
                        cls2 = k.a("android.util.ArraySet");
                    } catch (Throwable unused2) {
                        cls2 = a3;
                    }
                    if (cls2 != null) {
                        clsArr2[i] = cls2;
                    } else {
                        clsArr2[i] = a3;
                    }
                    z = true;
                } else {
                    clsArr2[i] = a3;
                }
                i++;
            }
            String method4 = mVar.method();
            method4 = method4.isEmpty() ? field.getName() : method4;
            try {
                this.f10659a = k.a(cls, method4, clsArr);
            } catch (Throwable unused3) {
                if (z) {
                    this.f10659a = k.a(cls, method4, clsArr2);
                }
            }
            method = this.f10659a;
        }
        method.setAccessible(true);
        if (this.f10659a != null) {
        }
    }

    public static Class<?> a(String str) {
        if (str.equals("int")) {
            return Integer.TYPE;
        }
        if (str.equals(Constants.LONG)) {
            return Long.TYPE;
        }
        if (str.equals("boolean")) {
            return Boolean.TYPE;
        }
        if (str.equals("byte")) {
            return Byte.TYPE;
        }
        if (str.equals("short")) {
            return Short.TYPE;
        }
        if (str.equals("char")) {
            return Character.TYPE;
        }
        if (str.equals("float")) {
            return Float.TYPE;
        }
        if (str.equals("double")) {
            return Double.TYPE;
        }
        if (!str.equals("void")) {
            return null;
        }
        return Void.TYPE;
    }

    public T a(Object... objArr) {
        try {
            return (T) this.f10659a.invoke(null, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static StringBuilder U0(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }
    public static String F0(StringBuilder sb, boolean z, char c2) {
        sb.append(z);
        sb.append(c2);
        return sb.toString();
    }

    public String toString() {
        StringBuilder U0 = U0("RefStaticMethod{");
        U0.append(this.b);
        U0.append("@");
        U0.append(this.f10660c);
        U0.append(" find=");
        return F0(U0, this.f10659a != null, '}');
    }
}