package com.back4app.quickstartexampleapp;

import com.parse.Parse;
import com.parse.ParseACL;

import android.app.Application;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Habilite armazenamento local.
        Parse.enableLocalDatastore(this);

        // Codigo de configuração do App
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("AkbNJaFTiXTpNkJRyHv3cClmopUsOkU4wlXmXoyL")
                .clientKey("gCpFAsgbHIaqs3nBI03sNTu7k6EE71DCMzL6roRo")
                .server("https://parseapi.back4app.com/")
                .build()
        );

    /*
      // Teste de configuração do App
      ParseObject pontuacao = new ParseObject("Pontuacao");
      pontuacao.put("pontos", 100);
      pontuacao.saveInBackground(new SaveCallback() {
          public void done(ParseException e) {
              if (e == null) {
                  Log.i("TesteExecucao", "Salvo com sucesso!!!");
              } else {
                  Log.i("TesteExecucao", "Falha ao salvar os dados!!!");
              }
          }
      });
    */

        //criando usuarios automaticamente entao esta desativado
        //ParseUser.enableAutomaticUser();

        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        defaultACL.setPublicReadAccess(true);
        //os dados podem ser alterados com esse metodo (Public Read+write)
        //ParseACL.setDefaultACL(defaultACL, true);
        //defaultACl deixa o Master Key Only no banco e nao consegue editar, para editar é necessario mudar






    }
}