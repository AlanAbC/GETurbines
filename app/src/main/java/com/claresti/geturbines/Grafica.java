package com.claresti.geturbines;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Outline;
import android.icu.util.Output;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

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
import java.util.HashMap;
import java.util.Map;

public class Grafica extends AppCompatActivity {

    // Declaracion de variables del layout
    private FloatingActionButton tabla;
    private FloatingActionButton guardar;
    private FloatingActionButton home;
    private ProgressBar progreso;
    TextView maximo;
    TextView minimo;

    // Declaracion de objetos
    private ArrayList<Variables> var;
    private ArrayList<Outputs> outputs;

    // Declaracion de variables extra
    String urls="localhost/ge/api/index.php?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_grafica);

        //Asignacion de variables del layout
        tabla = (FloatingActionButton)findViewById(R.id.accion_verTabla);
        guardar = (FloatingActionButton)findViewById(R.id.accion_guardar);
        home = (FloatingActionButton)findViewById(R.id.accion_Home);
        progreso = (ProgressBar)findViewById(R.id.progress);
        maximo = (TextView)findViewById(R.id.txt_max_input);
        minimo = (TextView)findViewById(R.id.txt_min_input);

        maximo.setText("7040163");
        minimo.setText("6.46683703");

        // Asignacion de variables de objetos
        var = ArrayVariables.getArrayVariables();

        // Llamada a los metos para crear listeners y cargar la informacion inicial
        setListeners();
        //cargarRespuesta();
        rellenarGraficaCategorias();
    }

    private void setListeners() {
        tabla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConectorOutputs.setOut(outputs);
                Intent i = new Intent(Grafica.this, Tabla.class);
                startActivity(i);
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Grafica.this, MainActivity.class);
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Grafica.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    /*public void cargarRespuesta(){
        progreso.setVisibility(View.VISIBLE);
        for(Variables v : var){
           final Gson gson = new Gson();
           JsonObjectRequest request;
           VolleySingleton.getInstance(Grafica.this).
                   addToRequestQueue(
                           request = new JsonObjectRequest(
                                   Request.Method.GET ,
                                   urls + "android=0&v1=" + v.getValor0() +
                                           "&v2=" + v.getValor1() +
                                           "&v3=" + v.getValor2() +
                                           "&v4=" + v.getValor3() +
                                           "&v5=" + v.getValor4() +
                                           "&v6=" + v.getValor5() +
                                           "&v7=" + v.getValor6() +
                                           "&v8=" + v.getValor7() +
                                           "&v9=" + v.getValor8() +
                                           "&v10=" + v.getValor9() +
                                           "&v11=" + v.getValor10() +
                                           "&v12=" + v.getValor11() +
                                           "&v13="  + v.getValor12() +
                                           "&v14=" + v.getValor13() ,
                                   new Response.Listener<JSONObject>() {
                                       @Override
                                       public void onResponse(JSONObject response) {
                                           try {
                                               String res = response.getString("res");
                                               switch(res){
                                                   case "1":
                                                       Log.i("peticion", "caso 1");
                                                       Outputs o = new Outputs();
                                                       JSONArray jArrayMarcadores = response.getJSONArray("data");
                                                       Outputs[] arraycuentasTotales = gson.fromJson(jArrayMarcadores.toString(), Outputs[].class);
                                                       Log.i("peticion", "tamaño: " + arraycuentasTotales.length);
                                                       outputs.add(arraycuentasTotales[0]);
                                                       break;
                                                   case "0":

                                                       break;
                                                   default:

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
       }
       progreso.setVisibility(View.GONE);
       rellenarGraficaCategorias();
    }*/

    private void rellenarGraficaCategorias() {
        //creacion de la grafica
        BarChart barChart = (BarChart) findViewById(R.id.graficaDatos);

        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        int flagIndex = 0;

        entries.add(new BarEntry(7.1980655f, 0));
        entries.add(new BarEntry(740163f, 1));
        entries.add(new BarEntry(490000.0f, 2));
        entries.add(new BarEntry(102122.5535f, 3));
        entries.add(new BarEntry(102122.7266f, 4));
        entries.add(new BarEntry(6.46683703f, 5));
        entries.add(new BarEntry(452.740163f, 6));
        entries.add(new BarEntry(490000.0f, 7));
        entries.add(new BarEntry(1154.981122f, 8));
        entries.add(new BarEntry(102122.7266f, 9));
        entries.add(new BarEntry(7.1980655f, 10));
        entries.add(new BarEntry(740163f, 11));
        entries.add(new BarEntry(490000.0f, 12));
        entries.add(new BarEntry(102122.5535f, 13));
        entries.add(new BarEntry(102122.7266f, 14));
        entries.add(new BarEntry(6.46683703f, 15));
        entries.add(new BarEntry(452.740163f, 16));
        entries.add(new BarEntry(490000.0f, 17));
        entries.add(new BarEntry(1154.981122f, 18));
        entries.add(new BarEntry(102122.7266f, 19));
        entries.add(new BarEntry(7.1980655f, 20));
        entries.add(new BarEntry(740163f, 21));
        entries.add(new BarEntry(490000.0f, 22));
        entries.add(new BarEntry(102122.5535f, 23));
        entries.add(new BarEntry(102122.7266f, 24));

        labels.add("Load.G_air");
        labels.add("comp.T_stag_out");
        labels.add("comp.P_stag_out");
        labels.add("Turbine.T_stage_out");
        labels.add("Turbine.P_stage_out");
        labels.add("Load.G_air");
        labels.add("comp.T_stag_out");
        labels.add("comp.P_stag_out");
        labels.add("Turbine.T_stage_out");
        labels.add("Turbine.P_stage_out");
        labels.add("Load.G_air");
        labels.add("comp.T_stag_out");
        labels.add("comp.P_stag_out");
        labels.add("Turbine.T_stage_out");
        labels.add("Turbine.P_stage_out");
        labels.add("Load.G_air");
        labels.add("comp.T_stag_out");
        labels.add("comp.P_stag_out");
        labels.add("Turbine.T_stage_out");
        labels.add("Turbine.P_stage_out");
        labels.add("Load.G_air");
        labels.add("comp.T_stag_out");
        labels.add("comp.P_stag_out");
        labels.add("Turbine.T_stage_out");
        labels.add("Turbine.P_stage_out");

        BarDataSet dataset = new BarDataSet(entries, "");

        BarData data = new BarData(labels, dataset);
        int[] colores = {Color.parseColor("#025090"), Color.parseColor("#45ADA8"),
                Color.parseColor("#C230AC"), Color.parseColor("#32C07C"),
                Color.parseColor("#E97E0A"), Color.parseColor("#F00209")};
        dataset.setColors(ColorTemplate.createColors(colores));//
        barChart.setData(data);
        barChart.setDescription("");
        barChart.animateY(7500);
        LimitLine line = new LimitLine(10f);
    }
}
