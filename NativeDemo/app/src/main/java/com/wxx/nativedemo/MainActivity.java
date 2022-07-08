package com.wxx.nativedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

import com.wxx.nativedemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'nativedemo' library on application startup.
    static {
        System.loadLibrary("nativedemo");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
System.out.println("测试");
        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());

        String string = "";
        try {
            string = Settings.Secure.getString(this.getContentResolver(), "android_id");
        } catch (Throwable th) {

        }
        System.out.println("=========="+string);

    }

    /**
     * A native method that is implemented by the 'nativedemo' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}