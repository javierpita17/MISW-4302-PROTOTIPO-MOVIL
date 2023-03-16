package com.javier.ux.alarmevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class DashboardActivity extends AppCompatActivity {

    ListView simpleList;

    Button btnCreateAlarm;

    String listaAlarmas [] = {"Alarma parcial", "Alarma cumpleaños" ,"Alarma partido" ,"Alarma universidad" ,"Alarma fiesta familiar"};

    ImageButton btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnCreateAlarm = (Button)findViewById(R.id.idBtnNewAlarm);

        simpleList = (ListView)findViewById(R.id.idListAlarm);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.idTextViewAlarm, listaAlarmas);

        simpleList.setAdapter(arrayAdapter);

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