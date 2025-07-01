package appmercado.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    Double precoUnitario = 0.00, totalProduto = 0.00, totalCompra = 0.00, valorCadaParcela;
    int quantidade = 1, numeroParcelas = 1;

    String produto, listaProdutos = "";

    Spinner spnProdutos, spnQuantidade, spnParcelas;

    TextView txtValor, txtTotalProduto, txtProdutos, txtTotalCompra;

    Button btnComprar;

    RadioButton rdbVista, rdbPrazo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComprar = findViewById(R.id.btnComprar);

        txtValor = findViewById(R.id.txtValor);
        txtTotalProduto = findViewById(R.id.txtTotalProduto);
        txtProdutos = findViewById(R.id.txtListaProdutos);
        txtTotalCompra = findViewById(R.id.txtTotalCompra);

        spnProdutos = findViewById(R.id.spnProdutos);
        spnQuantidade = findViewById(R.id.spnQuantidade);
        spnParcelas = findViewById(R.id.spnParcelas);

        rdbVista = findViewById(R.id.rdbVista);
        rdbPrazo = findViewById(R.id.rdbPrazo);

        String strProdutos[] = {"Selecione o produto", "Arroz", "Feijão", "Macarrão", "Óleo", "Leite", "Frango", "Bolacha", "Refrigerante", "Ovo", "Ketchup", "Mostarda", "Bala", "Chocolate", "Suco", "Pão"};
        ArrayAdapter arrayAdapterProdutos = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, strProdutos);
        spnProdutos.setAdapter(arrayAdapterProdutos);

        String strQuantidade[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ArrayAdapter arrayAdapterQuantidade = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, strQuantidade);
        spnQuantidade.setAdapter(arrayAdapterQuantidade);

        String strParcelas[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        ArrayAdapter arrayAdapterParcelas = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, strParcelas);
        spnParcelas.setAdapter(arrayAdapterParcelas);

        Double precosVetor[] = {0.00, 9.50, 8.00, 6.00, 8.00, 6.50, 6.00, 4.00, 5.50, 10.00, 5.50, 7.00, 2.00, 7.50, 5.00, 4.00};

        spnProdutos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                for (int j = 0; j < strProdutos.length; j++){
                    if (spnProdutos.getSelectedItem().toString() == strProdutos[j]){
                        precoUnitario = precosVetor[j];
                    }
                }

                produto = spnProdutos.getSelectedItem().toString();

                txtValor.setText("Valor unitário: R$" + precoUnitario);

                totalProduto = precoUnitario * quantidade;
                txtTotalProduto.setText("Total do produto: R$" + totalProduto);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spnQuantidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                quantidade = Integer.parseInt(spnQuantidade.getSelectedItem().toString());
                totalProduto = precoUnitario * quantidade;
                txtTotalProduto.setText("Total do produto: R$" + totalProduto);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        spnParcelas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                numeroParcelas = Integer.parseInt(spnParcelas.getSelectedItem().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void Adicionar (View v){
        if (produto != "Selecione o produto") {
            listaProdutos = listaProdutos + quantidade + " - " + produto + " - R$" + totalProduto + "\n";
            txtProdutos.setText(listaProdutos);
            totalCompra += totalProduto;
        }
    }

    public void Finalizar (View ver) {

        valorCadaParcela = totalCompra / numeroParcelas;

        if (rdbVista.isChecked()){
            txtTotalCompra.setText("Pagamento à vista: R$" + totalCompra);
        }
        else if(rdbPrazo.isChecked()){
            txtTotalCompra.setText("Pagamento à prazo: " + numeroParcelas +" parcelas de R$" + valorCadaParcela + " Total: R$" + totalCompra);
        }

    }

}

