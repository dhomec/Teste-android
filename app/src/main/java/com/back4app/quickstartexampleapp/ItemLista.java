package com.back4app.quickstartexampleapp;

public class ItemLista {

    private String texto;
    private int iconeRid;

    public ItemLista(){}

    public ItemLista(String texto, int iconeRid){
        this.texto = texto;
        this.iconeRid = iconeRid;
    }


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getIconeRid() {
        return iconeRid;
    }

    public void setIconeRid(int iconeRid) {
        this.iconeRid = iconeRid;
    }
}
