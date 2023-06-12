package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
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
        MyClickListener m = new MyClickListener();
        Button b = findViewById(R.id.button);
        b.setOnClickListener(m);
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv = findViewById(R.id.id1);
            tv.setText("test1");
            Toast.makeText(getApplicationContext(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }


}