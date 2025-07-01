package appcurso.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.TextView;

public class actPrincipal extends AppCompatActivity {
    RadioButton rdbDS, rdbAdministracao, rdbMarketing;
    CheckBox chkManha, chkTarde, chkNoite;

    TextView txtExibir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_principal);

        rdbDS=findViewById(R.id.rdbDS);
        rdbAdministracao=findViewById(R.id.rdbAdministracao);
        rdbMarketing=findViewById(R.id.rdbMarketing);

        chkManha=findViewById(R.id.chkManha);
        chkTarde=findViewById(R.id.chkTarde);
        chkNoite=findViewById(R.id.chkNoite);

        txtExibir=findViewById(R.id.txtExibir);
    }
    public void Exibir(View v){
        String curso = "";

        if(rdbDS.isChecked()){
            curso = "Desenvolvimento de Sistemas";
        }
        else if(rdbAdministracao.isChecked()){
            curso = "Administração";
        }
        else if(rdbMarketing.isChecked()){
            curso = "Marketing";
        }

        if(chkManha.isChecked()){
            curso = curso + " - manhã";
        }
        if(chkTarde.isChecked()){
            curso = curso + " - tarde";
        }
        if(chkNoite.isChecked()){
            curso = curso + " - noite";
        }

        txtExibir.setText(curso);
    }
}