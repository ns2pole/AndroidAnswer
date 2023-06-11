package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyClickListener m = new MyClickListener();
        MyLongClickListener ml = new MyLongClickListener();
        Button b = findViewById(R.id.button);
        b.setOnClickListener(m);
        b.setOnLongClickListener(ml);
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv = findViewById(R.id.id1);
            String str = tv.getText().toString();
            Integer tmp = Integer.valueOf(str);
            tmp++;
            tv.setText(tmp.toString());
        }
    }

    private class MyLongClickListener implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View view) {
            TextView tv = findViewById(R.id.id1);
            String str = tv.getText().toString();
            Integer tmp = Integer.valueOf(str);
            tmp = tmp + 3;
            tv.setText(tmp.toString());
            return true;
        }
    }


}