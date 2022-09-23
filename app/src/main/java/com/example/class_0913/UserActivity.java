package com.example.class_0913;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // 跳轉 至 撥打
        Button dial_btn = findViewById(R.id.btn_dial);
        dial_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri phone = Uri.parse("tel://123456");
                Intent it = new Intent(Intent.ACTION_DIAL,phone);
                startActivity(it);
            }
        });

        // 跳轉 至 網頁首頁
        Button web_btn = findViewById(R.id.btn_HomePage);
        web_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri web = Uri.parse("https://www.google.com.tw");
                Intent it = new Intent(Intent.ACTION_VIEW,web);
                startActivity(it);
            }
        });

        //離開APP
        Button exit_btn = findViewById(R.id.btn_exit);
        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(getApplicationContext() , "成功登出！歡迎再次使用！" , Toast.LENGTH_LONG).show();
            }
        });


    }
}