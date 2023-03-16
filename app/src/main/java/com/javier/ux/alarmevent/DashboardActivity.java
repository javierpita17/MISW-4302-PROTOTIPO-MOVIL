package com.javier.ux.alarmevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardActivity extends AppCompatActivity{

    ListView simpleList;

    Button btnCreateAlarm;


    ImageButton btnClose;

    ImageButton btnDeleteItem;

    ImageButton btnEditItem;

    ArrayList<String> aux = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnCreateAlarm = (Button)findViewById(R.id.idBtnNewAlarm);

        simpleList = (ListView)findViewById(R.id.idListAlarm);

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.idTextViewAlarm, listaAlarmas);


        aux.add("Alarma parcial");
        aux.add("Alarma cumpleaños");
        aux.add("Alarma partido");
        aux.add("Alarma universidad");
        aux.add("Alarma fiesta familiar");
        aux.add("Clase música");
        aux.add("Visita familiar");

        simpleList.setAdapter(new MyCustomAdapter(aux,DashboardActivity.this));

        btnClose = (ImageButton) findViewById(R.id.idBtnDashboardClose);


        btnCreateAlarm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, createActivity.class);
                startActivity(intent);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}