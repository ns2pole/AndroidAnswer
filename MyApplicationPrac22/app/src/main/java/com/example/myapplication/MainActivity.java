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

    }

    private class MyClickListener1 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv = findViewById(R.id.id1);
            Button b = findViewById(R.id.button1);
            String str = tv.getText().toString();
            tv.setText(str + b.getText().toString());
        }
    }


}