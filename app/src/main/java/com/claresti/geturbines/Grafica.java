package com.claresti.geturbines;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Grafica extends AppCompatActivity {

    ArrayList<Variables> var;
    String urls="";
    String [] [] datos;
    ArrayList<Outputs> outputs;
    //variables para el control de floatingButton
    FloatingActionButton tabla;
    FloatingActionButton guardar;
    FloatingActionButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_grafica);
        var= ArrayVariables.getArrayVariables();
        datos= new String [var.size()] [14];

        for(int i =0; i<=var.size();i++){
            datos[i][0]=var.get(i).getValor0();
            datos[i][1]=var.get(i).getValor1();
            datos[i][2]=var.get(i).getValor2();
            datos[i][3]=var.get(i).getValor3();
            datos[i][4]=var.get(i).getValor4();
            datos[i][5]=var.get(i).getValor5();
            datos[i][6]=var.get(i).getValor6();
            datos[i][7]=var.get(i).getValor7();
            datos[i][8]=var.get(i).getValor8();
            datos[i][9]=var.get(i).getValor9();
            datos[i][10]=var.get(i).getValor10();
            datos[i][11]=var.get(i).getValor11();
            datos[i][12]=var.get(i).getValor12();
            datos[i][13]=var.get(i).getValor13();
        }

        //Seccion de control de floatingButton
        tabla=(FloatingActionButton)findViewById(R.id.accion_verTabla);
        tabla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Grafica.this, Tabla.class);
                startActivity(i);
            }
        });
        guardar=(FloatingActionButton)findViewById(R.id.accion_guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Grafica.this, Tabla.class);
                startActivity(i);
            }
        });
        home=(FloatingActionButton)findViewById(R.id.accion_Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Grafica.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    /*public void cargarRespuesta(){
        //progreso.setVisibility(View.VISIBLE);
        Log.i("JSON", "Si entro");
        final Gson gson = new Gson();
        JsonObjectRequest request;
        VolleySingleton.getInstance(Grafica.this).
                addToRequestQueue(
                        request = new JsonObjectRequest(
                                Request.Method.GET,
                                urls, datos,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        try {
                                            String res = response.getString("estado");
                                            switch(res){
                                                case "1":
                                                    Log.i("peticion", "caso 1");
                                                    outputs = new ArrayList<Outputs>();
                                                    JSONArray jArrayMarcadores = response.getJSONArray("data");
                                                    Outputs[] arraOutputs = gson.fromJson(jArrayMarcadores.toString(), Outputs[].class);
                                                    Log.i("peticion", "tamaño: " + arrayOutputs.length);
                                                    for(int i = 0; i < arrayMovimientos.length; i++){
                                                        outputs.add(arrayMovimientos[i]);
                                                    }
                                                    //progreso.setVisibility(View.GONE);
                                                    break;
                                                case "0":
                                                    Log.i("peticion", "caso 0");
                                                    //listMovimientos.setAdapter(null);
                                                    arrayOutputs= null;
                                                    //Regresar mensaje de que no hay registros
                                                    //progreso.setVisibility(View.GONE);
                                                    break;
                                                default:
                                                    Log.i("peticion", "caso default");
                                                    arrayOutputs = null;
                                                    //listMovimientos.setAdapter(null);
                                                    //progreso.setVisibility(View.GONE);
                                                    //msg("Ocurrio un problema al conectarse con el sertvidor");
                                                    break;
                                            }
                                        }catch(JSONException json){
                                            Log.e("JSON", json.toString());
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }
                                }
                        )
                );
        request.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
    }*/
    private void rellenarGraficaCategorias() {
        //creacion de la grafica
        BarChart barChart = (BarChart) findViewById(R.id.graficaDatos);

        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        int flagIndex = 0;

        for(Outputs c : outputs){
            entries.add(new BarEntry(Float.parseFloat(c.getOutput0()), flagIndex));
            flagIndex ++;
            entries.add(new BarEntry(Float.parseFloat(c.getOutput1()), flagIndex));
            flagIndex ++;
            entries.add(new BarEntry(Float.parseFloat(c.getOutput2()), flagIndex));
            flagIndex ++;
            entries.add(new BarEntry(Float.parseFloat(c.getOutput3()), flagIndex));
            flagIndex ++;
            entries.add(new BarEntry(Float.parseFloat(c.getOutput4()), flagIndex));
            flagIndex ++;
            labels.add("Load.G_air");
            labels.add("comp.T_stag_out");
            labels.add("comp.P_stag_out");
            labels.add("Turbine.T_stage_out");
            labels.add("Turbine.P_stage_out");
        }

        BarDataSet dataset = new BarDataSet(entries, "Ingreso / Egreso");

        BarData data = new BarData(labels, dataset);
        int[] colores = {Color.parseColor("#025090"), Color.parseColor("#45ADA8"), Color.parseColor("#C230AC"), Color.parseColor("#32C07C"), Color.parseColor("#E97E0A"), Color.parseColor("#F00209")};
        dataset.setColors(ColorTemplate.createColors(colores));//
        barChart.setData(data);
        barChart.setDescription("");
        barChart.animateY(7500);
        LimitLine line = new LimitLine(10f);
    }
}
