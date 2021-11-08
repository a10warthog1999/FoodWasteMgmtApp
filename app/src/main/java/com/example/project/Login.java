package com.example.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity{

    EditText AdharNo;
    Button login;
    FoodDonationDataBaseHelperClass myDB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        AdharNo=findViewById(R.id.acn);
        login=findViewById(R.id.ln);
        myDB=new FoodDonationDataBaseHelperClass(this);


        check();






    }


    public void check()
    {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=myDB.checkifexists(AdharNo.getText().toString());

                if(res.getCount() == 0)
                {
                    Toast.makeText(getApplicationContext(),"User doesn't exist database",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    myDB.setAn(AdharNo.getText().toString());
                    Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                    Intent first=new Intent(Login.this,Donation.class);
                    startActivity(first);
                }
            }
        });
    }



}
