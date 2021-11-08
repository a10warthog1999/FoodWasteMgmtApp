package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminDeletesaUser extends AppCompatActivity {


    EditText number;
    Button delete;
    FoodDonationDataBaseHelperClass myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_deletesa_user);

        number=findViewById(R.id.tobd);
        delete=findViewById(R.id.del);
        myDB=new FoodDonationDataBaseHelperClass(this);

        delData();




    }


    public void delData()
    {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer deleterowno = myDB.delteData(number.getText().toString());
                if(deleterowno >0)
                {
                    Toast.makeText(getApplicationContext(),"User deleted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"User not deleted in database",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}