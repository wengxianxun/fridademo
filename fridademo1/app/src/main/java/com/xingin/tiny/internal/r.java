package com.xingin.tiny.internal;

import android.os.IBinder;
import com.xingin.tiny.internal.mirror.types.RefStaticMethod;
import com.xingin.tiny.internal.mirror.types.RefStaticObject;
import java.util.Map;

/* loaded from: classes4.dex */
public class r {
    public static RefStaticMethod<Object> getIServiceManager;
    private static RefStaticMethod<IBinder> getService;
    private static RefStaticMethod<IBinder> rawGetService;
    public static RefStaticObject<Map<String, IBinder>> sCache;
    public static RefStaticObject<Object> sServiceManager;

    static {
        o.a(r.class, "android.os.ServiceManager");
    }

//    public static IBinder a(Object obj, String str) {
//        Object obj2;
//        Object obj3;
//        if (j.getService != null) {
//            if (obj == null) {
//                obj = getIServiceManager.a(new Object[0]);
//            }
//            return c.a(j.getService.a(obj, str));
//        }
//        IBinder iBinder = null;
//        if (obj != null) {
//            obj2 = getIServiceManager.a(new Object[0]);
//            sServiceManager.a(obj);
//        } else {
//            obj2 = null;
//        }
//        try {
//            RefStaticMethod<IBinder> refStaticMethod = rawGetService;
//            if (refStaticMethod != null) {
//                iBinder = c.a(refStaticMethod.a(str));
//            } else if (getService != null) {
//                RefStaticObject<Map<String, IBinder>> refStaticObject = sCache;
//                refStaticObject.getClass();
//                try {
//                    obj3 = refStaticObject.f10661a.get(null);
//                } catch (Exception unused) {
//                    obj3 = null;
//                }
//                Map map = (Map) obj3;
//                IBinder iBinder2 = (IBinder) map.remove(str);
//                IBinder a2 = getService.a(str);
//                if (iBinder2 != null) {
//                    map.put(str, iBinder2);
//                } else {
//                    map.remove(str);
//                }
//                iBinder = a2;
//            }
//        } catch (Throwable unused2) {
//        }
//        if (obj != null) {
//            sServiceManager.a(obj2);
//        }
//        return iBinder;
//    }

    public static boolean a() {
        return (j.getService == null && rawGetService == null && (sCache == null || getService == null)) ? false : true;
    }
}