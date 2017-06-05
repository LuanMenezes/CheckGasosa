package com.example.luan.checkgasosa.modelo.Abastecimento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.luan.checkgasosa.armazenamento.BdHelper;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
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

        SQLiteDatabase bd = bdHelper.getReadableDatabase();

        String where = "id " + " = ?";
        String[] valoresWhere = {  String.valueOf(id) };

        Cursor c = bd.query(
                "abastecimento",                        // Tabela
                null,                                   // Colunas para seleção
                where,                                  // colunas WHERE
                valoresWhere,                           // valores WHERE
                null,                                   // GROUP BY
                null,                                   // FILTER BY
                null                                    // ORDER BY
        );

        c.moveToFirst();
        bd.close();

        Abastecimento abastecimento = null;
        try{
            int kmAtualIndex = c.getColumnIndexOrThrow("kmAtual");
            double kmAtual = c.getDouble(kmAtualIndex);

            int dataIndex = c.getColumnIndexOrThrow("data");
            String data = c.getString(dataIndex);
            ParsePosition pos = new ParsePosition(0);
            SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE MMM d HH:mm:ss zz yyyy");
            Date newDate = simpledateformat.parse(data, pos);

            int litrosIndex = c.getColumnIndexOrThrow("litros");
            double litros = c.getDouble(litrosIndex);

            int postoIndex = c.getColumnIndexOrThrow("posto");
            String posto = c.getString(postoIndex);
            abastecimento = new Abastecimento(kmAtual, newDate, litros, posto);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public List<Abastecimento> getAll(Context context) {
        bdHelper = new BdHelper(context);
        SQLiteDatabase bd = bdHelper.getReadableDatabase();

        ArrayList<Abastecimento> abastecimentos = new ArrayList<Abastecimento>();

        Cursor c = bd.rawQuery("SELECT * from abastecimento", null);

        c.moveToFirst();
        bd.close();

        do {
            Abastecimento abastecimento = null;
            try{
                int kmAtualIndex = c.getColumnIndexOrThrow("kmAtual");
                double kmAtual = c.getDouble(kmAtualIndex);
                Log.d("ABSTDAO GET ALL kmAtual", String.valueOf(kmAtual));

                int dataIndex = c.getColumnIndexOrThrow("data");
                String data = c.getString(dataIndex);
                Log.d("ABSTDAO GET ALL DATA: ", data);
                ParsePosition pos = new ParsePosition(0);
                SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE MMM d HH:mm:ss zz yyyy");
                Date newDate = simpledateformat.parse(data, pos);

                int litrosIndex = c.getColumnIndexOrThrow("litros");
                double litros = c.getDouble(litrosIndex);

                int postoIndex = c.getColumnIndexOrThrow("posto");
                String posto = c.getString(postoIndex);
                abastecimento = new Abastecimento(kmAtual, newDate, litros, posto);

                abastecimentos.add(abastecimento);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (c.moveToNext());

        c.close();

        return abastecimentos;
    }

}
