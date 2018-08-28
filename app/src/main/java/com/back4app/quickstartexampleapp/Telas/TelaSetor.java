package com.back4app.quickstartexampleapp.Telas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.back4app.quickstartexampleapp.AdapterLista;
import com.back4app.quickstartexampleapp.ItemLista;
import com.back4app.quickstartexampleapp.R;
import com.back4app.quickstartexampleapp.TelasSetores.TelaModa;
import com.back4app.quickstartexampleapp.TelasSetores.TelaEletronicos;
import com.back4app.quickstartexampleapp.TelasSetores.TelaAlimentacao;
import com.back4app.quickstartexampleapp.TelasSetores.TelaFarmacias;
import com.back4app.quickstartexampleapp.TelasSetores.TelaDomestico;
import com.back4app.quickstartexampleapp.TelasSetores.TelaAutomotivo;
import com.back4app.quickstartexampleapp.TelasSetores.TelaBeleza;
import com.back4app.quickstartexampleapp.TelasPerfil.TelaConfiguracao;
import com.back4app.quickstartexampleapp.TelasPerfil.TelaSugestoes;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class TelaSetor extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {




    private ListView lista;
    private AdapterLista adapter;
    private ArrayList<ItemLista> itens;


    private FirebaseAuth autenticacao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_setor2);

        autenticacao = FirebaseAuth.getInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.logodeli);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(adapter);
        //Define listener para quando clicar no item
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0: telaFarmacias();
                        break;

                    case 1: telaAutomotivo();
                        break;

                    case 2: telaBeleza();
                        break;

                    case 3: telaDomestico();
                        break;

                    case 4: telaAlimentacao();
                        break;

                    case 5: telaEletronicos();
                        break;

                    case 6: telaModa();
                        break;
                }
            }
        });


        createLista();

    }

    private void telaFarmacias() {
        Intent intent = new Intent(TelaSetor.this, TelaFarmacias.class);
        startActivity(intent);

    }
    private void telaAutomotivo() {
        Intent intent = new Intent(TelaSetor.this, TelaAutomotivo.class);
        startActivity(intent);
    }
    private void telaBeleza() {
        Intent intent = new Intent(TelaSetor.this, TelaBeleza.class);
        startActivity(intent);
    }
    private void telaDomestico() {
        Intent intent = new Intent(TelaSetor.this, TelaDomestico.class);
        startActivity(intent);
    }
    private void telaAlimentacao() {
        Intent intent = new Intent(TelaSetor.this, TelaAlimentacao.class);
        startActivity(intent);
    }
    private void telaEletronicos() {
        Intent intent = new Intent(TelaSetor.this, TelaEletronicos.class);
        startActivity(intent);
    }
    private void telaModa() {
        Intent intent = new Intent(TelaSetor.this, TelaModa.class);
        startActivity(intent);
    }


    private void createLista() {
        //criamos nossa lista que preenchera o listview
        itens = new ArrayList<ItemLista>();
        ItemLista item1 = new ItemLista("ALIMENTAÇÃO", R.mipmap.ic_alimentacao);
        ItemLista item2 = new ItemLista("AUTOMOTIVO", R.mipmap.ic_automotivo);
        ItemLista item3 = new ItemLista("BELEZA", R.mipmap.ic_beleza);
        ItemLista item4 = new ItemLista("DOMÉSTICO", R.mipmap.ic_domestico);
        ItemLista item5 = new ItemLista("ELETRONICOS", R.mipmap.ic_eletronico);
        ItemLista item6 = new ItemLista("FARMÁCIAS", R.mipmap.ic_farmacia);
        ItemLista item7 = new ItemLista("MODA", R.mipmap.ic_moda);


        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);

        //cria o adapter
        adapter = new AdapterLista(this, itens);

        //define o adapter
        lista.setAdapter(adapter);

        //cor quando a lista é selecionada para rolagem
        lista.setCacheColorHint(Color.TRANSPARENT);

    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //pega o item que foi selecionado
        ItemLista item = adapter.getItem(i);
        //demonstração
        Toast.makeText(this, "Você clicou em: " + item.getTexto(), Toast.LENGTH_LONG).show();

    }


    private void telaConfiguracao() {
        Intent intent = new Intent(TelaSetor.this, TelaConfiguracao.class);
        startActivity(intent);

    } private void telaSugestoes() {
        Intent intent = new Intent(TelaSetor.this, TelaSugestoes.class);
        startActivity(intent);

    } private void telaSair() {
       deslogarUsuario();

    }

    public void deslogarUsuario(){

        autenticacao.signOut();

        Intent intent = new Intent(TelaSetor.this, TelaLogin.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //para criar o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.tela_lista_lixo2, menu);

        //toolbar simples
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //reações do menu simples
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_configuracoes:
                telaConfiguracao();
                return true;
            case R.id.action_sugestoes:
                telaSugestoes();
                return true;
            case R.id.action_sair:
                telaSair();
                return true;


            default:
                return super.onOptionsItemSelected(item);





    }}


    //reações do menu deslizante
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.

    //noinspection SimplifiableIfStatement
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_perfil) {
            // Handle the camera action
        } else if (id == R.id.nav_pontos) {

        } else if (id == R.id.nav_lixos) {

        } else if (id == R.id.nav_enderecos) {

        } else if (id == R.id.nav_denuncias) {

        } else if (id == R.id.nav_parceiros) {

        } else if (id == R.id.nav_desenvolvedores) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
