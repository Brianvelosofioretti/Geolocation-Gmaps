package com.example.brianvelosofioretti.geo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MediaPlayer mp = MediaPlayer.create(this,R.raw.sonido);
       mp.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

    }
//definimos aqui el boton y en el xml ponemos android:onClick="start" para enlazar el evento

    public void start(View v) {

        //con el intent y llamando a la segunda clase inciamos una nueva activity
        Intent segundaActivity = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(segundaActivity);
       //impedimos volver a esta activity
        finish();
    }


}
