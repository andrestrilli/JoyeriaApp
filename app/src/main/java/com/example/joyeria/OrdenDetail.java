package com.example.joyeria;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrdenDetail extends AppCompatActivity {

    private Intent In;
    private ArrayList<Orden> Orders;

    private TextView JewelType;
    private TextView Material;
    private TextView Stone;
    private TextView Mark;
    private TextView Price;
    private TextView MarkedText;

    private int Position;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);
        In = getIntent();
        Position = In.getIntExtra("position",0);

        Orders=Data.getOrdenes();

        JewelType = (TextView)findViewById(R.id.TxtTipoPrendaOD);
        Material = (TextView)findViewById(R.id.TxtMaterialBaseOD);
        Stone = (TextView)findViewById(R.id.TxtStoneOD);
        Mark = (TextView)findViewById(R.id.TxtMarkOD);
        Price = (TextView)findViewById(R.id.TxtTotalPriceOD);
        MarkedText=(TextView)findViewById(R.id.TxTMarkedTextOD);

        Orden ord = Orders.get(Position);

        JewelType.setText(ord.getTipoPrenda());
        Material.setText(ord.getMaterialBase().getNombreMaterial());
        Stone.setText(ord.getPiedra().getNombreMaterial());

        if (ord.isMarcada()){
            MarkedText.setVisibility(View.VISIBLE);
            Mark.setText(R.string.Yes);
            MarkedText.setText(ord.getTextMark());
        }else {
            MarkedText.setVisibility(View.INVISIBLE);
            Mark.setText("NO");
        }

        Price.setText(ord.getPrecioTotal()+"");

    }

    public void removeOrder(View view){

        //Confirmacion
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Confirmacion");
        dialogo.setMessage(R.string.alert_conf_remove);
        dialogo.setCancelable(false);
        dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                //Si Acepta
                Data.getOrdenes().get(Position).Remove();
                In = new Intent(OrdenDetail.this, OrdersJewelry.class);
                startActivity(In);
               // Toast.makeText(this,R.string.Deleted,Toast.LENGTH_LONG).show();

            }
        });
        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
        finish();
            }
        });
        dialogo.show();

    }

}
