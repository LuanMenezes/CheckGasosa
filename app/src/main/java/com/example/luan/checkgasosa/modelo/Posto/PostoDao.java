package com.example.luan.checkgasosa.modelo.Posto;

import java.util.ArrayList;
import java.util.List;

public class PostoDao {

    private final List<Posto> postoList = new ArrayList<>();
    private static PostoDao instancia;

    private PostoDao() {}

    public static PostoDao getInstancia() {
        if (instancia == null) {
            instancia = new PostoDao();
        }
        return instancia;
    }

    public void save(Posto posto) {
        postoList.add(posto);
    }

    public Posto get(int index) {
        return postoList.get(index);
    }

    public List<Posto> getAll() {
        return postoList;
    }

}
