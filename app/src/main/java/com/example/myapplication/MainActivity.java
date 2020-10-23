package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static  int REQUEST_CODE=1000;
    private int currentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentLayout=R.layout.activity_main;
        initButton();
    }
    private void initButton(){
        findViewById(R.id.btnSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            String msg;
            if (resultCode == RESULT_OK) {
                String userinput = data.getStringExtra("userinput");
                msg = "用户输入的不是1或2，未改变布局";
                if (userinput.equals("1") & (currentLayout != R.layout.activity_main)) {
                    setContentView(R.layout.activity_main);
                    currentLayout = R.layout.activity_main;
                    initButton();
                    msg = "用户输入的是1，设置为默认布局";
                } else if (userinput.equals("2") & (currentLayout == R.layout.activity_main)) {
                    setContentView(R.layout.anotherlayout);
                    currentLayout = R.layout.anotherlayout;
                    initButton();
                    msg = "用户输入的是2，设置另一个布局";
                } else {
                    msg = "用户输入的是" + userinput + "无须个改变布局！";
                }
            }
            else {
                msg="用户取消了布局选择操作!";
            }
            TextView tv =(TextView)findViewById(R.id.textShowMsg);
            tv.setText(msg);
        }
    }
//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        System.out.println("正在执行Main2Activity.onDestroy()");
//    }
//
//    @Override
//    protected void onStart(){
//        super.onStart();
//        System.out.println("正在执行Main2Activity.onStart()");
//    }
//
//    @Override
//    protected void onStop(){
//        super.onStop();
//        System.out.println("正在执行Main2Activity.onStop()");
//    }
//    @Override
//    protected void onPause(){
//        super.onPause();
//        System.out.println("正在执行Main2Activity.onPause()");
//    }
//    @Override
//    protected void onResume(){
//        super.onResume();
//        System.out.println("正在执行Main2Activity.onResume()");
//    }
//    @Override
//    protected void onRestart(){
//        super.onRestart();
//        System.out.println("正在执行Main2Activity.onRestart()");
//    }
}