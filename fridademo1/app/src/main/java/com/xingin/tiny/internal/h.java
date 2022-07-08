package com.xingin.tiny.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import com.xingin.tiny.internal.mirror.types.RefConstructor;
import com.xingin.tiny.internal.mirror.types.RefLong;
import com.xingin.tiny.internal.mirror.types.RefMethod;
import com.xingin.tiny.internal.mirror.types.RefStaticMethod;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f10648a;
    private static RefMethod<Network[]> getAllNetworks;
    private static RefMethod<LinkProperties> getLinkProperties;
    @l(method = "getNetworkCapabilities", params = {Network.class})
    private static RefMethod<NetworkCapabilities> getNetworkCapabilities1;
    @l(method = "getNetworkCapabilities", params = {Network.class, String.class})
    private static RefMethod<NetworkCapabilities> getNetworkCapabilities2;
    @l(method = "getNetworkCapabilities", params = {Network.class, String.class, String.class})
    private static RefMethod<NetworkCapabilities> getNetworkCapabilities3;
    private static RefMethod<NetworkInfo> getNetworkInfoForNetwork;
    private static RefMethod<NetworkInfo> getNetworkInfoForUid;

    /* loaded from: classes4.dex */
    public static class a {
        public static RefStaticMethod<Object> asInterface;

        static {
            o.a(a.class, "android.net.IConnectivityManager$Stub");
        }
    }

    public static boolean a(Object obj) {
        if (f10648a == null) {
            if (obj == null) {
                return false;
            }
            synchronized (h.class) {
                if (f10648a == null) {
                    f10648a = o.a(h.class, obj.getClass());
                }
            }
        }
        return f10648a != null;
    }

    public static LinkProperties[] a(Context context, Object obj) {
        Network[] b;
        NetworkInfo networkInfo;
        int type;
        NetworkInfo a2 = null;
        if (getLinkProperties == null || (b = b(obj)) == null) {
            return null;
        }
        LinkProperties[] linkPropertiesArr = new LinkProperties[18];
        for (Network network : b) {
            if (a(obj) && !(getNetworkInfoForUid == null && getNetworkInfoForNetwork == null)) {
                RefMethod<NetworkInfo> refMethod = getNetworkInfoForUid;
                if (refMethod != null) {
                    a2 = refMethod.a(obj, network, Integer.valueOf(Process.myUid()), Boolean.FALSE);
                } else {
                    RefMethod<NetworkInfo> refMethod2 = getNetworkInfoForNetwork;
                    if (refMethod2 != null) {
                        a2 = refMethod2.a(obj, network);
                    }
                }
                networkInfo = a2;
                type = networkInfo.getType();
                if (type >= 0 && type < 18) {
                    linkPropertiesArr[type] = getLinkProperties.a(obj, network);
                }
            }
            networkInfo = a(context, obj, network);
            type = networkInfo.getType();
            if (type >= 0) {
                linkPropertiesArr[type] = getLinkProperties.a(obj, network);
            }
        }
        return linkPropertiesArr;
    }

    public static int b(Context context, Object obj) {
        long j;
        Network[] b;
        NetworkCapabilities networkCapabilities;
        NetworkCapabilities networkCapabilities2 = null;
        RefMethod<NetworkCapabilities> refMethod;
        RefMethod<NetworkCapabilities> refMethod2;
        int i;
        Object[] objArr = null;
        if ((a(obj) && (((i = Build.VERSION.SDK_INT) >= 30 && getNetworkCapabilities3 != null) || getNetworkCapabilities1 != null || (i >= 29 && getNetworkCapabilities2 != null))) && (b = b(obj)) != null) {
            NetworkCapabilities[] networkCapabilitiesArr = new NetworkCapabilities[b.length];
            int length = b.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                Network network = b[i2];
                int i4 = i3 + 1;
                if (a(obj)) {
                    int i5 = Build.VERSION.SDK_INT;
                    if (i5 < 30 || (refMethod2 = getNetworkCapabilities3) == null) {
                        RefMethod<NetworkCapabilities> refMethod3 = getNetworkCapabilities1;
                        if (refMethod3 != null) {
                            networkCapabilities2 = refMethod3.a(obj, network);
                        } else if (i5 >= 29 && (refMethod = getNetworkCapabilities2) != null) {
                            networkCapabilities2 = refMethod.a(obj, network, context.getOpPackageName());
                        }
                    } else {
                        networkCapabilities2 = refMethod2.a(obj, network, context.getOpPackageName(), context.getAttributionTag());
                    }
                    networkCapabilities = networkCapabilities2;
                    networkCapabilitiesArr[i3] = networkCapabilities;
                    i2++;
                    i3 = i4;
                }
                networkCapabilities = null;
                networkCapabilitiesArr[i3] = networkCapabilities;
                i2++;
                i3 = i4;
            }
            objArr = networkCapabilitiesArr;
        }
        if (objArr == null) {
            return 0;
        }
        int i6 = 0;
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                RefLong refLong = n.mTransportTypes;
                refLong.getClass();
                try {
                    j = refLong.f10656a.getLong(obj2);
                } catch (Exception unused) {
                    j = 0;
                }
                if (j >= 0) {
                    i6 = (int) (i6 | j);
                }
            }
        }
        return i6;
    }

    public static Network[] b(Object obj) {
        RefMethod<Network[]> refMethod;
        if (!a(obj) || (refMethod = getAllNetworks) == null) {
            return null;
        }
        return refMethod.a(obj, new Object[0]);
    }

    public static NetworkInfo a(Context context, Object obj, Network network) {
        Object obj2;
        if (e.f10641a == null) {
            synchronized (e.class) {
                if (e.f10641a == null) {
                    RefConstructor<ConnectivityManager> refConstructor = e.ctor;
                    Object[] objArr = {context, obj};
                    refConstructor.getClass();
                    try {
                        obj2 = refConstructor.f10654a.newInstance(objArr);
                    } catch (Throwable unused) {
                        obj2 = null;
                    }
                    e.f10641a = (ConnectivityManager) obj2;
                }
            }
        }
        return e.f10641a.getNetworkInfo(network);
    }
}