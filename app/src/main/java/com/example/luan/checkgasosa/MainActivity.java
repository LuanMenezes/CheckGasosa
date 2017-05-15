package com.example.luan.checkgasosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.luan.checkgasosa.entity.Abastecimento.Abastecimento;
import com.example.luan.checkgasosa.entity.Abastecimento.AbastecimentoAdapter;
import com.example.luan.checkgasosa.entity.Abastecimento.AbastecimentoDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AbastecimentoAdapter abastecimentoAdapter;
    private AbastecimentoDao abastecimentoDao = AbastecimentoDao.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        abastecimentoDao.save(new Abastecimento(900, new Date("14/5/2017"), 32, "Texaco"));
        abastecimentoDao.save(new Abastecimento(910, new Date("15/5/2017"), 31, "Ipiranga"));
        abastecimentoDao.save(new Abastecimento(920, new Date("16/5/2017"), 30, "Outros"));
        abastecimentoDao.save(new Abastecimento(930, new Date("17/5/2017"), 34, "Shell"));
    }

    /** Chamada para a view de visualizacao dos registros*/
    public void visualizar(View v){
        // Todos os abastecimentos
        List<Abastecimento> abastecimentos = AbastecimentoDao.getInstancia().getAll();
        Intent intent = new Intent(this, VisualizarActivity.class);
        startActivity(intent);
    }

    /** Chamada para a view de Cadastro de registro*/
    public void cadastrar(View v) {
        Intent intent = new Intent(this, CadastrarActivity.class);
        startActivity(intent);
    }
}
