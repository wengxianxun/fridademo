package com.xingin.tiny.internal;

import android.os.Process;
import android.os.UserHandle;
import com.xingin.tiny.internal.mirror.types.RefInt;
import com.xingin.tiny.internal.mirror.types.RefStaticMethod;

/* loaded from: classes4.dex */
public class u {
    private static RefStaticMethod<Integer> getUserId;
    private static RefInt mHandle;

    static {
        o.a(u.class, UserHandle.class);
    }

    public static int a() {
        RefInt refInt = mHandle;
        if (refInt != null) {
            try {
                return refInt.f10655a.getInt(Process.myUserHandle());
            } catch (Exception unused) {
                return 0;
            }
        }
        RefStaticMethod<Integer> refStaticMethod = getUserId;
        return refStaticMethod != null ? refStaticMethod.a(Integer.valueOf(Process.myUid())).intValue() : Process.myUid() / 100000;
    }
}