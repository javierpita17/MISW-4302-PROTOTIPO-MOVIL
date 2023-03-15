package com.javier.ux.alarmevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DashboardActivity extends AppCompatActivity {

    ListView simpleList;

    String listaAlarmas [] = {"Alarma parcial", "Alarma cumpleaños" ,"Alarma partido" ,"Alarma universidad" ,"Alarma fiesta familiar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        simpleList = (ListView)findViewById(R.id.idListAlarm);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.idTextViewAlarm, listaAlarmas);

        simpleList.setAdapter(arrayAdapter);
    }
}