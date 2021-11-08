package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Donation extends AppCompatActivity {

    Button food,money;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation);

        food=findViewById(R.id.btn1);
        money=findViewById(R.id.btn2);


        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent first=new Intent(Donation.this,FoodDonationPage.class);
                startActivity(first);


            }
        });

        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent first=new Intent(Donation.this,financial.class);
                startActivity(first);

            }
        });
    }
}
