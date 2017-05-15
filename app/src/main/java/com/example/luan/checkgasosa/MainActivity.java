package com.example.luan.checkgasosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.luan.checkgasosa.modelo.Abastecimento.Abastecimento;
import com.example.luan.checkgasosa.modelo.Abastecimento.AbastecimentoAdapter;
import com.example.luan.checkgasosa.modelo.Abastecimento.AbastecimentoDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AbastecimentoAdapter abastecimentoAdapter;
    private AbastecimentoDao abastecimentoDao = AbastecimentoDao.getInstancia();
    private TextView tvAutonomia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        List<Abastecimento> abastecimentos = abastecimentoDao.getAll();
        tvAutonomia = (TextView) findViewById(R.id.tvAutonomia);
        double autonomia = 0;

        if (abastecimentos.size() > 0) {
            Abastecimento ultimoAbastecimento = abastecimentoDao.get((abastecimentos.size() - 1));
            Abastecimento primeiroAbastecimento = abastecimentoDao.get(0);
            Log.d("DADOS KM ULTIMO ABASTE:", String.valueOf(ultimoAbastecimento.getKmAtual()));
            Log.d("DADOS KM PRIMEIRO ABAS:", String.valueOf(primeiroAbastecimento.getKmAtual()));
            double totalKmPercorridos = ultimoAbastecimento.getKmAtual() - primeiroAbastecimento.getKmAtual();

            double litrosAbastecidos = 0;
            for (int i = 0; abastecimentos.size() > i; i++) {
                litrosAbastecidos += abastecimentos.get(i).getLitros();
            }

            if (litrosAbastecidos > 0) {
                autonomia = totalKmPercorridos / litrosAbastecidos;
            }

            Log.d("DADOS KM PERCORRIDOS:", String.valueOf(totalKmPercorridos));
            Log.d("DADOS LITROS ABASTECID:", String.valueOf(litrosAbastecidos));
        }

        Log.d("DADOS AUTONOMIA:", String.valueOf(autonomia));
        tvAutonomia.setText(String.format("%.1f", autonomia) + " km/l");
    }

    /** Chamada para a view de visualizacao dos registros*/
    public void visualizar(View v){
        Intent intent = new Intent(this, VisualizarActivity.class);
        startActivity(intent);
    }

    /** Chamada para a view de Cadastro de registro*/
    public void cadastrar(View v) {
        Intent intent = new Intent(this, CadastrarActivity.class);
        startActivity(intent);
    }
}
