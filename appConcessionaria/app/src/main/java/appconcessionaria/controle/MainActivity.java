package appconcessionaria.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    RadioButton rdbVW, rdbHonda, rdbFord;

    CheckBox cb1, cb2, cb3, cbTeto, cbAr;

    TextView txtExibir;

    String carro = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdbVW = findViewById(R.id.rdbVW);
        rdbHonda = findViewById(R.id.rdbHonda);
        rdbFord = findViewById(R.id.rdbFord);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);

        cbTeto = findViewById(R.id.cbTeto);
        cbAr = findViewById(R.id.cbAr);

        txtExibir = findViewById(R.id.txtExibir);

    }
        public void Mostrar(View v){
            if(rdbVW.isChecked()) {
                cb1.setText("Jetta");
                cb2.setText("Cross");
                cb3.setText("Gol");

            }
            else if(rdbHonda.isChecked()){
                cb1.setText("Civic");
                cb2.setText("City");
                cb3.setText("Fit");
            }
            else if(rdbFord.isChecked()){
                cb1.setText("Ranger");
                cb2.setText("Maverick");
                cb3.setText("Ka");
            }
        }

        public void Exibir(View v2){
        carro = "";

            if(rdbVW.isChecked()){
                carro = carro + "Volkswagen\n";
                if(cb1.isChecked()){
                    carro = carro +"Jetta - R$130.000,00\n";
                }
                if(cb2.isChecked()){
                    carro = carro + "T-Cross - R$160.000,00\n";
                }
                if(cb3.isChecked()){
                    carro = carro + "Gol - R$50.000,00\n";
                }
            }
            else if(rdbHonda.isChecked()){
                carro = carro + "Honda\n";
                if(cb1.isChecked()){
                    carro = carro +"Civic - R$230.000,00\n";
                }
                if(cb2.isChecked()){
                    carro = carro + "City - R$140.000,00\n";
                }
                if(cb3.isChecked()){
                    carro = carro + "Fit - R$110.000,00\n";
                }
            }
            else if(rdbFord.isChecked()){
                carro = carro + "Ford\n";
                if(cb1.isChecked()){
                    carro = carro +"Ranger - R$150.000,00\n";
                }
                if(cb2.isChecked()){
                    carro = carro + "Maverick - R$240.000,00\n";
                }
                if(cb3.isChecked()){
                    carro = carro + "Ka - R$70.000,00\n";
                }
            }

            if(cbTeto.isChecked()){
                carro = carro + "Teto-solar - R$4.000,00\n";
            }
            if(cbAr.isChecked()){
                carro = carro + "Ar-condicionado - R$1000.000,00\n";
            }

            txtExibir.setText(carro);
        }
}