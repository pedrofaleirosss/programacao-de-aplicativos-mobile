package applanchonete.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class actPedido extends AppCompatActivity {

    TextView txtLanche, txtComplemento, txtTotal;

    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_pedido);

        txtLanche=findViewById(R.id.txtLanche);
        txtComplemento=findViewById(R.id.txtComplemento);
        txtTotal=findViewById(R.id.txtTotal);

        Intent itorigem = getIntent();

        txtLanche.setText(itorigem.getStringExtra("lanche"));
        txtComplemento.setText(itorigem.getStringExtra("complemento"));
        txtTotal.setText(itorigem.getStringExtra("total"));
    }
}