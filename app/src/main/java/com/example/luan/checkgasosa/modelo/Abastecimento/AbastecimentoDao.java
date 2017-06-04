package com.example.luan.checkgasosa.modelo.Abastecimento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.luan.checkgasosa.armazenamento.BdHelper;

import java.util.ArrayList;
import java.util.Date;
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
        db.close();

        Abastecimento abastecimento = null;
        try{
            int kmAtualIndex = c.getColumnIndexOrThrow("kmAtual");
            double kmAtual = c.getDouble(kmAtualIndex);

            int dataIndex = c.getColumnIndexOrThrow("data");
            String data = c.getString(dataIndex);
            Date newDate = new Date(data);

            int litrosIndex = c.getColumnIndexOrThrow("litros");
            double litros = c.getDouble(litrosIndex);

            int postoIndex = c.getColumnIndexOrThrow("posto");
            String posto = c.getString(postoIndex);
            Log.d("POSTO",posto);
            abastecimento = new Abastecimento(kmAtual, newDate, litros, posto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("TESTE001", "DAO Abastecimenbto");

        // Retornar uma instancia de Abastecimento
        return abastecimento;
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

    public List<Abastecimento> getAll() {
        return abastecimentoList;
    }

}
