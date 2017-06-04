package com.example.luan.checkgasosa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luan.checkgasosa.modelo.Abastecimento.Abastecimento;

/**
 * Created by Luan on 04/06/2017.
 */

public class DetailFragment  extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.interface_detail, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(getArguments()==null){
            return;
        }
        TextView tvKm = (TextView) view.findViewById(R.id.tvKmDetail);
        TextView tvLitro = (TextView) view.findViewById(R.id.tvLitroDetail);
        TextView tvData = (TextView) view.findViewById(R.id.tvData);
        ImageView ivPosto = (ImageView) view.findViewById(R.id.ivPostoDetail);

        Abastecimento abastecimento = (Abastecimento) getArguments().getSerializable("abastecimento");

        tvKm.setText(String.valueOf(abastecimento.getKmAtual()).toString());
        tvLitro.setText(String.valueOf(abastecimento.getLitros()).toString());
        tvData.setText( DateFormat.format("dd/MM/yyyy", abastecimento.getData()) );

        String posto = abastecimento.getPosto();
        ivPosto.setImageResource(abastecimento.getPostoInt(posto));
    }
}
