package com.xingin.tiny.internal;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.xingin.tiny.internal.q;
import d.a.u1.a;
import d.a.u1.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static q f10667a;
    {
        System.loadLibrary("tiny");
    }
    public static q a() {
        if (f10667a == null) {
            f10667a = q.iClassq;
        }
        return f10667a;
    }

    public static native Object a(int i, Object... objArr);

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d7 A[Catch: all -> 0x0158, TryCatch #11 {all -> 0x0158, blocks: (B:32:0x0099, B:34:0x009f, B:37:0x00a7, B:40:0x00ae, B:43:0x00ba, B:45:0x00c0, B:48:0x00c8, B:49:0x00d1, B:51:0x00d7, B:54:0x00e0, B:57:0x00e7, B:60:0x00ec, B:62:0x0100, B:63:0x0110, B:65:0x0116, B:67:0x0120, B:68:0x0129, B:70:0x013e, B:72:0x0144, B:73:0x014a, B:74:0x014f, B:75:0x0154), top: B:188:0x0099 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object b(int i, Object... objArr) throws Throwable, MalformedURLException {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Field a2;
        List<AccessibilityServiceInfo> list;
        JSONArray jSONArray = null;
        ResolveInfo resolveInfo;
        ServiceInfo serviceInfo;
        CharSequence loadSummary;
        AccessibilityManager accessibilityManager;
        Field field = null;
        switch (i) {
            case 0:
                return c.f41295a;
            case 1:
                Context context = c.f41295a;
                try {
                    return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    return null;
                }
            case 2:
                return c.f41297d.b;
            case 3:
                ((WindowManager) c.f41295a.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
                return displayMetrics.widthPixels + "," + displayMetrics.heightPixels + "," + displayMetrics.densityDpi;
            case 4:
                return c.f41296c.f10643c;
            case 5:
                String str = (String) objArr[0];
                String str2 = (String) objArr[1];
                byte[] bArr = (byte[]) objArr[2];
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");
                    if (bArr != null) {
                        httpURLConnection.setRequestProperty("Content-Length", Integer.toString(bArr.length));
                    }
                    if (str2 != null) {
                        httpURLConnection.setRequestProperty("Content-Type", str2);
                    }
                    if (bArr != null) {
                        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                    }
                    httpURLConnection.connect();
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (bArr != null) {
                        outputStream.write(bArr);
                    }
                    outputStream.flush();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 200 || responseCode > 299) {
                        throw new IOException();
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    byte[] bArr2 = new byte[4096];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = inputStream.read(bArr2);
                            if (read == -1) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                inputStream.close();
                                outputStream.close();
                                return byteArray;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } catch (Throwable th) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            case 6:
//                a aVar = c.b.f41294c;
//                if (aVar != null) {
//                    return aVar.get();
//                }
                return null;
            case 7:
                q a3 = a();
                if (a3.gstring == null) {
                    synchronized (a3) {
                        if (a3.gstring == null) {
                            a3.a();
                            a3.gstring = a3.a(a3.c());
                        }
                    }
                }
                return a3.gstring;
            case 8:
                q a4 = a();
                a4.d();
                Object obj = a4.f10665d;
                if (obj == null) {
                    return null;
                }
                try {
                    Class<?> cls = obj.getClass();
                    try {
                        field = cls.getField("mPM");
                    } catch (NoSuchFieldException e3) {
                        while (true) {
                            try {
                                a2 = k.a(cls, "mPM");
                                if (a2 != null) {
                                    if ((!Modifier.isPublic(a2.getModifiers()) || !Modifier.isPublic(a2.getDeclaringClass().getModifiers())) && !a2.isAccessible()) {
                                        a2.setAccessible(true);
                                    }
                                }
                            } catch (NoSuchFieldException unused2) {
                                cls = cls.getSuperclass();
                                if (cls == null) {
                                    throw new p(e3);
                                }
                            }
                        }
                    }
                    return field.get(obj);
                } catch (Throwable th3) {
                    throw new p(obj.getClass().getName(), th3);
                }
            case 9:
                return h.a(c.f41295a, a().b());
            case 10:
                return Integer.valueOf(h.b(c.f41295a, a().b()));
            case 11:
//                Context context2 = c.f41295a;
//                List<String> list2 = a.f10636a;
//                if (context2 != null) {
//                    try {
//                        List<AccessibilityServiceInfo> a5 = a.a(context2);
//                        if (a5 != null && !a5.isEmpty()) {
//                            if (a.b(context2) && (accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility")) != null) {
//                                list = accessibilityManager.getEnabledAccessibilityServiceList(-1);
//                                if (list == null && !list.isEmpty()) {
//                                    jSONArray = new JSONArray();
//                                    for (AccessibilityServiceInfo accessibilityServiceInfo : a5) {
//                                        if (accessibilityServiceInfo != null && (resolveInfo = accessibilityServiceInfo.getResolveInfo()) != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
//                                            JSONObject jSONObject = new JSONObject();
//                                            String str3 = serviceInfo.packageName;
//                                            String str4 = serviceInfo.name;
//                                            JSONArray jSONArray2 = new JSONArray();
//                                            for (int capabilities = accessibilityServiceInfo.getCapabilities(); capabilities != 0; capabilities &= ~capabilities) {
//                                                jSONArray2.put(AccessibilityServiceInfo.capabilityToString(1 << Integer.numberOfTrailingZeros(capabilities)));
//                                            }
//                                            if (Build.VERSION.SDK_INT >= 26 && (loadSummary = accessibilityServiceInfo.loadSummary(context2.getPackageManager())) != null) {
//                                                jSONObject.put("acc_sum", loadSummary.toString());
//                                            }
//                                            jSONObject.put("acc_pkg", str3);
//                                            jSONObject.put("acc_name", str4);
//                                            jSONObject.put("acc_caps", jSONArray2);
//                                            if (!list.isEmpty()) {
//                                                if (list.contains(accessibilityServiceInfo)) {
//                                                    jSONObject.put("acc_enable", 1);
//                                                } else {
//                                                    jSONObject.put("acc_enable", 0);
//                                                }
//                                            }
//                                            jSONArray.put(jSONObject);
//                                        }
//                                    }
//                                }
//                                return null;
//                            }
//                            list = null;
//                            if (list == null) {
//                                return null;
//                            }
//                            jSONArray = new JSONArray();
////                            while (r13.hasNext()) {
////                            }
//                        }
//                        return null;
//                    } catch (Throwable unused3) {
//                        return null;
//                    }
//                }
                return jSONArray.toString();
            case 12:
                return k.a((String) objArr[0]);
            case 13:
                Class cls2 = (Class) objArr[0];
                String str5 = (String) objArr[1];
                Object[] objArr2 = (Object[]) objArr[2];
                Map<String, Class<?>> map = k.f10650a;
                Class[] clsArr = new Class[objArr2.length];
                for (int i2 = 0; i2 < objArr2.length; i2++) {
                    Object obj2 = objArr2[i2];
                    if (obj2 instanceof CharSequence) {
                        clsArr[i2] = k.a(obj2.toString());
                    } else if (!(obj2 instanceof Class)) {
                        throw new ClassNotFoundException("unknown parameter type: " + obj2);
                    } else {
                        clsArr[i2] = (Class) obj2;
                    }
                }
                return k.a(cls2, str5, clsArr);
            case 14:
                return k.a((Class) objArr[0], (String) objArr[1]);
            case 15:
                q a6 = a();
                String str6 = (String) objArr[0];
                int intValue = ((Integer) objArr[1]).intValue();
                q.a c2 = a6.c();
                if (str6 == null) {
                    str6 = a6.f;
                }
                return c2.a(str6, intValue);
            case 16:
                return a().d();
            default:
                return null;
        }
    }
}