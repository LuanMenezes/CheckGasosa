package com.example.luan.checkgasosa;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

import com.example.luan.checkgasosa.entity.Abastecimento.Abastecimento;
import com.example.luan.checkgasosa.entity.Abastecimento.AbastecimentoDao;

import java.util.Date;

public class CadastrarActivity extends FragmentActivity {

    private AbastecimentoDao abastecimentoDao = AbastecimentoDao.getInstancia();
    private EditText etKmAtual;
    private EditText etData;
    private EditText etLitros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        etKmAtual = (EditText) findViewById(R.id.etKmAtual);
        etData = (EditText) findViewById(R.id.etData);
        etLitros = (EditText) findViewById(R.id.etLitros);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void finalizarCadastro(View v) {

        double kmAtual = Double.parseDouble(etKmAtual.getText().toString());
        double litros = Double.parseDouble(etLitros.getText().toString());
        Date data = new Date(etData.getText().toString());
        Abastecimento abastecimento = new Abastecimento(kmAtual, data, litros);
        abastecimentoDao.save(abastecimento);
        finish();
    }
}
