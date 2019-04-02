package com.example.joyeria;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class Data extends AppCompatActivity {

    private static ArrayList<Material> Piedras;
    private static ArrayList<Material> MaterialesBase;
    private static ArrayList<Orden> Ordenes= new ArrayList<Orden>();

    public Data() {
       /* Piedras= new ArrayList<Material>();
        //Creo las piedras iniciales de la APP
        Material P1=new Material("P1","Rubi","Piedra",190000,190000);
        Material P2=new Material("P2","Esmeralda","Piedra",180000,180000);
        Material P3=new Material("P3","Quarzo","Piedra",150000,150000);
        Piedras.add(P1);
        Piedras.add(P2);
        Piedras.add(P3);

        //Creo Los Materiales Base
        Material MB1 = new Material("MB1","Plata","MaterialBase",50000,100000);
        Material MB2= new Material("MB2","Acero","MaterialBase",30000,50000);
        Material MB3 = new Material("MB3","Oro","MaterialBase",90000,150000);
        MaterialesBase.add(MB1);
        MaterialesBase.add(MB2);
        MaterialesBase.add(MB3);*/

        Ordenes = new ArrayList<Orden>();

    }

    public static void Repository(){
        Piedras= new ArrayList<Material>();
        //Creo las piedras iniciales de la APP
        Material P1=new Material("P1","Rubi","Piedra",190000,190000);
        Material P2=new Material("P2","Esmeralda","Piedra",180000,180000);
        Material P3=new Material("P3","Quarzo","Piedra",150000,150000);
        Piedras.add(P1);
        Piedras.add(P2);
        Piedras.add(P3);

        //Creo Los Materiales Base
        MaterialesBase = new ArrayList<Material>();
        Material MB1 = new Material("MB1","Plata","MaterialBase",50000,100000);
        Material MB2= new Material("MB2","Acero","MaterialBase",30000,50000);
        Material MB3 = new Material("MB3","Oro","MaterialBase",90000,150000);
        MaterialesBase.add(MB1);
        MaterialesBase.add(MB2);
        MaterialesBase.add(MB3);
    }

    public static ArrayList<Material> getPiedras() {
        return Piedras;
    }

    public void setPiedras(ArrayList<Material> piedras) {
        Piedras = piedras;
    }

    public static ArrayList<Material> getMaterialesBase() {
        return MaterialesBase;
    }

    public void setMaterialesBase(ArrayList<Material> materialesBase) {
        MaterialesBase = materialesBase;
    }

    public static ArrayList<Orden> getOrdenes() {
        return Ordenes;
    }

    public static void setOrdenes(ArrayList<Orden> ordenes) {
        Ordenes = ordenes;
    }

    //METODOS PARA LAS ORDENES

    public static void addOrden(Orden orden){
        Ordenes.add(orden);
    }

    public static void removeOrden(Orden orden){
                Ordenes.remove(orden);
    }

    public static void EditOrden(Orden o,int id,Material MB, Material p, boolean marc, String tP,String txtMark){
        o.setId(id);
        o.setMaterialBase(MB);
        o.setPiedra(p);
        o.setTipoPrenda(tP);
        o.setTextMark(txtMark);
        o.calcularTotal();
    }

}
