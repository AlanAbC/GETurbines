package com.claresti.geturbines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class Grafica extends AppCompatActivity {

    FloatingActionButton tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_grafica);

        tabla=(FloatingActionButton)findViewById(R.id.accion_verTabla);
        tabla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Grafica.this, Tabla.class);
                startActivity(i);
            }
        });
    }
}
