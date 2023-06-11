package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyClickListener m = new MyClickListener();
        findViewById(R.id.button1).setOnClickListener(m);
        findViewById(R.id.button2).setOnClickListener(m);
        findViewById(R.id.button3).setOnClickListener(m);
        findViewById(R.id.button4).setOnClickListener(m);
        findViewById(R.id.button5).setOnClickListener(m);
        findViewById(R.id.button6).setOnClickListener(m);
        findViewById(R.id.button7).setOnClickListener(m);
        findViewById(R.id.button8).setOnClickListener(m);
        findViewById(R.id.button9).setOnClickListener(m);
        findViewById(R.id.button0).setOnClickListener(m);
        findViewById(R.id.button0).setOnClickListener(m);
        SetValSwitchListener s = new SetValSwitchListener();
        findViewById(R.id.buttonTimes).setOnClickListener(s);
        CalcListener c = new CalcListener();
        findViewById(R.id.buttonCalc).setOnClickListener(c);

    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(flag == false) {
                TextView tv = findViewById(R.id.id1);
                Button b = findViewById(view.getId());
                tv.setText(b.getText().toString());
            } else {
                TextView tv = findViewById(R.id.id2);
                Button b = findViewById(view.getId());
                tv.setText(b.getText().toString());
            }
        }
    }

    private class SetValSwitchListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(flag == false) {
                flag = true;
            } else {
                flag = false;
            }
        }
    }

    private class CalcListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv1 = findViewById(R.id.id1);
            TextView tv2 = findViewById(R.id.id2);
            TextView tv3 = findViewById(R.id.id3);
            Integer int1 = Integer.valueOf(tv1.getText().toString());
            Integer int2 = Integer.valueOf(tv2.getText().toString());
            Integer result = (int1 * int2);
            tv3.setText(result.toString());
        }
    }

}