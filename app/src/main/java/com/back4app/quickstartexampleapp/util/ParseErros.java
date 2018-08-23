package com.back4app.quickstartexampleapp.util;

import java.util.HashMap;

public class ParseErros {



    private HashMap<Integer, String> erros;

    public ParseErros() {
        this.erros = new HashMap<>();
        this.erros.put(101, "O usuário ou a senha estão inválidos");
        this.erros.put(201, "A senha não preenchida");
        this.erros.put(202, "Usuário já existe, escolha outro nome de usuário");

    }


    public String getErro(int codErro){
        return this.erros.get(codErro);
    }

}
