package com.example.luan.checkgasosa.entity.Abastecimento;

import java.util.ArrayList;
import java.util.Date;

public class Abastecimento {

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

//    public Posto getPosto() {
//        return posto;
//    }
}
