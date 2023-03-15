package com.javier.ux.alarmevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RegisterActivity extends AppCompatActivity {

    Button btnCancel;

    Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnCancel = (Button)findViewById(R.id.idBtnRegisterCancel);

        btnAccept = (Button)findViewById(R.id.idBtnRegisterAccept);

        btnCancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
              new SweetAlertDialog(RegisterActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                      .setTitleText("Usuario Creado con éxito")
                      .show();
            }
        });



    }
}