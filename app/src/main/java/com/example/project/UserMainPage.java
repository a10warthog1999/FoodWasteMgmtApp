package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserMainPage extends AppCompatActivity {

    Button login,signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermainpage);

        login=findViewById(R.id.ub1);
        signup=findViewById(R.id.ub2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent first=new Intent(UserMainPage.this,SignUp.class);
                startActivity(first);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent first=new Intent(UserMainPage.this,Login.class);
                startActivity(first);

            }
        });


        


    }
}
