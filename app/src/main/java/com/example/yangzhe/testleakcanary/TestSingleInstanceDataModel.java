package com.example.yangzhe.testleakcanary;

import android.widget.TextView;

/**
 * updated by yangzhe on 16-6-10.
 */
public class TestSingleInstanceDataModel {
    private static TestSingleInstanceDataModel sDataInstance;
    private TextView mSingleInstanceTextView;

    public static TestSingleInstanceDataModel getSingleInstance(){
        if(sDataInstance == null){
            sDataInstance = new TestSingleInstanceDataModel();
        }
        return sDataInstance;
    }

    public void setmSingleInstanceTextView(TextView textView){
        mSingleInstanceTextView = textView;
    }
}
