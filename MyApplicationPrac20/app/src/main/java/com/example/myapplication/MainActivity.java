package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.util.Log;
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
//
        MyClickListener3 m3 = new MyClickListener3();
        Button b3 = findViewById(R.id.button3);
        b3.setOnClickListener(m3);

        MyClickListener4 m4 = new MyClickListener4();
        Button b4 = findViewById(R.id.button4);
        b4.setOnClickListener(m4);

        TextView tv = findViewById(R.id.id1);
        Log.d(tv.getText().toString(), tv.getText().toString());
    }

    private class MyClickListener1 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv = findViewById(R.id.id1);
            Log.d(tv.getText().toString(), tv.getText().toString());
            tv.setText("10");
        }
    }


    private class MyClickListener2 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv = findViewById(R.id.id2);
            tv.setText("20");
        }
    }


    private class MyClickListener3 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv1 = findViewById(R.id.id1);
            TextView tv2 = findViewById(R.id.id2);
            TextView tv3 = findViewById(R.id.id3);
            Integer int1 = Integer.valueOf(tv1.getText().toString());
            Integer int2 = Integer.valueOf(tv2.getText().toString());
            Integer product = int1 * int2;
            String str = Integer.valueOf(product).toString();
            tv3.setText(str); ;
        }
    }

    private class MyClickListener4 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv1 = findViewById(R.id.id1);
            TextView tv2 = findViewById(R.id.id2);
            TextView tv3 = findViewById(R.id.id3);
            tv1.setText("0");
            tv2.setText("0");
            tv3.setText("0");
        }
    }

//

}