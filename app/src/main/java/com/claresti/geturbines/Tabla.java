package com.claresti.geturbines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class Tabla extends AppCompatActivity {
    //Variables para el control de floatingButton
    FloatingActionButton tabla;
    FloatingActionButton guardar;
    FloatingActionButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tabla);

        //Seccion de control de floatingButton
        tabla=(FloatingActionButton)findViewById(R.id.accion_verGrafica);
        tabla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tabla.this, Grafica.class);
                startActivity(i);
            }
        });
        guardar=(FloatingActionButton)findViewById(R.id.accion_Guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tabla.this, Tabla.class);
                startActivity(i);
            }
        });
        home=(FloatingActionButton)findViewById(R.id.accion_Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tabla.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
