package appagenda.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    public void Login (View view) {
        if (edtLogin.getText().toString().equals("etec") && edtSenha.getText().toString().equals("1234")) {
            Intent it = new Intent(this, actMenu.class);
            startActivity(it);
        }   else {
            Toast.makeText(this, "Login inválido!", Toast.LENGTH_LONG).show();
        }
    }
}