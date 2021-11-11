package com.enrique.juegomatematico2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnrd;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnrd=(Button) findViewById(R.id.btnrandom);
        tv=(TextView) findViewById(R.id.anio);

        btnrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(String.valueOf((int)(Math.random()*(1950-2500)+2500)));
            }
        });
    }

    public boolean comprobar_bisiesto(String opc, int anio){
        if(opc.equals("yes")&& (anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) return true;
        else return false;
    }
}