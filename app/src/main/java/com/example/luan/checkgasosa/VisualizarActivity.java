package com.example.luan.checkgasosa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class VisualizarActivity extends AppCompatActivity {
    private TextView tvKm;
    private TextView tvData;
    private TextView tvLitros;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        /**
         * Aqui agora ira popular o objeto para ser exibido na tela de visualização
         */
        tvKm = (TextView) findViewById(R.id.tvKm);
        tvKm.setText( "Km: " + getIntent().getStringExtra("km") );

        tvData = (TextView) findViewById(R.id.tvData);
        tvData.setText( "Data: " + getIntent().getStringExtra("data") );

        tvLitros = (TextView) findViewById(R.id.tvLitros);
        tvLitros.setText( "Litros: " + getIntent().getStringExtra("litros") );

        /**
         *  Aqui irá colocar a imagem referente a logo do posto
         *  Falta deixar de forma dinamica, verificar se vai salvar a string no DAO
         *  ou se irá salvar o INT do Drawable e chamar aqui pela int
         * */
        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        String posto = getIntent().getStringExtra("posto");
        switch (posto) {
            case "Petrobras":
                ivLogo.setImageResource(R.drawable.logo_petrobras);
                break;
            case "Ipirange":
                ivLogo.setImageResource(R.drawable.logo_ipiranga);
                break;
            case "Texaco":
                ivLogo.setImageResource(R.drawable.logo_texaco);
                break;
            case "Shell":
                ivLogo.setImageResource(R.drawable.logo_shell);
                break;
            default:
                ivLogo.setImageResource(R.drawable.logo_outros);
                break;
        }

    }

}
