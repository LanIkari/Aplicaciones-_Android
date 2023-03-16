package com.example.archivos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {
    public static final String NOMBRETABLA = "persona";
    private static final String NOMBREBASEDEDATOS = "BDCJAVA.db";
    private static final int VERSION = 1;

    private static final String SQLBD = " create table " + NOMBRETABLA +
            "( codigo integer primary key autoincrement ," + "nombre text not null);";


    public SQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NOMBREBASEDEDATOS, factory, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLBD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.w(SQLiteOpenHelper.class.getName(),
                "Actualizando la version de la base de datos: " + i + "a" + i1);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + NOMBRETABLA);
        onCreate(sqLiteDatabase);
    }
}
