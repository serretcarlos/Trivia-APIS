package com.proyecto.apis.triviaapis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by carlo on 04/05/2018.
 */

public class PunctuationDBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "PuntajeDB.db";
    private static final int DATABASE_VERSION = 1;

    public PunctuationDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                DataBaseSchema.PuntuacionesTable.TABLE_NAME +
                "(" +
                DataBaseSchema.PuntuacionesTable._ID + " INTEGER PRIMARY KEY," +
                DataBaseSchema.PuntuacionesTable.COLUMN_NAME_PUNTOS + " INTEGER," +
                DataBaseSchema.PuntuacionesTable.COLUMN_NAME_FECHA + " TEXT"+
                ")";
        Log.i("Producthelper onCreate", CREATE_PRODUCTS_TABLE);
        db.execSQL(CREATE_PRODUCTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DELETE_PRODUCTS_TABLE = "DROP TABLE IF EXISTS " +
                DataBaseSchema.PuntuacionesTable.TABLE_NAME;
        db.execSQL(DELETE_PRODUCTS_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

}
