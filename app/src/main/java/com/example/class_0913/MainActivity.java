package com.example.class_0913;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // btn 登入程式
        Button btn_1 = findViewById(R.id.login_btn);
        btn_1.setOnClickListener ( new View.OnClickListener()   //好像JS，要完蛋了，這語法 0分
        {
            @Override
            public void onClick( View v)
            {
                EditText user_name = findViewById(R.id.edit_Name);
                EditText pd = findViewById(R.id.edit_Password);

                if( ( user_name.getText().toString().equals("Manger") )  &&  ( pd.getText().toString().equals("ABC123") ) )
                {
                    //跳轉頁面
                    Intent it = new Intent(getApplicationContext(),UserActivity.class);
                    startActivity(it);

                    //彈跳訊息
                    Toast.makeText(getApplicationContext() , "登入成功！" , Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext() , "登入失敗！" , Toast.LENGTH_LONG).show();
                }
            }

        });



    }
}