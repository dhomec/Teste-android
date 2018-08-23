package com.back4app.quickstartexampleapp.TelasPerfil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.back4app.quickstartexampleapp.R;

public class TelaConfiguracao extends AppCompatActivity {




    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_configuracao);


        //logo na toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbarPrincipal);
        toolbar.setLogo(R.mipmap.ic_carrim);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//para aparecer a seta retornando junto com o metodo onOptionsItemSelected


    }


    //para criar o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return (true);
    }








}
