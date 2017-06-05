package com.example.luan.checkgasosa;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luan.checkgasosa.modelo.Abastecimento.Abastecimento;
import com.example.luan.checkgasosa.modelo.Abastecimento.AbastecimentoAdapter;
import com.example.luan.checkgasosa.modelo.Abastecimento.AbastecimentoDao;

import java.util.List;

public class ListFragment extends Fragment {

    private OnItemSelectedListener listener;
    private AbastecimentoDao abastecimentoDao = AbastecimentoDao.getInstancia();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.inteface_list, container, false);
        RecyclerView rvAbastecimento = (RecyclerView) v.findViewById(R.id.rvAbastecimento);

        AbastecimentoAdapter abastecimentoAdapter = new AbastecimentoAdapter(container.getContext(), listener);

        rvAbastecimento.setLayoutManager(new LinearLayoutManager(v.getContext()));
        rvAbastecimento.setAdapter(abastecimentoAdapter);

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
