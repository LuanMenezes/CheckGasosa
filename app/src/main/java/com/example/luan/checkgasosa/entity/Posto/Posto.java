package com.example.luan.checkgasosa.entity.Posto;

public class Posto {

    private String nome;

    private String logo;

    public Posto(String nome, String logo) {
        this.nome = nome;
        this.logo = logo;
    }

    public String getNome() {
        return nome;
    }

    public String getLogo() {
        return logo;
    }
}
