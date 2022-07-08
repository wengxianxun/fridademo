package com.xingin.tiny.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import d.a.u1.a;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f10637a;
    public Intent b;

    /* renamed from: c  reason: collision with root package name */
    public final BroadcastReceiver f10638c = new a();


    /* loaded from: classes4.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            b.this.b = intent;
        }
    }

    public b(Context context) {
        this.f10637a = context;
    }
}