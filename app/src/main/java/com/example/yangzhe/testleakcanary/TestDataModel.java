package com.example.yangzhe.testleakcanary;

import android.widget.TextView;

/**
 * Created by yangzhe on 16-5-30.
 */
public class TestDataModel {
    private static TestDataModel sDataInstance;
    private TextView mReatainedTextView;

    public static TestDataModel getsDataInstance(){
        if(sDataInstance == null){
            sDataInstance = new TestDataModel();
        }
        return sDataInstance;
    }

    public void setmReatainedTextView(TextView textView){
        mReatainedTextView = textView;
    }
}
