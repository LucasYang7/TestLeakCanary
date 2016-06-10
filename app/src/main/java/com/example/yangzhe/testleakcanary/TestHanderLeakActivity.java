package com.example.yangzhe.testleakcanary;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestHanderLeakActivity extends AppCompatActivity {
    private Button btnSendMessage;
    private TextView textViewShowHandlerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_hander_leak);
        textViewShowHandlerInfo = (TextView)findViewById(R.id.textViewShowHandlerInfo);
        btnSendMessage = (Button)findViewById(R.id.buttonSendMessage);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // send a message delayed
                        Message msg = Message.obtain();
                        msg.what = 1;
                        msg.obj = "This is from sendMessage()";
                        handler.sendMessageDelayed(msg,60*1000);
                        // post a runnable delayed
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                textViewShowHandlerInfo.setText("This is a Runnable object from another thread.");
                            }
                        },15*1000);
                    }
                }).start();
            }
        });
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    textViewShowHandlerInfo.setText(msg.obj.toString());
                    break;

                default:
                    break;
            }
        }
    };
}
