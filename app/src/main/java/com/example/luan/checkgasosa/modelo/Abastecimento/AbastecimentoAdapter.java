package com.example.luan.checkgasosa.modelo.Abastecimento;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luan.checkgasosa.R;

import java.util.List;

public class AbastecimentoAdapter extends RecyclerView.Adapter<AbastecimentoHolder>{
    private AbastecimentoDao abastecimentoDao = AbastecimentoDao.getInstancia();
    private Context context;

    public AbastecimentoAdapter(Context c) {
        this.context = c;
    }

    @Override
    public AbastecimentoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_card, null);
        return new AbastecimentoHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(AbastecimentoHolder holder, int position) {
        Abastecimento atual = abastecimentoDao.get(context,position);
        holder.renderizaNovoAbastecimento(atual);
    }

    @Override
    public int getItemCount() {

        return abastecimentoDao.getAll(context).size();
    }
}
