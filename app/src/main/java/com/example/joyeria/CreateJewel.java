package com.example.joyeria;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;

public class CreateJewel extends AppCompatActivity {
    private Spinner JewelType;
    private Spinner MaterialType;
    private Spinner StoneType;
    private String [] TypeJw;
    private String [] TypeMat;
    private String [] TypeSto;
    private Resources Resources;
    private TextView Price;
    private EditText TxtMarked;
    private int PriceMaterials = 0;
    private int PriceStones = 0;
    private int PositionPrenda = 0;
    private int PositionBase=0;
    private int PositionStone=0;
    private CheckBox Mark;
    private NumberFormat FormatMoneda = NumberFormat.getCurrencyInstance();


    private ArrayList<Material> Materials = new ArrayList<Material>();
    private ArrayList<Material> Stones = new ArrayList<Material>();

    private ArrayAdapter<String> AdapterTypeJewel;
    private ArrayAdapter<String> AdapterMaterialBase;
    private ArrayAdapter<String> AdapterPiedra;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_jewelry);

        JewelType = (Spinner)findViewById(R.id.SpType);
        MaterialType = (Spinner)findViewById(R.id.SpSelectMaterial);
        StoneType = (Spinner)findViewById(R.id.SpSelectStong);
        Price = (TextView) findViewById(R.id.LblPrice);
        Mark = (CheckBox) findViewById(R.id.CBMarkJewel);
        TxtMarked= (EditText)findViewById(R.id.EtTextMArked);
        TxtMarked.setVisibility(View.INVISIBLE);

        Resources = this.getResources();

        TypeJw = Resources.getStringArray(R.array.type_jw);
        TypeMat = Resources.getStringArray(R.array.material_jw);
        TypeSto = Resources.getStringArray(R.array.piedra_jw);

        AdapterTypeJewel = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, TypeJw);
        JewelType.setAdapter(AdapterTypeJewel);

        AdapterMaterialBase = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, TypeMat);
        AdapterPiedra = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, TypeSto);


        JewelType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position != 0){
                    MaterialType.setAdapter(AdapterMaterialBase);

                    PositionPrenda = position;
                    Price.setText("Price: $ ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        MaterialType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position != 0){
                    StoneType.setAdapter(AdapterPiedra);
                    Materials = Data.getMaterialesBase();
                    PositionBase=position;

                    if (PositionPrenda == 1){
                        PriceMaterials = Materials.get(position - 1).getPrecioPulsera();
                        Price.setText("Price: "+FormatMoneda.format(PriceMaterials));
                    }else{
                        PriceMaterials = Materials.get(position - 1).getPrecioCadena();
                        Price.setText("Price: "+FormatMoneda.format(PriceMaterials));

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        StoneType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position != 0){

                    Stones = Data.getPiedras();
                    PositionStone=position;
                    if (PositionPrenda == 1){
                        PriceStones = PriceMaterials + Stones.get(position - 1).getPrecioPulsera();
                        Price.setText("Price: "+FormatMoneda.format(PriceStones));
                    }else{
                        PriceStones = PriceMaterials + Stones.get(position - 1).getPrecioCadena();
                        Price.setText("Price: "+FormatMoneda.format(PriceStones));

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Mark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (Mark.isChecked()){

                    TxtMarked.setVisibility(View.VISIBLE);

                 }else{
                    TxtMarked.setVisibility(View.INVISIBLE);
                }
            }
        });


    }

    public void save(View view){

        Material materialBase;
        Material piedra;
        boolean marcada;
        String tipoPrenda;
        String Id;

        //tipoPrenda = PositionPrenda==1?R.string.cj_type_item1+"":R.string.cj_type_item2+"";
        tipoPrenda = PositionPrenda==1?"P":"C";
        materialBase = Materials.get(PositionBase-1);
        piedra= Stones.get(PositionStone-1);
        marcada= Mark.isChecked();



        if (marcada){
            if(TxtMarked.getText().toString().isEmpty()){
                Toast.makeText(this,R.string.empty,Toast.LENGTH_LONG).show();

            }else {
                Orden ord = new Orden(materialBase, piedra, marcada, tipoPrenda, TxtMarked.getText().toString());
                ord.Add();
                Toast.makeText(this, R.string.done, Toast.LENGTH_LONG).show();
            }
        }else {
            Orden ord = new Orden(materialBase,piedra,marcada,tipoPrenda,"");
            ord.Add();
            Toast.makeText(this,R.string.done,Toast.LENGTH_LONG).show();

        }

    }


}
