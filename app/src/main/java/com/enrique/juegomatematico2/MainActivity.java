package com.enrique.juegomatematico2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnrd,btnresultado;
    TextView tv,tvr;
    RadioButton rd1,rd2;
    Switch sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnrd=(Button) findViewById(R.id.btnrandom);
        btnresultado=(Button) findViewById(R.id.result);
        tv=(TextView) findViewById(R.id.anio);
        tvr=(TextView) findViewById(R.id.Resultado);
        rd1=(RadioButton) findViewById(R.id.yes);
        rd2=(RadioButton) findViewById(R.id.NO);
        sw=(Switch)findViewById(R.id.switch1);
        btnrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(String.valueOf((int)(Math.random()*(1950-2500)+2500)));
            }
        });

        btnresultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((!rd1.isChecked()&&!rd2.isChecked()))
                    tvr.setText("Debes introducir alguna opc");
                else{
                    if (rd1.isChecked()&&comprobar_bisiesto(Integer.parseInt((String) tv.getText()))){
                        tvr.setText("Correcto");
                    }
                    if (rd1.isChecked()&&!comprobar_bisiesto(Integer.parseInt((String) tv.getText()))){
                        tvr.setText("Incorrecto");
                    }
                    if (rd2.isChecked()&&!comprobar_bisiesto(Integer.parseInt((String) tv.getText()))){
                        tvr.setText("Correcto");
                    }
                    if (rd2.isChecked()&&comprobar_bisiesto(Integer.parseInt((String) tv.getText()))){
                        tvr.setText("Incorrecto");
                    }
                }
            }
        });
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (sw.isChecked())
                  sw.setText("on");
              else
                  sw.setText("off");
            }
        });
    }


    public boolean comprobar_bisiesto(int anio){
        return (anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0));
    }
}