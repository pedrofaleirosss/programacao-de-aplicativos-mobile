package applanchonete.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class actLanchonete extends AppCompatActivity {

    ImageView imgLanche;

    CheckBox cbxMaionese, cbxCheddar, cbxOvo;
    RadioButton rdbXBurger, rdbXSalada, rdbXBacon;

    String nomeLanche, nomeComplemento = "";

    Double total = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_lanchonete);
        imgLanche=findViewById(R.id.imgLanches);

        cbxMaionese=findViewById(R.id.cbxMaionese);
        cbxCheddar=findViewById(R.id.cbxCheddar);
        cbxOvo=findViewById(R.id.cbxOvo);

        rdbXBurger=findViewById(R.id.rdbBurger);
        rdbXSalada=findViewById(R.id.rdbSalada);
        rdbXBacon=findViewById(R.id.rdbBacon);

        Drawable img = getResources().getDrawable(R.drawable.logo,getTheme());
        imgLanche.setImageDrawable(getResources().getDrawable(R.drawable.logo,getTheme()));
    }

    public void Pedir(View ver) {
        nomeComplemento = "";
        total = 0.0;

        if(rdbXBurger.isChecked() || rdbXBacon.isChecked() || rdbXSalada.isChecked()){
            Intent it = new Intent(this, actPedido.class);

            if (rdbXBurger.isChecked()) {
                nomeLanche = "X Burger - R$12,00";
                total += 12;
            }
            if (rdbXSalada.isChecked()) {
                nomeLanche = "X Salada - R$15,00";
                total += 15;
            }
            if (rdbXBacon.isChecked()) {
                nomeLanche = "X Bacon -  R$16,00";
                total += 16;
            }

            if (cbxCheddar.isChecked()) {
                nomeComplemento = nomeComplemento + "Cheddar - R$2,00 \n";
                total += 2;
            }
            if (cbxMaionese.isChecked()) {
                nomeComplemento = nomeComplemento + "Maionese - R$2,00 \n";
                total += 2;
            }
            if (cbxOvo.isChecked()) {
                nomeComplemento = nomeComplemento + "Ovo - R$3,00 \n";
                total += 3;
            }


            it.putExtra("lanche", nomeLanche);
            it.putExtra("complemento", nomeComplemento);
            it.putExtra("total", "Total: R$"+total.toString());
            startActivity(it);
        }
        else {
            Toast.makeText(this, "Selecione um lanche!", Toast.LENGTH_SHORT).show();
        }
    }

    public void TrocarImagem(View v) {
        if (rdbXBurger.isChecked()) {
            Drawable img = getResources().getDrawable(R.drawable.xburger,getTheme());
            imgLanche.setImageDrawable(getResources().getDrawable(R.drawable.xburger,getTheme()));
        }
        if (rdbXSalada.isChecked()) {
            Drawable img = getResources().getDrawable(R.drawable.xsalada,getTheme());
            imgLanche.setImageDrawable(getResources().getDrawable(R.drawable.xsalada,getTheme()));
        }
        if (rdbXBacon.isChecked()) {
            Drawable img = getResources().getDrawable(R.drawable.xbacon,getTheme());
            imgLanche.setImageDrawable(getResources().getDrawable(R.drawable.xbacon,getTheme()));
        }
    }

}