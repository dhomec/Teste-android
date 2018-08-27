package com.back4app.quickstartexampleapp.Telas;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.back4app.quickstartexampleapp.R;
//import com.back4app.quickstartexampleapp.util.ParseErros;
//import com.parse.ParseException;
//import com.parse.ParseUser;
//import com.parse.SignUpCallback;

public class TelaCadastro extends Activity {

    private Button btCadastrar;
    private Button btLogar;
    private EditText ctNome;
    private EditText ctSenha;
    private EditText ctEmail;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        ctNome = (EditText) findViewById(R.id.ctNomeCadastrar);
        ctSenha = (EditText) findViewById(R.id.ctSenhaCadastrar);
        ctEmail = (EditText) findViewById(R.id.ctEmailCadastrar);

        btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btLogar = (Button) findViewById(R.id.btLogar);

        //btCadastrar.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View view) {
          //      cadastrarUsuario();           }        });


        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TelaCadastro.this, TelaLogin.class));
            }
        });


    }

    //cadastrando usuarios
    //private void cadastrarUsuario() {
                //ParseUser usuario = new ParseUser();
                //usuario.setUsername( ctNome.getText().toString());
                //usuario.setPassword( ctSenha.getText().toString());
                //usuario.setEmail( ctEmail.getText().toString());

                //salvando dados do usuario
       // usuario.signUpInBackground(new SignUpCallback() {
        //@Override
        //public void done(ParseException e) {
            //if(e == null){
                //Toast.makeText(TelaCadastro.this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
                //abrirLoginUsuario();
            //}else{

                //ParseErros parseErros = new ParseErros();
                //String erro = parseErros.getErro(e.getCode());

                //Toast.makeText(TelaCadastro.this, erro, Toast.LENGTH_LONG).show();          }        }    });            }

    //depois do cadastro o usuario vai para tela de login e se depois irá para tela de lista
   // private void abrirLoginUsuario(){
    //Intent intent = new Intent(TelaCadastro.this, TelaLogin.class);
   // startActivity(intent);
   // finish();
    }










        //ParseAnalytics.trackAppOpenedInBackground(getIntent());

    /*//para criar a tabelinha e dados
    ParseObject cadastro = new ParseObject("Cadastro");
    cadastro.put("Nome", "Tereza");
    cadastro.put("Cpf", "11222000111");
    //salva e com o callback da pra retornar os dados e verificar
    cadastro.saveInBackground(new SaveCallback() {
      @Override//da pra verificar se foi salvo e no retorno apresentar mensagem
      public void done(ParseException e) {
      if(e == null){// nao temos erro
        Log.i("Salvando dados","Dados salvos com Sucesso!");
      }else{
        Log.i("Salvando dados","Dados não salvos, Verifique!");
      }
      }
    });
    */

    /*
    //para atualizar os dados ja existentes
    ParseQuery<ParseObject> Consulta = ParseQuery.getQuery("Cadastro");
    Consulta.getInBackground("vnTLCyuuVS", new GetCallback<ParseObject>() {
      @Override//quando getinbackground tem o getcallback
      public void done(ParseObject object, ParseException e) {
        if (e == null){
          object.put("Cpf", "1111111");
          object.saveInBackground();
        }else{
          Log.i("Consulta","Dados não consultado, Verifique!");
        }
      }
    });
    */

    /*
    //filtrar dados da classe pontuação
    ParseQuery<ParseObject> filtrodebanco = ParseQuery.getQuery("Cadastro");

    //filtros varios tipos de dados usando o parse
    //voce pode colocar mais de um filtro que combinem logicamente
    //filtrodebanco.whereGreaterThan("Nome", "Maria");//esse metodo é maior que na lista alfabetica
    //filtrodebanco.whereLessThan("Nome","Maria");//esse metodo traz o menor na lista alfabetica
    //filtrodebanco.whereGreaterThanOrEqualTo("Nome","Maria");//esse metodo traz o maior e o igual
    //filtrodebanco.whereEndsWith("Nome", "ia");//esse metodo traz todos os objects que terminam com "ia"
    //filtrodebanco.whereStartsWith("Nome","M");//esse metodo traz objetos que iniciam com "M"
    //filtrodebanco.addAscendingOrder("Nome");//ordena de forma acendente
    //filtrodebanco.setLimit(1);//limitando a quantidade de objetos trazidos

    filtrodebanco.findInBackground(new FindCallback<ParseObject>() {//listar os objetos dentro do filtro, trazido pelo callback
      @Override
      public void done(List<ParseObject> objects, ParseException e) {
         //testando erro sempre
        if(e == null){//exception igual a zero, sem erro
          //recuperando o tamanho da lista
         // Log.i("Listagem de dados","Dados listados na variável com Sucesso!" + objects.size());

          //percorrer todos objetos e colocar dentro da variável objects e com a estrutura for ele vai listar
          for(ParseObject object : objects){
            Log.i("Listagem de dados","Nome: " + object.get("Nome") + "Cpf: " + object.get("Cpf"));
          }

        }else{//getmessage para trazer a resposta de erro
          Log.i("Listagem de dados","Dados não listados na variável, Verifique!" + e.getMessage());
        }

      }
    });
    */














