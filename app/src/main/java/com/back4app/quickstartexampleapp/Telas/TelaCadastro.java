package com.back4app.quickstartexampleapp.Telas;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.back4app.quickstartexampleapp.DAO.ConfiguracaoFirebase;
import com.back4app.quickstartexampleapp.R;
import com.back4app.quickstartexampleapp.util.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.back4app.quickstartexampleapp.util.ParseErros;
//import com.parse.ParseException;
//import com.parse.ParseUser;
//import com.parse.SignUpCallback;

public class TelaCadastro extends Activity {

    private Button btCadastrar;
    private Button btLogar;
    private EditText ctNome;
    private EditText ctSenha1;
    private EditText ctSenha2;
    private EditText ctEmail;


    private FirebaseAuth autenticacao;
    //depois de importar a biblioteca da firebase referencia ambas as classes para utilizar o database firebase
    private FirebaseDatabase database;
    private DatabaseReference referencia;

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        ctNome = (EditText) findViewById(R.id.ctNomeCadastrar);
        ctSenha1 = (EditText) findViewById(R.id.ctSenhaCadastrar);
        ctSenha2 = (EditText) findViewById(R.id.ctRepetirSenha);
        ctEmail = (EditText) findViewById(R.id.ctEmailCadastrar);

        btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btLogar = (Button) findViewById(R.id.btLogar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //se as senhas forem iguais, poderá cadastrar usuario
                if (ctSenha1.getText().toString().equals(ctSenha2.getText().toString())) {

                    usuario = new Usuario();
                    usuario.setEmail(ctEmail.getText().toString());
                    usuario.setSenha(ctSenha1.getText().toString());
                    usuario.setNome(ctNome.getText().toString());

                    cadastrarUsuario();

                } else {
                    Toast.makeText(TelaCadastro.this, "As Senhas não conferem", Toast.LENGTH_LONG).show();
                }

            }
        });


        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaCadastro.this, TelaLogin.class));
            }
        });


    }

    private void cadastrarUsuario() {
    //pegando a verificação se a autenticação é nula ou não
    autenticacao = ConfiguracaoFirebase.getFirebaseAuth();

    autenticacao.createUserWithEmailAndPassword(
            usuario.getEmail(),
            usuario.getSenha()).addOnCompleteListener(TelaCadastro.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //task é o resultado se positivo ou negativo quanto a criação
                    if (task.isSuccessful()){

                       insereUsuario(usuario);

                    }else{//tratamento de erros

                        String erroExcecao = "";
                        try {
                        throw task.getException();
                        }catch (FirebaseAuthWeakPasswordException e){
                        erroExcecao = "Digite uma senha mais forte, contendo no mínimo 8 caracteres e que contenha letras e números";
                        }catch (FirebaseAuthInvalidCredentialsException e){
                        erroExcecao = "O E-mail é inválido, digite um novo E-mail.";
                        }catch (FirebaseAuthUserCollisionException e){
                        erroExcecao = "O E-mail já está cadastrado!";
                        }catch (Exception e) {
                        erroExcecao = "Erro ao efetuar cadastro!";
                            e.printStackTrace();
                        }
                        Toast.makeText(TelaCadastro.this, "Erro"+erroExcecao, Toast.LENGTH_SHORT);
                    }
                }
            });   }



    private boolean insereUsuario (Usuario usuario){
        try {

            referencia = ConfiguracaoFirebase.getFirebase().child("usuarios");//o firebase trabalha com nó, que é semelhante a tabela.
            referencia.push().setValue(usuario);//gera uma chave como se fosse uma primary key, ajuda no cadastro de dados ao mesmo tempo




            abrirteladedentro();
            return true;

        } catch (Exception e) {
            Toast.makeText(TelaCadastro.this, "Erro ao gravar o usuário", Toast.LENGTH_LONG);
            e.printStackTrace(); //linha para imprimir no terminal qual foi o erro

            return false;
        }
    }
    private void abrirteladedentro(){
        Intent intent = new Intent(TelaCadastro.this, TelaLogin.class);
        startActivity(intent);
        Toast.makeText(TelaCadastro.this, "O usuário foi cadastrado com sucesso", Toast.LENGTH_SHORT);
    }
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














