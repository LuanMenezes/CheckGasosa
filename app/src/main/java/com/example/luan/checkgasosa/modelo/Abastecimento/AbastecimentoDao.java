package com.example.luan.checkgasosa.modelo.Abastecimento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.luan.checkgasosa.armazenamento.BdHelper;

import java.util.ArrayList;
import java.util.List;

public class AbastecimentoDao {

    private final List<Abastecimento> abastecimentoList = new ArrayList<>();
    private static AbastecimentoDao instancia;
    private static BdHelper bdHelper;

    private AbastecimentoDao() {}

    public static AbastecimentoDao getInstancia() {
        if (instancia == null) {
            instancia = new AbastecimentoDao();
        }
        return instancia;
    }

    public void save(Context context, Abastecimento abastecimento) {
        bdHelper = new BdHelper(context);

        SQLiteDatabase bd = bdHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("kmAtual", abastecimento.getKmAtual());
        values.put("data", abastecimento.getData().toString());
        values.put("litros", abastecimento.getLitros());
        values.put("posto", abastecimento.getPosto());

        long newRowId = bd.insert("abastecimento", null, values);
    }

    public Abastecimento get(Context context, int id) {
        BdHelper bdHelper = new BdHelper(context);

        SQLiteDatabase db = bdHelper.getReadableDatabase();

        String where = "id " + " = ?";
        String[] valoresWhere = {  String.valueOf(id) };

        Cursor c = db.query(
                "abastecimento",                        // Tabela
                null,                                   // Colunas para seleção
                where,                                  // colunas WHERE
                valoresWhere,                           // valores WHERE
                null,                                   // GROUP BY
                null,                                   // FILTER BY
                null                                    // ORDER BY
        );

        c.moveToFirst();
        // Retornar uma instancia de Abastecimento
    }

    public List<Abastecimento> getAll() {
        return abastecimentoList;
    }

}
