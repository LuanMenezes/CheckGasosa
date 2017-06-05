package com.example.luan.checkgasosa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luan.checkgasosa.modelo.Abastecimento.AbastecimentoDao;

public class AbastecimentoAdapter extends RecyclerView.Adapter{

    private AbastecimentoDao abastecimentoDao = AbastecimentoDao.getInstancia();
    private Context context;
    private ListFragment.OnItemSelectedListener tratadorDeClique;

    public AbastecimentoAdapter(Context c, ListFragment.OnItemSelectedListener tratadorDeClique) {
        this.context = c;
        this.tratadorDeClique = tratadorDeClique;
    }

    @Override
    public AbastecimentoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_card, null);
        return new AbastecimentoHolder(layoutView, tratadorDeClique);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AbastecimentoHolder abastecimentoHolder = (AbastecimentoHolder) holder;
        position++;
        abastecimentoHolder.updateDrawerInfo(abastecimentoDao.get(context, position));
    }

    @Override
    public int getItemCount() {

        return abastecimentoDao.getAll(context).size();
    }
}
