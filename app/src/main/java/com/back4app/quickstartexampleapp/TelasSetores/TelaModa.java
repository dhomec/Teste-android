package com.back4app.quickstartexampleapp.TelasSetores;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.back4app.quickstartexampleapp.R;
import com.back4app.quickstartexampleapp.Telas.TelaLogin;
import com.back4app.quickstartexampleapp.TelasPerfil.TelaConfiguracao;
import com.back4app.quickstartexampleapp.TelasPerfil.TelaSugestoes;


public class TelaModa extends AppCompatActivity {

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_moda);

        //logo na toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbarPrincipal);
        toolbar.setLogo(R.mipmap.ic_carrim);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//para aparecer a seta retornando junto com o metodo onOptionsItemSelected


    }




    //para criar o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista, menu);
        return true;
    }

    //seleção do item dentro do menu cada um com seu metodo
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                 finish();
                return true;
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
        }
    }

    private void telaConfiguracao() {
        Intent intent = new Intent(TelaModa.this, TelaConfiguracao.class);
        startActivity(intent);

    } private void telaSugestoes() {
        Intent intent = new Intent(TelaModa.this, TelaSugestoes.class);
        startActivity(intent);

    } private void telaSair() {
        Intent intent = new Intent(TelaModa.this, TelaLogin.class);
        startActivity(intent);
    }


}
