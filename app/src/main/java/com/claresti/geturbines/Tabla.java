package com.claresti.geturbines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Tabla extends AppCompatActivity {
    //Variables para el control de floatingButton
    FloatingActionButton tabla;
    FloatingActionButton guardar;
    FloatingActionButton home;
    TextView elemento1;
    TextView air1;
    TextView compp1;
    TextView comptl;
    TextView turbp1;
    TextView turbt1;
    TextView elemento2;
    TextView air2;
    TextView compp2;
    TextView compt2;
    TextView turbp2;
    TextView turbt2;
    TextView elemento3;
    TextView air3;
    TextView compp3;
    TextView compt3;
    TextView turbp3;
    TextView turbt3;
    TextView elemento4;
    TextView air4;
    TextView compp4;
    TextView compt4;
    TextView turbp4;
    TextView turbt4;
    TextView elemento5;
    TextView air5;
    TextView compp5;
    TextView compt5;
    TextView turbp5;
    TextView turbt5;
    ImageView change;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tabla);

        elemento1 = (TextView)findViewById(R.id.txt_elemento1);
        air1 = (TextView)findViewById(R.id.txt_air1);
        compp1 = (TextView)findViewById(R.id.txt_compp1);
        comptl = (TextView)findViewById(R.id.txt_compt1);
        turbp1 = (TextView)findViewById(R.id.txt_turbp1);
        turbt1 = (TextView)findViewById(R.id.txt_turbt1);
        elemento2 = (TextView)findViewById(R.id.txt_elemento2);
        air2 = (TextView)findViewById(R.id.txt_air2);
        compp2 = (TextView)findViewById(R.id.txt_compp2);
        compt2 = (TextView)findViewById(R.id.txt_compt2);
        turbp2 = (TextView)findViewById(R.id.txt_turbp2);
        turbt2 = (TextView)findViewById(R.id.txt_turbt2);
        elemento3 = (TextView)findViewById(R.id.txt_elemento3);
        air3 = (TextView)findViewById(R.id.txt_air3);
        compp3 = (TextView)findViewById(R.id.txt_compp3);
        compt3 = (TextView)findViewById(R.id.txt_compt3);
        turbp3 = (TextView)findViewById(R.id.txt_turbp3);
        turbt3 = (TextView)findViewById(R.id.txt_turbt3);
        elemento4 = (TextView)findViewById(R.id.txt_elemento4);
        air4 = (TextView)findViewById(R.id.txt_air4);
        compp4 = (TextView)findViewById(R.id.txt_compp4);
        compt4 = (TextView)findViewById(R.id.txt_compt4);
        turbp4 = (TextView)findViewById(R.id.txt_turbp4);
        turbt4 = (TextView)findViewById(R.id.txt_turbt4);
        elemento5 = (TextView)findViewById(R.id.txt_elemento5);
        air5 = (TextView)findViewById(R.id.txt_air5);
        compp5 = (TextView)findViewById(R.id.txt_compp5);
        compt5 = (TextView)findViewById(R.id.txt_compt5);
        turbp5 = (TextView)findViewById(R.id.txt_turbp5);
        turbt5 = (TextView)findViewById(R.id.txt_turbt5);
        change=(ImageView)findViewById(R.id.change);


        elemento1.setText("1");
        air1.setText("7.198065547");
        compp1.setText("74016371 pas");
        comptl.setText("490000.0 k");
        turbp1.setText("102122.553502 pas");
        turbt1.setText("102122.726642 k");
        elemento2.setText("2");
        air2.setText("6.4668370365");
        compp2.setText("452.74016371 pas");
        compt2.setText("490000.0 k");
        turbp2.setText("1154.98112201 pas");
        turbt2.setText("102122.726642 k");
        elemento3.setText("3");
        air3.setText("7.198065547");
        compp3.setText("74016371 pas");
        compt3.setText("490000.0 k");
        turbp3.setText("102122.553502 pas");
        turbt3.setText("102122.726642 k");
        elemento4.setText("4");
        air4.setText("6.4668370365");
        compp4.setText("452.74016371 pas");
        compt4.setText("490000.0 k");
        turbp4.setText("1154.98112201 pas");
        turbt4.setText("102122.726642 k");
        elemento5.setText("5");
        air5.setText("7.198065547");
        compp5.setText("74016371 pas");
        compt5.setText("490000.0 k");
        turbp5.setText("102122.553502 pas");
        turbt5.setText("102122.726642 k");


        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==0) {
                    comptl.setText("881540.3℉");
                    turbt1.setText("183361.2℉");
                    compt2.setText("881540.3℉");
                    turbt2.setText("183361.2℉");
                    compt3.setText("881540.3℉");
                    turbt3.setText("183361.2℉");
                    compt4.setText("881540.3℉");
                    turbt4.setText("183361.2℉");
                    compt5.setText("881540.3℉");
                    turbt5.setText("183361.2℉");
                    compp1.setText("1.55700433659 psi");
                    turbp1.setText("102122.553502 psi");
                    compp2.setText("0.06566440912 psi");
                    turbp2.setText("0.16751584906 psi");
                    compp3.setText("1.55700433659 psi");
                    turbp3.setText("102122.553502 psi");
                    compp4.setText("0.06566440912 psi");
                    turbp4.setText("0.16751584906 psi");
                    compp5.setText("1.55700433659 psi");
                    turbp5.setText("102122.553502 psi");

                    flag++;
                }else{
                    comptl.setText("490000.0 k");
                    turbt1.setText("102122.726642 k");
                    compt2.setText("490000.0 k");
                    turbt2.setText("102122.726642 k");
                    compt3.setText("490000.0 k");
                    turbt3.setText("102122.726642 k");
                    compt4.setText("490000.0 k");
                    turbt4.setText("102122.726642 k");
                    compt5.setText("490000.0 k");
                    turbt5.setText("102122.726642 k");
                    compp1.setText("74016371 pas");
                    turbp1.setText("102122.553502 pas");
                    compp2.setText("452.74016371 pas");
                    turbp2.setText("1154.98112201 pas");
                    compp3.setText("74016371 pas");
                    turbp3.setText("102122.553502 pas");
                    compp4.setText("452.74016371 pas");
                    turbp4.setText("1154.98112201 pas");
                    compp5.setText("74016371 pas");
                    turbp5.setText("102122.553502 pas");
                    flag--;
                }

            }
        });

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
                Intent i = new Intent(Tabla.this, MainActivity.class);
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
