package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class financial extends AppCompatActivity {

    EditText adhar,amt;
    Button donate;
    FoodDonationDataBaseHelperClass myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial);

        adhar=findViewById(R.id.acnfa);
        amt=findViewById(R.id.amt);
        donate=findViewById(R.id.su);
        myDB=new FoodDonationDataBaseHelperClass(this);
        adhar.setText(myDB.getAn());
        adhar.setFocusable(false);

        DonateMoney();



    }

    public void DonateMoney()
    {
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isinserted=myDB.updateAmt(adhar.getText().toString(),amt.getText().toString());
                if(isinserted==true)
                {
                    Toast.makeText(getApplicationContext(),"Amount Donated successfully",Toast.LENGTH_SHORT).show();


                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data not inserted in database",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}