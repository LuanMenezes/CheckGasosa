package com.example.luan.checkgasosa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luan.checkgasosa.modelo.Abastecimento.AbastecimentoAdapter;
import com.example.luan.checkgasosa.modelo.Abastecimento.AbastecimentoDao;

public class VisualizarActivity extends AppCompatActivity {
    private TextView tvKm;
    private TextView tvData;
    private TextView tvLitros;
    private ImageView ivLogo;

    private AbastecimentoAdapter abastecimentoAdapter;
    private AbastecimentoDao abastecimentoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView rvAbastecimento = (RecyclerView)findViewById(R.id.rvAbastecimento);
        rvAbastecimento.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        abastecimentoAdapter = new AbastecimentoAdapter();
//        abastecimentoAdapter.setListaAbastecimentos(Abastecimento.listaAbastecimento);
//        abastecimentoAdapter.setListaAbastecimentos(Abastecimento.listaAbastecimento);
        rvAbastecimento.setAdapter(abastecimentoAdapter);
    }

}
