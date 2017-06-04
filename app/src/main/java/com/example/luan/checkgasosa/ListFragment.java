package com.example.luan.checkgasosa;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luan.checkgasosa.modelo.Abastecimento.Abastecimento;
import com.example.luan.checkgasosa.modelo.Abastecimento.AbastecimentoAdapter;
import com.example.luan.checkgasosa.modelo.Abastecimento.AbastecimentoDao;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Luan on 04/06/2017.
 */

public class ListFragment extends Fragment {

    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.inteface_list, container, false);
        RecyclerView rvAbastecimento = (RecyclerView) v.findViewById(R.id.rvAbastecimento);

        Abastecimento.listaAbastecimento = new ArrayList<>();
        Abastecimento abastecimento = new Abastecimento(10000.00,new Date("10/02/2017"),50,"Ipiranga");

//        AbastecimentoAdapter abastecimentoAdapter = new AbastecimentoAdapter(listener);

//        rvAbastecimento.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        rvAbastecimento.setAdapter(abastecimentoAdapter);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnItemSelectedListener){
            this.listener = (OnItemSelectedListener) context;
        } else {

        }
    }

    public interface OnItemSelectedListener {
        void onAbastecimentoSelected(Abastecimento abastecimento);
    }
}
