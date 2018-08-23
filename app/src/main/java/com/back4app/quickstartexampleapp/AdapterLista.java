package com.back4app.quickstartexampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterLista extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<ItemLista> itens;

    public AdapterLista(Context context, ArrayList<ItemLista> itens){
        //itens que preenchem o listview
        this.itens = itens;
        //responsavel por pegar o layout do item
        mInflater = LayoutInflater.from(context);
            }


    @Override//retorna a quantidade de itens
    public int getCount() {
        return itens.size();
    }

    @Override//retorna o item de acordo com a posicao dele
    public ItemLista getItem(int position) {
        return itens.get(position);
    }

    @Override//sem implementação
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //pega o item de acordo com a posição
        ItemLista item = itens.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_lista, null);

        //atraves do layout pego pelo LayoutInflater, pegamos cada id relacionado ao item e damos informação
        ((TextView) view.findViewById(R.id.textView2)).setText(item.getTexto());
        ((ImageView) view.findViewById(R.id.imageView3)).setImageResource(item.getIconeRid());


        return view;
    }
}
