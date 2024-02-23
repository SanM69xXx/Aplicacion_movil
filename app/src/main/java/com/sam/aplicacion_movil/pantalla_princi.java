package com.sam.aplicacion_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;

public class pantalla_princi extends AppCompatActivity {

    String Tag = "Prueba_princi";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_princi);


        LottieAnimationView animationView = findViewById(R.id.animation_view);

        // Establece la animación utilizando el archivo en res/raw
        animationView.setAnimation(R.raw.animation);

        // Inicia la animación
        animationView.playAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(pantalla_princi.this, MainActivity.class));
                finish();
            }
        },4000);
    }

    @Override
    protected void onDestroy() {

        LottieAnimationView animationView = findViewById(R.id.animation_view);
        if (animationView != null) {
            animationView.cancelAnimation();
            Log.i(Tag,"se destruyo la animacion");
        }
        super.onDestroy();
    }
}
