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
        tvKm.setText( getIntent().getStringExtra("km") );

        tvData = (TextView) findViewById(R.id.tvData);
        tvData.setText( getIntent().getStringExtra("data") );

        tvLitros = (TextView) findViewById(R.id.tvLitros);
        tvLitros.setText( getIntent().getStringExtra("litros") );

        /** Aqui irá colocar a imagem referente a logo do posto
         *  Falta deixar de forma dinamica, verificar se vai salvar a string no DAO
         *  ou se irá salvar o INT do Drawable e chamar aqui pela int
         * */
        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        ivLogo.setImageResource(R.drawable.logo_petrobras);
//        ivLogo.setImageDrawable(INT REFERENTE A LOGO); /* SERA UM INT CASO SEJA DESSA FORMA*/

    }

}
