package com.xingin.tiny.internal;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.IBinder;
import com.xingin.tiny.internal.h;
import com.xingin.tiny.internal.i;
import com.xingin.tiny.internal.mirror.types.RefObject;
import com.xingin.tiny.internal.q;
import d.a.u1.c;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* loaded from: classes4.dex */
public class q {
    public static final q iClassq = new q();

    /* renamed from: a  reason: collision with root package name */
    public Object f10663a;
    public Object b;

    /* renamed from: c  reason: collision with root package name */
    public Object f10664c;

    /* renamed from: d  reason: collision with root package name */
    public Object f10665d;
    public Object eObject;
    public final String f = c.f41295a.getPackageName();
    public String gstring;
    public boolean hbool;

    /* loaded from: classes4.dex */
    public interface a {
        PackageInfo a(String str, int i) throws PackageManager.NameNotFoundException;
    }

    public q() {
        boolean z = false;
        this.hbool = false;
        if (r.getIServiceManager == null || r.sServiceManager == null || !r.a()) {
            return;
        }
        Context context = c.f41295a;
        while (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (g.f10647a.isInstance(context)) {
            this.f10663a = new WeakReference(context);
        }
        this.hbool = this.f10663a != null ? true : z;
    }

    public static PackageInfo a(Object obj, String str, int i2) throws PackageManager.NameNotFoundException {
        PackageInfo a2 = i.a(obj, str, i2);
        return a2 != null ? a2 : c.f41295a.getPackageManager().getPackageInfo(str, i2);
    }

    public final String a(a aVar) throws PackageManager.NameNotFoundException {
        Signature[] apkContentsSigners = Build.VERSION.SDK_INT > 28 ? aVar.a(this.f, 134217728).signingInfo.getApkContentsSigners() : aVar.a(this.f, 64).signatures;
        if (apkContentsSigners == null || apkContentsSigners.length <= 0) {
            return null;
        }
        return apkContentsSigners[0].toCharsString();
    }

    public Object b() {
        if (this.eObject == null) {
            synchronized (this) {
                if (this.eObject == null) {
                    a();
                    this.eObject = e();
                }
            }
        }
        return this.eObject;
    }

    public final a c() {
        final Object d2 = d();
        if (d2 == null) {
            final PackageManager packageManager = c.f41295a.getPackageManager();
            Objects.requireNonNull(packageManager);
            return new a() { // from class: d.a.u1.d.a
                @Override // com.xingin.tiny.internal.q.a
                public final PackageInfo a(String str, int i2) throws PackageManager.NameNotFoundException {
                    return packageManager.getPackageInfo(str, i2);
                }
            };
        }
        return new a() { // from class: d.a.u1.d.b
            @Override // com.xingin.tiny.internal.q.a
            public final PackageInfo a(String str, int i2) throws PackageManager.NameNotFoundException {
                return q.a(d2, str, i2);
            }
        };
    }

    public Object d() {
        if (this.f10664c == null && this.hbool) {
            synchronized (this) {
                if (this.f10664c == null && this.hbool) {
                    this.f10664c = f();
                }
            }
        }
        return this.f10664c;
    }

    public final Object e() {
        Object obj;
        IBinder a2;
//        if (a() && (a2 = r.a(this.b, "connectivity")) != null) {
//            Object a3 = h.a.asInterface.a(a2);
//            h.f10648a = o.a(h.class, a3.getClass());
//            return a3;
//        } else

        if (e.mService == null) {
            return c.f41295a.getSystemService(Context.CONNECTIVITY_SERVICE);
        } else {
            ConnectivityManager connectivityManager = (ConnectivityManager) c.f41295a.getSystemService(Context.CONNECTIVITY_SERVICE);
            RefObject<Object> refObject = e.mService;
            refObject.getClass();
            try {
                obj = refObject.f10658a.get(connectivityManager);
            } catch (Exception unused) {
                obj = null;
            }
            h.f10648a = o.a(h.class, obj.getClass());
            return obj;
        }
    }

    public final Object f() {
        Object obj;
        if (g.mPackageManager == null || i.a.asInterface == null || !a()) {
            return null;
        }
        Context context = (Context) ((WeakReference) this.f10663a).get();
        context.getPackageManager();
        RefObject<Object> refObject = g.mPackageManager;
        refObject.getClass();
        try {
            obj = refObject.f10658a.get(context);
        } catch (Exception unused) {
            obj = null;
        }
        this.f10665d = obj;
//        IBinder a2 = r.a(this.b, "package");
//        if (a2 != null) {
//            return i.a.asInterface.a(a2);
//        }
        return null;
    }

    public final boolean a() {
        if (!this.hbool) {
            return false;
        }
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    Object a2 = r.getIServiceManager.a(new Object[0]);
                    r.sServiceManager.a(null);
                    this.b = r.getIServiceManager.a(new Object[0]);
                    r.sServiceManager.a(a2);
                }
            }
        }
        return this.b != null;
    }
}