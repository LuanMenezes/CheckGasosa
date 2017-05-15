package com.example.luan.checkgasosa.entity.Abastecimento;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.luan.checkgasosa.R;
import com.example.luan.checkgasosa.VisualizarActivity;
import com.example.luan.checkgasosa.entity.Abastecimento.Abastecimento;

public class AbastecimentoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final Context context;

    private Abastecimento objAbastecimento;

    private TextView kmAtual;
    private TextView litros;
    private TextView data;
    private ImageView posto;

    public AbastecimentoHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();

        kmAtual = (TextView) itemView.findViewById(R.id.tvKm);
        litros = (TextView) itemView.findViewById(R.id.tvLitros);
        data = (TextView) itemView.findViewById(R.id.tvData);
        posto = (ImageView) itemView.findViewById(R.id.ivLogo);

        itemView.setOnClickListener(this);
    }


    public void renderizaNovoAbastecimento(Abastecimento abastecimento){
        this.kmAtual.setText( "KM: " + String.valueOf( abastecimento.getKmAtual() ) );
        this.litros.setText( "Litros: " + String.valueOf( abastecimento.getLitros() ) );
        this.data.setText( "Data: " + String.valueOf( abastecimento.getData() ) );

        String postoString =  abastecimento.getPosto();
        switch (postoString) {
            case "Petrobras":
                this.posto.setImageResource(R.drawable.logo_petrobras);
                break;
            case "Ipiranga":
                this.posto.setImageResource(R.drawable.logo_ipiranga);
                break;
            case "Texaco":
                this.posto.setImageResource(R.drawable.logo_texaco);
                break;
            case "Shell":
                this.posto.setImageResource(R.drawable.logo_shell);
                break;
            default:
                this.posto.setImageResource(R.drawable.logo_outros);
                break;
        }

        objAbastecimento = abastecimento;
    }

    @Override
    public void onClick(View v) {
        Intent intent =  new Intent(context, VisualizarActivity.class);
        intent.putExtra("km", objAbastecimento.getKmAtual());
        intent.putExtra("litros", objAbastecimento.getLitros());
        intent.putExtra("data", objAbastecimento.getData());
        intent.putExtra("posto", objAbastecimento.getPosto());

        context.startActivity(intent);
    }
}

