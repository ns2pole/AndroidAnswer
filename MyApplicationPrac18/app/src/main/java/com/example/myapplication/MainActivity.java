package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyClickListener1 m1 = new MyClickListener1();
        Button b1 = findViewById(R.id.button1);
        b1.setOnClickListener(m1);
        MyClickListener2 m2 = new MyClickListener2();
        Button b2 = findViewById(R.id.button2);
        b2.setOnClickListener(m2);
    }

    private class MyClickListener1 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv = findViewById(R.id.id1);
            String str = tv.getText().toString();
            Integer tmp = Integer.valueOf(str);
            tmp++;
            tv.setText(tmp.toString());
        }
    }


    private class MyClickListener2 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv = findViewById(R.id.id1);
            String str = tv.getText().toString();
            Integer tmp = Integer.valueOf(str);
            tmp = tmp + 3;
            tv.setText(tmp.toString());
        }
    }


}