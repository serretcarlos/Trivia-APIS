package com.proyecto.apis.triviaapis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;


/**
 * Created by carlo on 04/05/2018.
 */

public class PunctuationOperations {
    private SQLiteDatabase db;
    private PunctuationDBHelper dbHelper;
    private Punctuation punctuation;

    public PunctuationOperations(Context context){
        dbHelper = new PunctuationDBHelper(context);
    }

    public void open() throws SQLException{
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLException e){
            Log.e("SQLOPEN", e.toString());
        }
    }

    public void close() {
        db.close();
    }

    public long addPunctuation(Punctuation punctuation){
        long newRowId = 0;
        try {
            ContentValues values = new ContentValues();
            values.put(DataBaseSchema.PuntuacionesTable.COLUMN_NAME_PUNTOS, punctuation.getmPunctation());
            values.put(DataBaseSchema.PuntuacionesTable.COLUMN_NAME_FECHA, punctuation.getmDate());
            newRowId = db.insert(DataBaseSchema.PuntuacionesTable.TABLE_NAME, null,  values);
        } catch (SQLException e){
            Log.e("SQLADD", e.toString());
        }
        return newRowId;
    }

    public ArrayList<Punctuation> getAllPunctuations() {
        ArrayList<Punctuation> listaPunctuations = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + DataBaseSchema.PuntuacionesTable.TABLE_NAME;
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()){
                do {
                    punctuation = new Punctuation(
                            Integer.parseInt(cursor.getString(1)),
                            cursor.getString(2));
                    listaPunctuations.add(punctuation);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (SQLException e){
            Log.e("SQLList", e.toString());
        }
        return listaPunctuations;
    }
}
