package com.example.ljw.toasttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5,btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                MyToast.showToast(this,"简单文本");
                break;
            case R.id.button2:
                MyToast.showToast(this,"个人图标",true);
                break;
            case R.id.button3:
                MyToast.showToast(this,"错误图标",false);
                break;
            case R.id.button4:
                MyToast.showToast(this,"简单文本长显示", Toast.LENGTH_LONG);
                break;
            case R.id.button5:
                MyToast.showToast(this,"个人图标长显示",Toast.LENGTH_LONG,true);
                break;
            case R.id.button6:
                MyToast.showToast(this,"错误图标长显示",Toast.LENGTH_LONG,false);
                break;

        }
    }
}
