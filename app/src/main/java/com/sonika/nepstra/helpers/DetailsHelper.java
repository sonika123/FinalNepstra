package com.sonika.nepstra.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sonika.nepstra.pojo.Details_pojo;

import java.util.ArrayList;

/**
 * Created by sonika on 10/26/2017.
 */

public class DetailsHelper extends SQLiteOpenHelper {
    static int DATABASE_VERSION = 1;
    static String DATABASE_NAME = "details";

    String DETAILS_TABLE = "CREATE TABLE if not exists `details`  (\n" +
            "                       `id` INTEGER PRIMARY KEY ,\n" +
            "                       `c_id` INTEGER,\n" +
            "                       `name` TEXT,\n" +
            "                       `price` TEXT,\n" +
            "                       `desc` TEXT,\n" +
            "                       `imageone` TEXT\n" +
            "                      );";

    public DetailsHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase().execSQL(DETAILS_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertdetails(ContentValues cv) {
        getWritableDatabase().insert("details", "", cv);
        Log.e("details", "yes");

    }

    public ArrayList<Details_pojo> getdetails() {
        Log.e("getOrderMessage", "vaeraxa");
        String sql = "select * from details";
        ArrayList<Details_pojo> list = new ArrayList<Details_pojo>();
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Log.e("movettonext", "lolo");
            // Do Somehing here
            Details_pojo orderinfo = new Details_pojo();
            orderinfo.detailsid = cursor.getInt(cursor.getColumnIndex("id"));
            orderinfo.detailscid = cursor.getInt(cursor.getColumnIndex("c_id"));
            orderinfo.detailsname = cursor.getString(cursor.getColumnIndex("name"));
            orderinfo.detailsprice = cursor.getString(cursor.getColumnIndex("price"));
            orderinfo.detailsdesc = cursor.getString(cursor.getColumnIndex("desc"));
            orderinfo.detailsimage = cursor.getString(cursor.getColumnIndex("imageone"));
            list.add(orderinfo);
        }
        cursor.close();
        return list;
    }
}



