package com.claresti.geturbines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    com.getbase.floatingactionbutton.FloatingActionButton send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        send=(com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.accion_Send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, Grafica.class);
                startActivity(i);
            }
        });
    }
}
