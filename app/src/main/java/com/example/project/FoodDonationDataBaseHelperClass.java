package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodDonationDataBaseHelperClass extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Product.db";
    public static final String TABLE_NAME="fooddonation";
    public static final String COL_1="ADHARCARDNUMBER";
    public static final String COL_2="PHONENUMBER";
    public static final String COL_3="FOODDESCRIPTION";
    public static final String COL_4="NOOFPEOPLEITCANFEED";//check
    public static final String COL_5="PICKUPADDRESS";
    public static final String COL_6="AMOUNTDONATED";
    public static final String COL_7="FIRSTNAME";
    public static final String COL_8="LASTNAME";
    public static String an="";
    //public static double pn=0;



    public FoodDonationDataBaseHelperClass(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table "+TABLE_NAME+ " (ADHARCARDNUMBER LONG, PHONENUMBER TEXT, FOODDESCRIPTION TEXT, NOOFPEOPLEITCANFEED INTEGER, PICKUPADDRESS TEXT, AMOUNTDONATED LONG, FIRSTNAME TEXT, LASTNAME TEXT) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" drop table if exists "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertDatafood(String adharcardnumber,String fooddescription,String noofpeopleitcanfeed,String pickupaddress)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COL_1,adharcardnumber);
        contentValues.put(COL_3,fooddescription);
        contentValues.put(COL_4,noofpeopleitcanfeed);
        contentValues.put(COL_5,pickupaddress);
        long result= db.insert(TABLE_NAME,null,contentValues);

        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public boolean updateAmt(String adharcardnumber,String amountdonated)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,adharcardnumber);
        contentValues.put(COL_6,amountdonated);
        long res= db.update(TABLE_NAME,contentValues,"ADHARCARDNUMBER = ?",new String[] {adharcardnumber});

        if(res==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public boolean insertData(String adharcardnumber,String firstname,String lastname,String phonenumber)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,adharcardnumber);
        contentValues.put(COL_2,phonenumber);
        contentValues.put(COL_7,firstname);
        contentValues.put(COL_8,lastname);
        long result=db.insert(TABLE_NAME,null,contentValues);

        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public Cursor checkifexists(String acn)
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME+ " where ADHARCARDNUMBER = "+acn,null,null);
        return res;
    }


    public void setAn(String acn)
    {
        an=acn;
    }

    public String getAn()
    {
        return an;
    }


    public Integer delteData(String ano)
    {
        SQLiteDatabase db=getWritableDatabase();
        Integer data = db.delete(TABLE_NAME,"ADHARCARDNUMBER = ?",new String[] {ano});
        return data;
    }


    public Cursor getAllData()
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME+ " where PHONENUMBER is NOT NULL ",null,null);
        return res;
    }


    public Cursor getAllDatarelatedtofood()
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME+ " where FOODDESCRIPTION is NOT NULL ",null,null);
        return res;
    }

    public Cursor getAllDatarelatedtofinance()
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME+ " where AMOUNTDONATED is NOT NULL ",null,null);
        return res;
    }



}
