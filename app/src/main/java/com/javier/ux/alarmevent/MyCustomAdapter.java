package com.javier.ux.alarmevent;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MyCustomAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<String> list = new ArrayList<String>();
    private Context context;

    public MyCustomAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return list.get(pos).length()-1;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_list_view, null);
        }

        //Handle TextView and display string from your list
        TextView tvContact= (TextView)view.findViewById(R.id.idTextViewAlarm);
        tvContact.setText(list.get(position));

        //Handle buttons and add onClickListeners
        ImageButton btnDeleteItem= (ImageButton) view.findViewById(R.id.idBtnListViewDelete);

        ImageButton btnEditItem= (ImageButton) view.findViewById(R.id.idBtnListViewEdit);

        btnDeleteItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("¿Seguro de eliminar la alarma?")
                        .setConfirmText("Aceptar")
                        .setCancelText("Cancelar")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener(){
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog
                                        .setTitleText("Alarma eliminada")
                                        .setConfirmText("Aceptar")
                                        .setConfirmClickListener(null)
                                        .showCancelButton(false)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                            }
                        })
                        .show();
            }
        });


        btnEditItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                context.startActivity(intent);
            }
        });

        return view;
    }


}
