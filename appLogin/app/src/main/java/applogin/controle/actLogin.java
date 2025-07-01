package applogin.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class actLogin extends AppCompatActivity {

    EditText edtLogin, edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_login);
        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);
    }
    public void Enviar(View v){
        String login, senha;
        login = edtLogin.getText().toString();
        senha = edtSenha.getText().toString();

        if(login.equals("etec") && senha.equals("123")){
            Intent it = new Intent(this, actMenu.class);
            it.putExtra("login", edtLogin.getText().toString());
            it.putExtra("senha", edtSenha.getText().toString());
            it.putExtra("mensagem", "Tela de Login");
            startActivity(it);
        }
        else {
            Toast.makeText(this, "Login ou senha inválidos!", Toast.LENGTH_LONG).show();
        }
    }
}