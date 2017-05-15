package com.example.luan.checkgasosa.modelo.Abastecimento;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luan.checkgasosa.R;

import java.util.List;

public class AbastecimentoAdapter extends RecyclerView.Adapter<AbastecimentoHolder>{
    private AbastecimentoDao abastecimentoDao = AbastecimentoDao.getInstancia();
    private List<Abastecimento> listaAbastecimentos = abastecimentoDao.getAll();

    public AbastecimentoAdapter() {
    }

    @Override
    public AbastecimentoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, null);
        AbastecimentoHolder rcv = new AbastecimentoHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(AbastecimentoHolder holder, int position) {
        Abastecimento atual = abastecimentoDao.get(position);
        holder.renderizaNovoAbastecimento(atual);
    }

    @Override
    public int getItemCount() {
        return listaAbastecimentos.size();
    }
}
