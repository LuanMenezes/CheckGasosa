package com.example.luan.checkgasosa.modelo.Abastecimento;

import android.widget.ImageView;

import com.example.luan.checkgasosa.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Abastecimento implements Serializable {

    public static ArrayList<Abastecimento> listaAbastecimento;

    private double kmAtual;

    private Date data;

    private double litros;

    private String posto;

    public Abastecimento(double kmAtual, Date data, double litros, String posto) {
        this.kmAtual = kmAtual;
        this.data = data;
        this.litros = litros;
        this.posto = posto;
    }

    public double getKmAtual() {
        return kmAtual;
    }

    public Date getData() {
        return data;
    }

    public double getLitros() {
        return litros;
    }

    public String getPosto() {
        return posto;
    }

    public int getPostoInt(String posto){
        int ivPosto;
        switch (posto) {
            case "Petrobras":
                ivPosto = R.drawable.logo_petrobras;
                break;
            case "Ipiranga":
                ivPosto = R.drawable.logo_ipiranga;
                break;
            case "Texaco":
                ivPosto = R.drawable.logo_texaco;
                break;
            case "Shell":
                ivPosto = R.drawable.logo_shell;
                break;
            default:
                ivPosto = R.drawable.logo_outros;
                break;
        }

        return ivPosto;
    }
}
