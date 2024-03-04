package com.sam.aplicacion_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class segunda_pantalla extends AppCompatActivity {

    TextView R_usu,R_contra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        R_usu = findViewById(R.id.R_usu);
        R_contra = findViewById(R.id.R_contra);

        Bundle recibeDatos = getIntent().getExtras();
        Bundle recibeDatos2 =  getIntent().getExtras();
        String info = recibeDatos.getString("keydatos");
        String info2 = recibeDatos2.getString("keyDatos");

        R_usu.setText(info);
        R_contra.setText(info2);
    }
}