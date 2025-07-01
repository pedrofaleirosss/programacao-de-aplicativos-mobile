package appescola.controle.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import appescola.controle.R;

import appescola.controle.database.dbescola;

public class actCadastro extends AppCompatActivity {

    EditText edtId, edtNome, edtRa, edtEmail;

    Button btnCadastrar, btnConsultar, btnAlterar, btnExcluir, btnLimpar;

    private int id = 0;

    dbescola dbescola = null;

    SQLiteDatabase db = null;

    ContentValues valores = null;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_cadastro);
        edtId = findViewById(R.id.edtId);
        edtNome = findViewById(R.id.edtNome);
        edtRa = findViewById(R.id.edtRa);
        edtEmail = findViewById(R.id.edtEmail);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnConsultar = findViewById(R.id.btnConsultar);
        btnAlterar = findViewById(R.id.btnAlterar);
        btnExcluir = findViewById(R.id.btnExcluir);
        btnLimpar = findViewById(R.id.btnLimpar);
        dbescola = new dbescola(getBaseContext());
    }

    public void Cadastrar(View view) {
        db = dbescola.getWritableDatabase();
        valores = new ContentValues();
        valores.put("nome", edtNome.getText().toString());
        valores.put("ra", edtRa.getText().toString());
        valores.put("email", edtEmail.getText().toString());

        long linhas = db.insert("alunos", null, valores);

        if (linhas > 0) {
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Falha na inclusão de dados.", Toast.LENGTH_SHORT).show();
        }
        db.close();
        Limpar(view);
    }

    public void Consultar(View view) {
        db = dbescola.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM alunos WHERE id = "
        + Integer.parseInt(edtId.getText().toString()), null);

        if (cursor.moveToFirst()) {
            edtNome.setText(cursor.getString(1));
            edtRa.setText(cursor.getString(2));
            edtEmail.setText(cursor.getString(3));
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
        } else {
            Toast.makeText(this, "Falha ao consultar dados.", Toast.LENGTH_SHORT).show();

        }
        db.close();
    }

    public void Alterar(View view) {
        db = dbescola.getWritableDatabase();
        valores = new ContentValues();
        valores.put("nome", edtNome.getText().toString());
        valores.put("ra", edtRa.getText().toString());
        valores.put("email", edtEmail.getText().toString());

        int linhas = db.update("alunos", valores, "id = " +
                Integer.parseInt(edtId.getText().toString()), null);

        if (linhas > 0) {
            Toast.makeText(this, "Alteração realizada com sucesso!", Toast.LENGTH_SHORT).show();
        }
        db.close();
        Limpar(view);
        BtnDisabled();
    }

    public void Excluir(View view) {
        db = dbescola.getWritableDatabase();

        int linhas = db.delete("alunos", "id = " +
                Integer.parseInt(edtId.getText().toString()), null);

        if (linhas > 0) {
            Toast.makeText(this, "Registro excluído com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Falha na exclusão de dados.", Toast.LENGTH_SHORT).show();
        }
        db.close();
        Limpar(view);
        BtnDisabled();
    }

    public void Limpar(View view) {
        edtId.setText("");
        edtNome.setText("");
        edtRa.setText("");
        edtEmail.setText("");
        edtId.requestFocus();
    }

    public void BtnDisabled() {
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
    }
}