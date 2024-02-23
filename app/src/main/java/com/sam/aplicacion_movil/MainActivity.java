package com.sam.aplicacion_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
</androidx.constraintlayout.widget.ConstraintLayout>


    */


public class MainActivity extends AppCompatActivity {
    TextView nombreUsuario;
    EditText usuario,contraseña;
    Button btn1,btn2,alarma,enviar;
    String Tag = "Prueba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usuario = findViewById(R.id.usu);
        contraseña = findViewById(R.id.contra);
        nombreUsuario = (TextView) findViewById(R.id.usuario);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        enviar = findViewById(R.id.enviar);
        alarma = findViewById(R.id.alarma);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombreUsuario.setText("Presioné Boton Uno");

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombreUsuario.setText("Presioné Boton Dos");
            }
        });

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createAlarm("desperta marica",22,30);

                nombreUsuario.setText("Alarma creada");

            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Bundle enviaDatos = new Bundle();
            enviaDatos.putString("keydatos",usuario.getText().toString());
            enviaDatos.putString("keyDatos",contraseña.getText().toString());

            Intent intent = new Intent(MainActivity.this,segunda_pantalla.class);
            intent.putExtras(enviaDatos);
            startActivity(intent);

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag,"Estoy en OnStart");
        nombreUsuario.setText("app iniciada");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag,"Estoy en OnResume");
        nombreUsuario.setText("app en proceso");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag,"Estoy en OnPause");
        nombreUsuario.setText("app pausada");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag,"Estoy en OnStop");
        nombreUsuario.setText("app parada");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(Tag,"Estoy en OnRestart");
        nombreUsuario.setText("app restaurada");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag,"Estoy en OnDestroy");
        nombreUsuario.setText("app destruida");
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}