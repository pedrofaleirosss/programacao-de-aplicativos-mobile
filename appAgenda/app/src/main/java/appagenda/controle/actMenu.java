package appagenda.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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
        if (item.getItemId() == R.id.mniAgenda) {
            Intent it = new Intent(this, actCadAgenda.class);
            startActivity(it);
        } else if (item.getItemId() ==  R.id.mniSair) {
            System.exit(0);
        }
        return true;
    }

}