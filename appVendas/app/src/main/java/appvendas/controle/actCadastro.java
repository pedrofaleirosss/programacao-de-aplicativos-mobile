package appvendas.controle;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import appvendas.database.dbvendas;

public class actCadastro extends AppCompatActivity {

    EditText edtId, edtNome, edtCpf, edtCelular;
    private int id = 0;
    dbvendas db = null;
    SQLiteDatabase database = null;
    ContentValues valores = null;
    Cursor cursor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_act_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtId = findViewById(R.id.edtId);
        edtNome = findViewById(R.id.edtNome);
        edtCpf = findViewById(R.id.edtCpf);
        edtCelular = findViewById(R.id.edtCelular);
        db = new dbvendas(getBaseContext());
    }

    public void LimparEdicao(View view) {
        edtId.setText("");
        edtNome.setText("");
        edtCpf.setText("");
        edtCelular.setText("");
    }

    public void Cadastrar(View view) {
        database=db.getWritableDatabase();
        valores=new ContentValues();
        valores.put("nome", edtNome.getText().toString());
        valores.put("cpf", edtCpf.getText().toString());
        valores.put("celular", edtCelular.getText().toString());
        long linhas = database.insert("clientes", null, valores);
        if (linhas > 0) {
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
            LimparEdicao(view);
        } else {
            Toast.makeText(this, "Erro ao realizar cadastro.", Toast.LENGTH_LONG).show();
        }
        database.close();
    }

}