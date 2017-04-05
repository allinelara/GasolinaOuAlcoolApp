package br.com.cursoandroid.allinedelara.gasolinaoualcool;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolica;
    private Button bntVerificar;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = (EditText) findViewById(R.id.precoAlcoolID);
        precoGasolica = (EditText) findViewById(R.id.precoGasolinaID);
        bntVerificar = (Button) findViewById(R.id.botaoVerificarId);
        resultado = (TextView) findViewById(R.id.resultadoId);

        bntVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gasolina = precoGasolica.getText().toString();
                String alcool = precoAlcool.getText().toString();
                if(gasolina.isEmpty()||alcool.isEmpty()){
                    resultado.setText("Por favor informe o preço do alcool e da gasolina.");
                }else{
                    Double valorGasolina = Double.parseDouble(gasolina);
                    Double valorAlcool = Double.parseDouble(alcool);

                    Double resultadoConta = valorAlcool/valorGasolina;

                    if(resultadoConta>=0.7){
                        resultado.setText("É melhor utilizar gasolina.");
                    }else{
                        resultado.setText("É melhor utilizar álcool.");
                    }
                }
            }
        });
    }
}
