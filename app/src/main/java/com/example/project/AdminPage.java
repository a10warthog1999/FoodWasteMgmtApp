package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminPage extends AppCompatActivity {

    EditText uname,pwd;
    Button verfiy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        uname=findViewById(R.id.uname);
        pwd=findViewById(R.id.pwd);
        verfiy=findViewById(R.id.b1);




        verfiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name="admin";
                String pass="admin";

                String s1=uname.getText().toString();
                String s2=pwd.getText().toString();


                if(s1.equals(name) && s2.equals(pass))
                {
                    Toast.makeText(getApplicationContext(),"Welcome Admin",Toast.LENGTH_SHORT).show();
                    Intent n1=new Intent(AdminPage.this,AdminWorkPage.class);
                    startActivity(n1);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Pls provide correct credentials",Toast.LENGTH_SHORT).show();
                    Intent n1=new Intent(AdminPage.this,MainActivity.class);
                    startActivity(n1);

                }

            }
        });


    }
}