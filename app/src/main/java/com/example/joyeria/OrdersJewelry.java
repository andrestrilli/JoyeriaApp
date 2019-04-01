package com.example.joyeria;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrdersJewelry extends AppCompatActivity {

    private ListView LVOrders;
    private android.content.res.Resources Resources;
    private Intent In;
    private ArrayList<Orden> Orders;
    private ArrayList<String> OrderStrings;
    private TextView NoResults;
    private Orden act;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders_jewelry);

      Orders= new ArrayList<Orden>();

       LVOrders= (ListView)findViewById(R.id.LVOrder);
        Resources = this.getResources();
        NoResults= (TextView)findViewById(R.id.TxtNoResults);
        Orders=Data.getOrdenes();
        OrderStrings = new ArrayList<String>();
        NoResults.setVisibility(View.VISIBLE);
        LVOrders.setVisibility(View.INVISIBLE);

        if (Orders.size() > 0){
            NoResults.setVisibility(View.INVISIBLE);
            LVOrders.setVisibility(View.VISIBLE);
            for (int i = 0; i < Orders.size(); i++) {
                act= Orders.get(i);

                OrderStrings.add(act.getTipoPrenda()+" + "+act.getPiedra()+"    "+
                        (act.getPrecioTotal()/1000)+"mil");

            }

        }


        ArrayAdapter<String> Adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,OrderStrings);
        LVOrders.setAdapter(Adapter);

        LVOrders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                In= new Intent(OrdersJewelry.this, OrdenDetail.class);
                In.putExtra("position",position);
                startActivity(In);
            }
        });





    }

}
