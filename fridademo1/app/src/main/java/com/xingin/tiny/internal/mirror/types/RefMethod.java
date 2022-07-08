package com.xingin.tiny.internal.mirror.types;

import com.xingin.tiny.internal.k;
import com.xingin.tiny.internal.l;
import com.xingin.tiny.internal.m;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class RefMethod<T> {

    /* renamed from: a  reason: collision with root package name */
    public Method f10657a;

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RefMethod(Class<?> cls, Field field) throws NoSuchMethodException, ClassNotFoundException {
        Method a2;
        int i = 0;
        if (field.isAnnotationPresent(l.class)) {
            l lVar = (l) field.getAnnotation(l.class);
            Class<?>[] params = lVar.params();
            while (i < params.length) {
                Class<?> cls2 = params[i];
                if (cls2.getClassLoader() == getClass().getClassLoader()) {
                    try {
                        k.a(cls2.getName());
                        params[i] = (Class) cls2.getField("TYPE").get(null);
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                }
                i++;
            }
            String method = lVar.method();
            a2 = k.a(cls, method.isEmpty() ? field.getName() : method, params);
        } else if (!field.isAnnotationPresent(m.class)) {
            Method[] a3 = k.a(cls);
            int length = a3.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method2 = a3[i];
                if (method2.getName().equals(field.getName())) {
                    this.f10657a = method2;
                    method2.setAccessible(true);
                    break;
                }
                i++;
            }
            if (this.f10657a != null) {
                throw new NoSuchMethodException(field.getName());
            }
            return;
        } else {
            m mVar = (m) field.getAnnotation(m.class);
            String[] params2 = mVar.params();
            Class[] clsArr = new Class[params2.length];
            while (i < params2.length) {
                Class<?> a4 = RefStaticMethod.a(params2[i]);
                if (a4 == null) {
                    try {
                        a4 = k.a(params2[i]);
                    } catch (Throwable unused) {
                    }
                }
                clsArr[i] = a4;
                i++;
            }
            String method3 = mVar.method();
            a2 = k.a(cls, method3.isEmpty() ? field.getName() : method3, clsArr);
        }
        this.f10657a = a2;
        a2.setAccessible(true);
        if (this.f10657a != null) {
        }
    }

    public T a(Object obj, Object... objArr) {
        try {
            return (T) this.f10657a.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            if (e.getCause() == null) {
                return null;
            }
            e.getCause();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}