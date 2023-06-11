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
    boolean displayFlag = false;
    String operator = "";

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
        SetValSwitchListener s = new SetValSwitchListener();
        findViewById(R.id.buttonPlus).setOnClickListener(s);
        findViewById(R.id.buttonMinus).setOnClickListener(s);
        findViewById(R.id.buttonTimes).setOnClickListener(s);
        findViewById(R.id.buttonDivide).setOnClickListener(s);
        CalcListener c = new CalcListener();
        findViewById(R.id.buttonCalc).setOnClickListener(c);
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv = null;
            Button b = findViewById(view.getId());
            if(displayFlag == false) {
                tv = findViewById(R.id.id1);
            } else {
                tv = findViewById(R.id.id2);
            }
            if(!tv.getText().toString().equals("0")) {
                tv.setText(tv.getText().toString() + b.getText().toString());
            } else {
                tv.setText(b.getText().toString());
            }
        }
    }

    private class SetValSwitchListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button b = findViewById(view.getId());
            if(displayFlag == false) {
                displayFlag = true;
            } else {
                displayFlag = false;
            }
            operator = b.getText().toString();
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
            Object result = null;
            if(operator.equals("+")) {
                result = int1 + int2;
            } else if(operator.equals("-")) {
                result = int1 - int2;
            } else if(operator.equals("×")) {
                result = int1 * int2;
            } else if(operator.equals("÷")) {
                if(tv2.getText().toString().equals("0")) {
                    result = "undefined";
                } else {
                    result = int1 / int2;
                }
            }
            tv3.setText(result.toString());
        }
    }

}