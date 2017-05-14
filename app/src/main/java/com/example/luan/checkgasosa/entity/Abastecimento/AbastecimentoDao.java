package com.example.luan.checkgasosa.entity.Abastecimento;

import java.util.ArrayList;
import java.util.List;

public class AbastecimentoDao {

    private final List<Abastecimento> abastecimentoList = new ArrayList<>();
    private static AbastecimentoDao instancia;

    private AbastecimentoDao() {}

    public static AbastecimentoDao getInstancia() {
        if (instancia == null) {
            instancia = new AbastecimentoDao();
        }
        return instancia;
    }

    public void save(Abastecimento abastecimento) {
        abastecimentoList.add(abastecimento);
    }

    public Abastecimento get(int index) {
        return abastecimentoList.get(index);
    }

    public List<Abastecimento> getAll() {
        return abastecimentoList;
    }

}
