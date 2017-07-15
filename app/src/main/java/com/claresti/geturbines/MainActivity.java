package com.claresti.geturbines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    com.getbase.floatingactionbutton.FloatingActionButton send;
    com.getbase.floatingactionbutton.FloatingActionButton add;
    private EditText input0;
    private EditText input1;
    private EditText input2;
    private EditText input3;
    private EditText input4;
    private EditText input5;
    private EditText input6;
    private EditText input7;
    private EditText input8;
    private EditText input9;
    private EditText input10;
    private EditText input11;
    private EditText input12;
    private EditText input13;
    private ArrayList<Variables> variables;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //Llamado de todas las variables
        send=(com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.accion_Send);
        send=(com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.accion_Add);
        input0=(EditText)findViewById(R.id.input_comando1);
        input1=(EditText)findViewById(R.id.input_comando2);
        input2=(EditText)findViewById(R.id.input_comando3);
        input3=(EditText)findViewById(R.id.input_comando4);
        input4=(EditText)findViewById(R.id.input_comando5);
        input5=(EditText)findViewById(R.id.input_comando6);
        input6=(EditText)findViewById(R.id.input_comando7);
        input7=(EditText)findViewById(R.id.input_comando8);
        input8=(EditText)findViewById(R.id.input_comando9);
        input9=(EditText)findViewById(R.id.input_comando10);
        input10=(EditText)findViewById(R.id.input_comando11);
        input11=(EditText)findViewById(R.id.input_comando12);
        input12=(EditText)findViewById(R.id.input_comando13);
        input13=(EditText)findViewById(R.id.input_comando14);
        variables=new ArrayList<Variables>();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Variables var = new Variables();
                var.setValor0(input0.getText().toString());
                var.setValor1(input1.getText().toString());
                var.setValor2(input2.getText().toString());
                var.setValor3(input3.getText().toString());
                var.setValor4(input4.getText().toString());
                var.setValor5(input5.getText().toString());
                var.setValor6(input6.getText().toString());
                var.setValor7(input7.getText().toString());
                var.setValor8(input8.getText().toString());
                var.setValor9(input9.getText().toString());
                var.setValor10(input10.getText().toString());
                var.setValor11(input11.getText().toString());
                var.setValor12(input12.getText().toString());
                var.setValor13(input13.getText().toString());

                variables.add(var);
                input0.setText("");
                input1.setText("");
                input2.setText("");
                input3.setText("");
                input4.setText("");
                input5.setText("");
                input6.setText("");
                input7.setText("");
                input8.setText("");
                input9.setText("");
                input10.setText("");
                input11.setText("");
                input12.setText("");
                input13.setText("");

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (variables.size()>0){
                    ArrayVariables.setArrayVariables(variables);
                    Intent i= new Intent(MainActivity.this, Grafica.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "No se ah ingresado ningun valor ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
