package com.example.project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    EditText AdharCardNumber,FirstName,LastName,PhoneNumber;
    Button signup;
    FoodDonationDataBaseHelperClass myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        AdharCardNumber=findViewById(R.id.acn);
        FirstName=findViewById(R.id.fn);
        LastName=findViewById(R.id.ln);
        PhoneNumber=findViewById(R.id.pn);
        signup=findViewById(R.id.su);
        myDB=new FoodDonationDataBaseHelperClass(this);

        AddData();



    }

    public void AddData()
    {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res=myDB.checkifexists(AdharCardNumber.getText().toString());

                if(res.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "User doesn't exist database", Toast.LENGTH_SHORT).show();


                        boolean isinserted = myDB.insertData(AdharCardNumber.getText().toString(), FirstName.getText().toString(), LastName.getText().toString(), PhoneNumber.getText().toString());

                        if (isinserted == true)
                        {
                            Toast.makeText(getApplicationContext(), "Pls login now", Toast.LENGTH_SHORT).show();
                            Intent first = new Intent(SignUp.this, Login.class);
                            startActivity(first);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Data not inserted in database", Toast.LENGTH_SHORT).show();
                            Intent first = new Intent(SignUp.this, MainActivity.class);
                            startActivity(first);
                        }
                    }


                else
                {
                    Toast.makeText(getApplicationContext(), "User already exists", Toast.LENGTH_SHORT).show();
                    Intent first = new Intent(SignUp.this, Login.class);
                    startActivity(first);
                }

                }


        });
    }





}
