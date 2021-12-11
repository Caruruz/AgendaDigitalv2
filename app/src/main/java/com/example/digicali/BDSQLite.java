package com.example.digicali;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDSQLite extends SQLiteOpenHelper {

    private String sql = "create table eventos(" +
            "idEventto int identity," +
            "nombreEvento varchar(40)," +
            "ubicacion varchar(60)," +
            "descripcion varchar(1000)," +
            "dia int," +
            "mes int," +
            "year int)";

    public BDSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
