package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FoodDonationPage extends AppCompatActivity {

    EditText description,noofpeopleitcanfeed,address,adadrcardnumber,phonenumber;
    CheckBox declare;
    Button submit;
    FoodDonationDataBaseHelperClass myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fooddonations);

        adadrcardnumber=findViewById(R.id.acn1);
        //phonenumber=findViewById(R.id.pn1);
        description=findViewById(R.id.fd);
        noofpeopleitcanfeed=findViewById(R.id.nopcf);
        address=findViewById(R.id.addr);
        declare=findViewById(R.id.c1);
        submit=findViewById(R.id.su);
        myDB=new FoodDonationDataBaseHelperClass(this);
        adadrcardnumber.setText(myDB.getAn());
        adadrcardnumber.setFocusable(false);


        AddData();



    }


    public void AddData()
    {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(declare.isChecked())
                {
                    boolean isinserted=myDB.insertDatafood(adadrcardnumber.getText().toString(),description.getText().toString(),noofpeopleitcanfeed.getText().toString(),address.getText().toString());
                    if(isinserted==true)
                    {
                        Toast.makeText(getApplicationContext(),"We will collect",Toast.LENGTH_SHORT).show();


                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Data not inserted in database",Toast.LENGTH_SHORT).show();
                    }
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"We can't serve bad food",Toast.LENGTH_SHORT).show();
                    Intent first=new Intent(FoodDonationPage.this,MainActivity.class);
                    startActivity(first);
                }

            }
        });
    }
}
