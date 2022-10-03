package com.example.class_0913;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mp = MediaPlayer.create(getApplicationContext() , R.raw.dingdong);
        mp.start();

        Bundle data = this.getIntent().getExtras();
        String user_name = data.getString("account");
        int age = data.getInt("age");

        Toast.makeText(getApplicationContext() , user_name+age , Toast.LENGTH_LONG).show();

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

                Intent it = getIntent();
                Bundle data = new Bundle();
                data.putString("key","mydata");
                it.putExtras(data);
                setResult(1000,it);

                finish();
                Toast.makeText(getApplicationContext() , "成功登出！歡迎再次使用！" , Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("log", "停止撥放音樂！");
        if (mp.isPlaying()) {
            mp.stop();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("log", "暫停播放音樂！");
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("log", "重新播放音樂！");
        mp.start();
    }

}