package com.example.yangzhe.testleakcanary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TestSingleInstanceLeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_single_instance_leak);
        TextView textView = (TextView)findViewById(R.id.textViewSingleInstance);
        TestSingleInstanceDataModel.getSingleInstance().setmSingleInstanceTextView(textView);
    }
}
