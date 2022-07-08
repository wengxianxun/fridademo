package com.xingin.tiny.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
//import com.tencent.map.geolocation.TencentLocationListener;
import d.a.u1.c;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final Context f10642a;
    public final ConnectivityManager b;

    /* renamed from: c  reason: collision with root package name */
    public String f10643c = "unknown";

    /* renamed from: d  reason: collision with root package name */
    public final ConnectivityManager.NetworkCallback f10644d = new a();
    public final BroadcastReceiver e = new b();

    /* loaded from: classes4.dex */
    public class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            f.a(f.this);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            f.a(f.this);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f.a(f.this);
        }
    }

    public f(Context context) {
        this.f10642a = context;
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static void a(f fVar) {
        String str;
        fVar.getClass();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) c.f41295a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            str = "none";
        } else {
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                if (type != 1) {
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            str = type != 7 ? type != 9 ? "unknown" : "ethernet" : "bluetooth";
                        }
                    }
                }
                str = "wifi";
            }
            str = "mobile";
        }
        fVar.f10643c = str;
    }
}