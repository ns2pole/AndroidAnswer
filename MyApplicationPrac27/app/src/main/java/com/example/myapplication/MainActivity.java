package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int previousVal = 0;
    private String previousClickedButtonType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ValClickListener vcl = new ValClickListener();
        findViewById(R.id.button1).setOnClickListener(vcl);
        findViewById(R.id.button2).setOnClickListener(vcl);
        findViewById(R.id.button3).setOnClickListener(vcl);
        findViewById(R.id.button4).setOnClickListener(vcl);
        findViewById(R.id.button5).setOnClickListener(vcl);
        findViewById(R.id.button6).setOnClickListener(vcl);
        findViewById(R.id.button7).setOnClickListener(vcl);
        findViewById(R.id.button8).setOnClickListener(vcl);
        findViewById(R.id.button9).setOnClickListener(vcl);
        findViewById(R.id.button0).setOnClickListener(vcl);
        OperatorClickListener ocl = new OperatorClickListener();
        findViewById(R.id.buttonPlus).setOnClickListener(ocl);
        findViewById(R.id.buttonMinus).setOnClickListener(ocl);
        findViewById(R.id.buttonTimes).setOnClickListener(ocl);
        findViewById(R.id.buttonDivide).setOnClickListener(ocl);
        ACClickListener acl = new ACClickListener();
        findViewById(R.id.buttonAC).setOnClickListener(acl);
        CalcClickListener ccl = new CalcClickListener();
        findViewById(R.id.buttonCalc).setOnClickListener(ccl);
    }

    protected class ValClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Button b = findViewById(view.getId());
            TextView display = findViewById(R.id.display);
            if (display.getText().toString().equals("0")) {
                previousVal = Integer.parseInt(display.getText().toString());
                display.setText(b.getText().toString());
            } else if (existBothVal() && previousClickedButtonType.equals("operatorButton")) {
                previousVal = Integer.parseInt(display.getText().toString());
                display.setText(b.getText().toString());
            } else {
                display.setText(display.getText().toString() + b.getText().toString());
            }
            previousClickedButtonType = "valButton";
        }
    }

    protected class OperatorClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button b = findViewById(view.getId());
            TextView display = findViewById(R.id.display);
            TextView operator = findViewById(R.id.operator);
            if(previousClickedButtonType.equals("operatorButton")) {
                operator.setText(b.getText());
            } else {
                if (existBothVal()) {
                    String result = getCalculatedResultOf(previousVal, Integer.parseInt(display.getText().toString()), operator.getText().toString());
                    display.setText(result);
//                    display.setText(Integer.valueOf(result).toString());
                    operator.setText(b.getText());
                } else if (existOnlyDisplayVal()) {
                    operator.setText(b.getText());
                }
                previousClickedButtonType = "operatorButton";
            }
        }

        private boolean existOnlyDisplayVal() {
            TextView display = findViewById(R.id.display);
            TextView operator = findViewById(R.id.operator);
            return !display.getText().toString().equals("") && operator.getText().toString().equals("");
        }
    }

    protected class ACClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView display = findViewById(R.id.display);
            TextView operator = findViewById(R.id.operator);
            display.setText("");
            operator.setText("");
            previousVal = 0;
        }
    }


    protected class CalcClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView display = findViewById(R.id.display);
            TextView operator = findViewById(R.id.operator);
            String result = getCalculatedResultOf(previousVal, Integer.parseInt(display.getText().toString()), operator.getText().toString());
            display.setText(result);
            operator.setText("");
            previousVal = 0;
        }
    }

    private boolean existBothVal() {
        TextView display = findViewById(R.id.display);
        TextView operator = findViewById(R.id.operator);
        return !display.getText().toString().equals("") && !operator.getText().toString().equals("");
    }

    private String getCalculatedResultOf(int previousVal, int displayVal, String operator) {
        if(operator.equals("+")) {
            return Integer.valueOf(previousVal + displayVal).toString();
        } else if(operator.equals("-")) {
            return Integer.valueOf(previousVal - displayVal).toString();
        } else if(operator.equals("×")) {
            return Integer.valueOf(previousVal * displayVal).toString();
        } else if(operator.equals("÷")) {
            if(displayVal == 0) {
                return "undefined";
            } else {
                return Integer.valueOf(previousVal / displayVal).toString();
            }
        }
        return "例外エラーが発生しました。";
    }
}