package com.example.luan.checkgasosa;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.luan.checkgasosa.modelo.Abastecimento.Abastecimento;
import com.example.luan.checkgasosa.modelo.Abastecimento.AbastecimentoDao;

import java.util.Date;

public class CadastrarActivity extends FragmentActivity {

    private AbastecimentoDao abastecimentoDao = AbastecimentoDao.getInstancia();
    private EditText etKmAtual;
    private EditText etData;
    private EditText etLitros;
    private Spinner spPostos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        etKmAtual = (EditText) findViewById(R.id.etKmAtual);
        etData = (EditText) findViewById(R.id.etData);
        etLitros = (EditText) findViewById(R.id.etLitros);

        /**
         * Aqui faz a fuleragem do spinner para listar os postos cadastrados
         */
        spPostos = (Spinner) findViewById(R.id.spPostos);
        // Criando uma ArrayAdapter usando o array de criado no strings.xml e um spinner layout default
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista_posto, android.R.layout.simple_spinner_item);
        // Especificando o layout para ser usando quando carregar a lista de opções
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Aplicando o adapter ao spinner
        spPostos.setAdapter(adapter);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void finalizarCadastro(View v) {

        double kmAtual = Double.parseDouble(etKmAtual.getText().toString());
        double litros = Double.parseDouble(etLitros.getText().toString());
        Date data = new Date(etData.getText().toString());
        String posto = spPostos.getSelectedItem().toString();
        Log.d("DADOS KM:",etKmAtual.getText().toString());
        Log.d("DADOS LITROS:",etLitros.getText().toString());
        Log.d("DADOS DATA:",etData.getText().toString());
        Log.d("DADOS POSTO:",spPostos.getSelectedItem().toString());
        Abastecimento abastecimento = new Abastecimento(kmAtual, data, litros, posto);
        abastecimentoDao.save(abastecimento);

        finish();
    }
}
