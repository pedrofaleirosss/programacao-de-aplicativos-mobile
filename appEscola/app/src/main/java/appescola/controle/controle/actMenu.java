package appescola.controle.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import appescola.controle.R;
import appescola.controle.controle.actCadastro;

public class actMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mninflater = getMenuInflater();
        mninflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mniCAlunos) {
            Intent it = new Intent(this, actCadastro.class);
            startActivity(it);
        } else if (item.getItemId() == R.id.mniSair) {
            System.exit(0);
        }
        return true;
    }

}