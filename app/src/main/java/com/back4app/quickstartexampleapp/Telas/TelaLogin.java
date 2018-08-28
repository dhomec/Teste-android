package com.back4app.quickstartexampleapp.Telas;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.back4app.quickstartexampleapp.DAO.ConfiguracaoFirebase;
import com.back4app.quickstartexampleapp.R;
import com.back4app.quickstartexampleapp.util.ParseErros;
import com.back4app.quickstartexampleapp.util.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
//import com.parse.LogInCallback;
//import com.parse.ParseException;
//import com.parse.ParseUser;

public class TelaLogin extends Activity {


    private Button btCriarConta;
    private ImageView btLogin;

    private EditText ctEmail;
    private EditText ctSenha;

    private FirebaseAuth autenticacao;
    private Usuario usuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);



        btCriarConta = (Button) findViewById(R.id.btCriarConta);

        btLogin = (ImageView) findViewById(R.id.Login);

        ctEmail = (EditText) findViewById(R.id.ctEmail);
        ctSenha = (EditText) findViewById(R.id.ctSenha);


        //Verificando se o usario esta logado e se sim enviando para tela de dentro
        if (usuariologado()) {
        abrirteladedentroLista();
        }else {
        Toast.makeText(TelaLogin.this, "Realize Login para acessar o Shopping!", Toast.LENGTH_SHORT).show();
        }


            btLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Verificando se o campo usuario e senha não estão em branco, instanciando a classe o usuario e conferindo os dados
                    if (!ctEmail.getText().toString().equals("") && !ctSenha.getText().toString().equals("")) {

                        usuario = new Usuario();
                        usuario.setEmail(ctEmail.getText().toString());
                        usuario.setSenha(ctSenha.getText().toString());
                        validarlogin();


                    } else {
                        Toast.makeText(TelaLogin.this, "Preencha os campos de E-mail e Senha", Toast.LENGTH_LONG).show();

                    }
                }
            });


        btCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaLogin.this, TelaCadastro.class));
            }
        });


    }
        private void validarlogin(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAuth();
        autenticacao.signInWithEmailAndPassword(usuario.getEmail().toString(), usuario.getSenha().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                   abrirteladedentroLista();
                   Toast.makeText(TelaLogin.this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT);

                }else{
                   Toast.makeText(TelaLogin.this, "Usuário ou Senha inválido. Tente novamente!", Toast.LENGTH_SHORT);
                }
            }
        });
        }
        private void abrirteladedentroLista() {
            Intent intent = new Intent(TelaLogin.this, TelaSetor.class);
            startActivity(intent);
        }


        public Boolean usuariologado () {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            if (user != null){
                return true;
            }else{
                return false;
            }}

    }



         //BANCO DE DADOS BACK4APP
     //Deslogando se o usuario estiver logado
     //ParseUser.logOut();
     //chamando metodos de verificar e mandar para tela de dentro
     // verificarUsuarioLogado();

     //BANCO DE DADOS BACK4APP
     //no parse quando cria a conta o usuario ja fica logado ou quando ele abrir o app novamente
     //private void verificarUsuarioLogado(){
     //if(ParseUser.getCurrentUser() != null){
     //se for diferente de null o usuario esta logado devendo envialo para tela principal
     //abrirTelaDentroLista();}}
     //para criar a intent de ir para a tela de dentro lista
     //private void abrirTelaDentroLista(){
     //Intent intent = new Intent(TelaLogin.this, TelaSetor.class);
     //startActivity(intent);
     //finish();//para fechar essa tela    }
     //private void verificarlogin (String usuario, String senha){
     //ParseUser.logInInBackground(usuario, senha, new LogInCallback() {
     //@Override
     //public void done(ParseUser user, ParseException e) {
     //if(e == null){
     //Toast.makeText(TelaLogin.this, "Login realizado com sucesso!", Toast.LENGTH_LONG).show();
     //abrirTelaDentroLista();
     //}else{
     //ParseErros parseErros = new ParseErros();
     //String erro = parseErros.getErro(e.getCode());
     //Toast.makeText(TelaLogin.this, erro , Toast.LENGTH_LONG).show();
     //   }            }        });    }
    /*
    //CADASTRO DE USUARIO - FAZER LOGIN
    ParseUser usuario = new ParseUser();
    usuario.setUsername("huddson");
    usuario.setPassword("1234");
    usuario.setEmail("huddsonmf@gmail.com");
    usuario.signUpInBackground(new SignUpCallback() {//callback com retorno, sem seria apenas salvando
      @Override
      public void done(ParseException e) {
        if(e == null){
          Log.i("CADASTRO","Sucesso no Cadastro!");
        }else{
          Log.i("CADASTRO","Falha no Cadastro!" + e.getMessage());
        }
      }
    });
    */

    /*
    //VERIFICANDO USUARIO NO BANCO - FAZER LOGIN
    //deslogando o usuario
      ParseUser.logOut();

    //recupera usuario logado currentuser
    if(ParseUser.getCurrentUser() != null){
      Log.i("Usuário Logado","SIM!");
    }else{
      Log.i("Usuário Logado","NÃO!");
    }
    */

    /*
    //LOGIN - FAZER LOGIN
    ParseUser.logInInBackground("huddson", "1234", new LogInCallback() {
      @Override
      public void done(ParseUser user, ParseException e) {
        if(e == null){
          Log.i("LOGIN","Realizado com Sucesso!");
        }else{
          Log.i("LOGIN","Não foi realizado!, Verique usuário e senha." + e.getMessage());
        }
      }
    });
    */
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





