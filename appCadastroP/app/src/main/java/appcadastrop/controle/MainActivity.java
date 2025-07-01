package appcadastrop.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtExibir;

    EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtExibir=findViewById(R.id.txtExibir);
        edtNome=findViewById(R.id.edtNome);
    }

    public void Exibir(View view){
        String nome = edtNome.getText().toString();
        txtExibir.setText(nome);
    }
}