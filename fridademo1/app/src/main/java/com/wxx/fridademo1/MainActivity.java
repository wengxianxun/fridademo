package com.wxx.fridademo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.xingin.tiny.internal.t;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView textView = findViewById(R.id.test);
        Button bt = findViewById(R.id.button);

        bt.setOnClickListener((v)->{textView.setText(testFrida("ffff"));});
    }


    public String testFrida(String ff){
        com.wxx.nativedemo.MainActivity mm = new com.wxx.nativedemo.MainActivity();

        com.xingin.tiny.internal.t tt = new com.xingin.tiny.internal.t();

        t.a();
        String str = "hello worldff";
        String vv = "fff";
        str = mm.stringFromJNI();
        return str;
    }



}