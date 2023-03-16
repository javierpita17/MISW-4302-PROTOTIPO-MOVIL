package com.javier.ux.alarmevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class UpdateActivity extends AppCompatActivity {

    Button btnAcceptEdit;

    Button btnCancelEdit;

    ImageButton btnUpdateClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        btnAcceptEdit = (Button)findViewById(R.id.idBtnAcceptEdit);

        btnCancelEdit = (Button)findViewById(R.id.idBtnCancelEdit);

        btnUpdateClose = (ImageButton)findViewById(R.id.idBtnUpdateClose);

        btnAcceptEdit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new SweetAlertDialog(UpdateActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Alarma actualizada con éxito")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener(){
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                Intent intent = new Intent(UpdateActivity.this, DashboardActivity.class);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        });


        btnCancelEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnUpdateClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}