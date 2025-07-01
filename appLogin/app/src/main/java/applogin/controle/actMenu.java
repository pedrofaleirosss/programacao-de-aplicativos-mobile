package applogin.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class actMenu extends AppCompatActivity {
    TextView txtMenuLogin, txtMenuSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_menu);
        txtMenuLogin = findViewById(R.id.txtMenuLogin);
        txtMenuSenha = findViewById(R.id.txtMenuSenha);
        Intent itorigem = getIntent();
        txtMenuLogin.setText(itorigem.getStringExtra("login"));
        txtMenuSenha.setText(itorigem.getStringExtra("senha"));
    }
}