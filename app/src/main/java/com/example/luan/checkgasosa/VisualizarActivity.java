package com.example.luan.checkgasosa;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luan.checkgasosa.modelo.Abastecimento.Abastecimento;
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

        ListFragment list = new ListFragment();
        FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFragmento1, list);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            DetailFragment detail = new DetailFragment();
            transaction.replace(R.id.flFragmento2, detail);
        }

        transaction.commit();

//        RecyclerView rvAbastecimento = (RecyclerView)findViewById(R.id.rvAbastecimento);
//        rvAbastecimento.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
//        abastecimentoAdapter = new AbastecimentoAdapter();
//        abastecimentoAdapter.setListaAbastecimentos(Abastecimento.listaAbastecimento);
//        rvAbastecimento.setAdapter(abastecimentoAdapter);
    }

    public void onAbastecimentoSelected(Abastecimento abastecimento) {
        DetailFragment detail = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("abastecimento", abastecimento);
        detail.setArguments(bundle);

        FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            transaction.replace(R.id.flFragmento2, detail);
        }else{
            transaction.replace(R.id.flFragmento1, detail);
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }


    public void voltarParaMain(View v) {
        finish();
    }
}
