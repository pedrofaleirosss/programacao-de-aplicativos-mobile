package appagenda.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class actSScreen extends AppCompatActivity {

    ImageView imgAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_sscreen);
        imgAgenda = findViewById(R.id.imgAgenda);
        Rotacao();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Login();
            }
        }, 2000);
    }

    public void Rotacao() {
        imgAgenda.animate().setDuration(2000);
        imgAgenda.animate().rotationX(360);
        imgAgenda.animate().alpha(0.1f);
    }

    public void Login() {
        Intent it = new Intent(this, actLogin.class);
        startActivity(it);
    }
}