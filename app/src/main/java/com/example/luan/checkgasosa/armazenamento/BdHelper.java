package com.example.luan.checkgasosa.armazenamento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BdHelper extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String NOME_DB = "check_gasosa";

    public BdHelper(Context context) {

        super(context, NOME_DB, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE abastecimento (" +
            "id integer primary key," +
            "kmAtual double," +
            "data text," +
            "litros double" +
            "posto text" +
            ");"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
