package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void onOk(View view) {
        Intent intent = new Intent();
        EditText editText = (EditText)findViewById(R.id.editText);
        intent.putExtra("userinput",editText.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }

    public void onCancel(View view) {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED,intent);
        finish();
    }
}