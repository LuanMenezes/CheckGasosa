package com.example.luan.checkgasosa.entity.Abastecimento;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luan.checkgasosa.R;

import java.util.List;

public class AbastecimentoAdapter extends RecyclerView.Adapter<AbastecimentoHolder>{
    private List<Abastecimento> listaAbastecimentos;

    public void setListaAbastecimentos(List<Abastecimento> lista) {
        this.listaAbastecimentos = lista;
    }


    public List<Abastecimento> getListaAbastecimentos(){
        return this.listaAbastecimentos;
    }

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
        Abastecimento atual = listaAbastecimentos.get(position);
        holder.renderizaNovoAbastecimento(atual);
    }

    @Override
    public int getItemCount() {
        return listaAbastecimentos.size();
    }
}