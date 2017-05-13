package com.example.luan.checkgasosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
