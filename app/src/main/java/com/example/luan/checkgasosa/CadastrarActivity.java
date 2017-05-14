package com.example.luan.checkgasosa;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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


        /**
         * TENTATIVA DE CRIAR UM SPINENR PARA LISTAR OS POSTOS
         */
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Criando uma ArrayAdapter usando o array de criado no strings.xml e um spinner layout default
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.lista_posto, android.R.layout.simple_spinner_item);
        // Especificando o layout para ser usando quando carregar a lista de opções
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Aplicando o adapter ao spinner
        spinner.setAdapter(adapter);

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
