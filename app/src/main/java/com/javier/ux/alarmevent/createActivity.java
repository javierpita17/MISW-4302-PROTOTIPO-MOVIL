package com.javier.ux.alarmevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class createActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] tiposAlarma = {"Seleccione", "Evento Social", "Deporte", "Universidad", "Evento Religioso"};

    String[] ampm = {"AM", "PM"};

    String[] dias = {"Seleccione", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};


    Spinner spin;

    Spinner spinAmPm;

    Spinner spinDias;

    Button btnAcceptCreate;

    Button btnCancelCreate;

    ImageButton btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        spin = (Spinner)findViewById(R.id.idSpinnerTipoAlarma);

        spinAmPm = (Spinner)findViewById(R.id.idSpinnerAmPm);

        spinDias = (Spinner)findViewById(R.id.idSpinnerDias);

        spin.setOnItemSelectedListener(this);

        spinAmPm.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tiposAlarma);

        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ampm);

        spin.setAdapter(aa);

        spinAmPm.setAdapter(aa2);

        ArrayList<StateVO> listVOs = new ArrayList<>();

        for (int i = 0; i< dias.length; i++){
            StateVO stateVO = new StateVO();
            stateVO.setTitle(dias[i]);
            stateVO.setSelected(false);
            listVOs.add(stateVO);
        }

        MyAdapter myAdapter = new MyAdapter(createActivity.this, 0, listVOs);

        spinDias.setAdapter(myAdapter);


        btnAcceptCreate = (Button) findViewById(R.id.idBtnAcceptCreate);

        btnCancelCreate = (Button) findViewById(R.id.idBtnCancelCreate);

        btnClose = (ImageButton)findViewById(R.id.idBtnCreateClose);


        btnAcceptCreate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new SweetAlertDialog(createActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Alarma creada con éxito")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener(){
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                Intent intent = new Intent(createActivity.this, DashboardActivity.class);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        });

        btnCancelCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(createActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(createActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}