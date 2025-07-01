package appcepapi.controle;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class actPrincipal extends AppCompatActivity {
    EditText edtEndereco, edtBairro, edtCidade, edtUF, edtCEP;
    TextView txtJson;
    Button btnConsultar;
    JSONObject jsondatareturn;
    ExecutorService executar;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_principal);
        edtEndereco = findViewById(R.id.edtEndereco);
        edtBairro = findViewById(R.id.edtBairro);
        edtCidade = findViewById(R.id.edtCidade);
        edtUF = findViewById(R.id.edtUF);
        edtCEP = findViewById(R.id.edtCEP);
    }

    public void Consultar(View view) {
        String urlAddress = "https://viacep.com.br/ws/" + edtCEP.getText().toString() + "/json/";
        executar = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
        // executar.execute();
    }
}