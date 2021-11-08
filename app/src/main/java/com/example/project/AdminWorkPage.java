package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminWorkPage extends AppCompatActivity {


    Button deleteuserbt,viewfooddonations,viewfinancialdonations,displayusers;
    FoodDonationDataBaseHelperClass myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_work_page);

        deleteuserbt=findViewById(R.id.deleteuser);
        displayusers=findViewById(R.id.displayalluser);
        viewfooddonations=findViewById(R.id.vfd);
        viewfinancialdonations=findViewById(R.id.vfinad);
        myDB=new FoodDonationDataBaseHelperClass(this);


        deleteuserbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent first = new Intent(AdminWorkPage.this, AdminDeletesaUser.class);
                startActivity(first);
            }
        });

        DisplayData();
        DisplayDataforfooddonation();
        DisplayDataforfinancialdonation();


    }

    public void DisplayData()
    {
        displayusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res=myDB.getAllData();


                if(res.getCount() == 0)
                {
                    showmessage("Error","No data available");
                }
                StringBuffer Buffer=new StringBuffer();

                while(res.moveToNext())
                {
                    Buffer.append("Adhar No:"+res.getString(0)+"\n");
                    Buffer.append("Phone No:"+res.getString(1)+"\n");
                    //if(!res.getString(1).equals(null))
                    Buffer.append("First Name:"+res.getString(6)+"\n");
                    Buffer.append("Sur Name:"+res.getString(7)+"\n");

                }


                showmessage("Data",Buffer.toString());



            }
        });
    }

    public void showmessage(String Title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();
    }

    public void DisplayDataforfooddonation()
    {
        viewfooddonations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res=myDB.getAllDatarelatedtofood();


                if(res.getCount() == 0)
                {
                    showmessage("Error","No data available");
                }
                StringBuffer Buffer=new StringBuffer();

                while(res.moveToNext())
                {
                    Buffer.append("Adhar No:"+res.getString(0)+"\n");
                    Buffer.append("Food Description:"+res.getString(2)+"\n");
                    Buffer.append("No of people:"+res.getString(3)+"\n");
                    Buffer.append("Pickup Addr:"+res.getString(4)+"\n");
                }


                showmessage("Data",Buffer.toString());


            }
        });
    }


    public void DisplayDataforfinancialdonation()
    {
        viewfinancialdonations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res=myDB.getAllDatarelatedtofinance();


                if(res.getCount() == 0)
                {
                    showmessage("Error","No data available");
                }
                StringBuffer Buffer=new StringBuffer();

                while(res.moveToNext())
                {
                    Buffer.append("Adhar No:"+res.getString(0)+"\n");
                    Buffer.append("Amount donated:"+res.getString(5)+"\n");
                }


                showmessage("Data",Buffer.toString());

            }
        });
    }




}

