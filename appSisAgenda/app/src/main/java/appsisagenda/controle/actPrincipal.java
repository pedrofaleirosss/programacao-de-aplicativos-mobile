package appsisagenda.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import appsisagenda.database.database;

public class actPrincipal extends AppCompatActivity {

    EditText edtId, edtNome, edtEmail, edtCelular;

    Button btnCadastrar, btnConsultar, btnAlterar, btnExcluir, btnLimpar, btnListar;

    private int id = 0;

    database dbagenda = null;

    SQLiteDatabase db = null;

    ContentValues valores = null;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_principal);
        edtId=findViewById(R.id.edtId);
        edtNome=findViewById(R.id.edtNome);
        edtEmail=findViewById(R.id.edtEmail);
        edtCelular=findViewById(R.id.edtCelular);
        btnCadastrar=findViewById(R.id.btnCadastrar);
        btnConsultar=findViewById(R.id.btnConsultar);
        btnAlterar=findViewById(R.id.btnAlterar);
        btnExcluir=findViewById(R.id.btnExcluir);
        btnLimpar=findViewById(R.id.btnLimpar);
        btnListar=findViewById(R.id.btnListar);
        dbagenda = new database(getBaseContext());
    }

    public void Cadastrar(View view) {
        db = dbagenda.getWritableDatabase();
        valores = new ContentValues();
        valores.put("nome", edtNome.getText().toString());
        valores.put("email", edtEmail.getText().toString());
        valores.put("celular", edtCelular.getText().toString());

        long linhas = db.insert("contatos", null, valores);

        if (linhas > 0) {
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Falha na inclusão de dados.", Toast.LENGTH_LONG).show();
        }
        db.close();
        Limpar(view);
    }

    public void Consultar(View view) {
        db = dbagenda.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM contatos WHERE id = "
                + Integer.parseInt(edtId.getText().toString()), null);

        if (cursor.moveToFirst()) {
            edtNome.setText(cursor.getString(1));
            edtEmail.setText(cursor.getString(2));
            edtCelular.setText(cursor.getString(3));
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
        } else {
            Toast.makeText(this, "Falha ao consultar os dados.", Toast.LENGTH_LONG).show();
            BtnDisabled();
        }
        db.close();
    }

    public void Alterar(View view) {
        db = dbagenda.getWritableDatabase();
        valores = new ContentValues();
        valores.put("nome", edtNome.getText().toString());
        valores.put("email", edtEmail.getText().toString());
        valores.put("celular", edtCelular.getText().toString());

        int linhas = db.update("contatos", valores, "id = " +
                Integer.parseInt(edtId.getText().toString()), null);

        if (linhas > 0) {
            Toast.makeText(this, "Alteração realizada com sucesso.", Toast.LENGTH_LONG).show();
        }
        db.close();
        Limpar(view);
        BtnDisabled();
    }

    public void Excluir(View view) {
        db = dbagenda.getWritableDatabase();
        int linha = db.delete("contatos", "id="+Integer.parseInt(
                edtId.getText().toString()), null);
        if (linha > 0) {
            Toast.makeText(this, "Registro excluído com sucesso!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Falha na exclusão.", Toast.LENGTH_LONG).show();
        }
        db.close();
        Limpar(view);
        BtnDisabled();
    }

    public void Limpar(View view) {
        edtId.setText("");
        edtNome.setText("");
        edtEmail.setText("");
        edtCelular.setText("");
        edtId.requestFocus();
    }

    public void BtnDisabled() {
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
    }
}