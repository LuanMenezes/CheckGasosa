package com.example.luan.checkgasosa.armazenamento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Classe responsavel pela criação e manutenção do DB
 */
public class BdHelper extends SQLiteOpenHelper {

    private static final int VERSAO = 2;
    private static final String NOME_DB = "check_gasosa";
    private static final String TABLE = "check_gasosa";

    public BdHelper(Context context) {

        super(context, NOME_DB, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE + "(" +
            "id integer primary key," +
            "kmAtual double," +
            "data text," +
            "litros double," +
            "posto text" +
            ");"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
