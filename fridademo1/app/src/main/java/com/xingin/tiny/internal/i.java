package com.xingin.tiny.internal;

import android.content.pm.PackageInfo;
import com.xingin.tiny.internal.mirror.types.RefMethod;
import com.xingin.tiny.internal.mirror.types.RefStaticMethod;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f10649a;
    @l(method = "getPackageInfo", params = {String.class, int.class})
    private static RefMethod<PackageInfo> getPackageInfo2;
    @l(method = "getPackageInfo", params = {String.class, int.class, int.class})
    private static RefMethod<PackageInfo> getPackageInfo3;
    @l(method = "getPackageInfo", params = {String.class, long.class, int.class})
    private static RefMethod<PackageInfo> getPackageInfoT;

    /* loaded from: classes4.dex */
    public static class a {
        public static RefStaticMethod<Object> asInterface;

        static {
            o.a(a.class, "android.content.pm.IPackageManager$Stub");
        }
    }

    public static PackageInfo a(Object obj, String str, int i) {
        PackageInfo a2;
        if (obj == null) {
            return null;
        }
        if (f10649a == null) {
            synchronized (i.class) {
                if (f10649a == null) {
                    f10649a = o.a(i.class, obj.getClass());
                }
            }
        }
        RefMethod<PackageInfo> refMethod = getPackageInfo2;
        if (refMethod != null) {
            a2 = refMethod.a(obj, str, Integer.valueOf(i));
        } else {
            RefMethod<PackageInfo> refMethod2 = getPackageInfo3;
            if (refMethod2 != null) {
                a2 = refMethod2.a(obj, str, Integer.valueOf(i), Integer.valueOf(u.a()));
            } else {
                RefMethod<PackageInfo> refMethod3 = getPackageInfoT;
                if (refMethod3 == null) {
                    return null;
                }
                a2 = refMethod3.a(obj, str, Integer.valueOf(i), Integer.valueOf(u.a()));
            }
        }
        return a2;
    }
}