package com.example.luan.checkgasosa;

import android.app.DialogFragment;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.luan.checkgasosa.modelo.Abastecimento.Abastecimento;
import com.example.luan.checkgasosa.modelo.Abastecimento.AbastecimentoDao;

import java.text.ParseException;
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void finalizarCadastro(View v) {

        if (!dadosValidos()) {
            return;
        }
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    private boolean dadosValidos() {

        int violations = 0;
        if (etKmAtual.getText().toString().trim().length() <= 0) {
            etKmAtual.setError("Não pode ser vazio");
            Log.d("KM ATUAL VAZIO:", "VAZIO");
            violations++;
        }

        if (etLitros.getText().toString().trim().length() <= 0) {
            etLitros.setError("Não pode ser vazio");
            Log.d("LITROS VAZIO:", "VAZIO");
            violations++;
        }

        if (etData.getText().toString().trim().length() <= 0) {
            etData.setError("Não pode ser vazio");
            Log.d("DATA VAZIA:", "VAZIO");
            violations++;
        }

        if (violations > 0) {
            return false;
        }

        try {
            double kmAtual = Double.parseDouble(etKmAtual.getText().toString());
        } catch (NumberFormatException e) {
            etKmAtual.setError("Informe um valor decimal");
            Log.d("KM ATUAL INVALIDO:", etKmAtual.getText().toString());
            violations++;
        }

        try {
            double litros = Double.parseDouble(etLitros.getText().toString());
        } catch (NumberFormatException e) {
            etLitros.setError("Informe um valor decimal");
            Log.d("LITROS INVALIDO:", etLitros.getText().toString());
            violations++;
        }

        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            format.setLenient(false);
            format.parse(etData.getText().toString());
        } catch (ParseException p) {
            etData.setError("Informe uma data válida em formato mm/dd/yyyy");
            Log.d("DATA INVALIDA:", etData.getText().toString());
            violations++;
        }

        if (violations > 0) {
            return false;
        }

        if (Double.parseDouble(etKmAtual.getText().toString()) < 0) {
            etKmAtual.setError("Informe um valore positivo");
            violations++;
        }

        if (Double.parseDouble(etLitros.getText().toString()) < 0) {
            etLitros.setError("Informe um valore positivo");
            violations++;
        }

        if (violations > 0) {
            return false;
        }

        if (abastecimentoDao.getAll().size() > 0) {
            Abastecimento ultimoAbastecimento = abastecimentoDao.get((abastecimentoDao.getAll().size()) - 1);
            if (ultimoAbastecimento.getKmAtual() > Double.parseDouble(etKmAtual.getText().toString())) {
                etKmAtual.setError("A Quilometragem atual não pode ser menor do que a última informada (" + String.format("%.1f", ultimoAbastecimento.getKmAtual()) + ")");
                Log.d("KM ATUAL MENOR ANTERIO:", etKmAtual.getText().toString());
                violations++;
            }
        }

        return violations < 1;
    }
}
