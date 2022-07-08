package d.a.u1;

import android.content.Context;
import android.view.MotionEvent;
import com.xingin.tiny.internal.b;
import com.xingin.tiny.internal.f;
import com.xingin.tiny.internal.t;
import java.util.Objects;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Context f41295a = null;
    public static b b = null;

    /* renamed from: c  reason: collision with root package name */
    public static f f41296c = null;

    /* renamed from: d  reason: collision with root package name */
    public static b f41297d = null;
    public static volatile boolean e = false;

    public static void onTouchEvent(MotionEvent motionEvent) {
        Objects.requireNonNull(motionEvent);
        if (!e) {
            return;
        }
        t.a(4, motionEvent);
    }
}