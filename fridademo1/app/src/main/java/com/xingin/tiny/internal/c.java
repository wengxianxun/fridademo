package com.xingin.tiny.internal;

import android.os.Binder;
import android.os.IBinder;
import com.xingin.tiny.internal.mirror.types.RefBoolean;
import com.xingin.tiny.internal.mirror.types.RefStaticMethod;

/* loaded from: classes4.dex */
public class c {
    private static RefStaticMethod<IBinder> allowBlocking;

    static {
        o.a(c.class, Binder.class);
    }

    public static IBinder a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        RefStaticMethod<IBinder> refStaticMethod = allowBlocking;
        if (refStaticMethod != null) {
            return refStaticMethod.a(iBinder);
        }
        if (d.mWarnOnBlocking != null && d.f10640a.isInstance(iBinder)) {
            RefBoolean refBoolean = d.mWarnOnBlocking;
            refBoolean.getClass();
            try {
                refBoolean.f10653a.setBoolean(iBinder, false);
            } catch (Exception unused) {
            }
        }
        return iBinder;
    }
}