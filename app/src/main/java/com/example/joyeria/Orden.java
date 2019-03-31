package com.example.joyeria;

import android.support.v7.app.AppCompatActivity;

public class Orden extends AppCompatActivity {

    private Material MaterialBase;
    private Material Piedra;
    private String TipoPrenda;
    private boolean Marcada;
    private int PrecioTotal;

    public Orden(Material materialBase, Material piedra, boolean marcada, String tipoPrenda) {
        MaterialBase = materialBase;
        Piedra = piedra;
        Marcada = marcada;
        TipoPrenda = tipoPrenda;
        //tipo prenda  P = pulsera  C=Cadena
        if (tipoPrenda== "P"){
            PrecioTotal = materialBase.getPrecioPulsera()+piedra.getPrecioPulsera();
        }else{
            PrecioTotal= materialBase.getPrecioCadena()+piedra.getPrecioCadena();
        }

    }

    public Material getMaterialBase() {
        return MaterialBase;
    }

    public void setMaterialBase(Material materialBase) {
        MaterialBase = materialBase;
    }

    public Material getPiedra() {
        return Piedra;
    }

    public void setPiedra(Material piedra) {
        Piedra = piedra;
    }

    public String getTipoPrenda() {
        return TipoPrenda;
    }

    public void setTipoPrenda(String tipoPrenda) {
        TipoPrenda = tipoPrenda;
    }

    public boolean isMarcada() {
        return Marcada;
    }

    public void setMarcada(boolean marcada) {
        Marcada = marcada;
    }

    public int getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        PrecioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return MaterialBase + " " + Piedra;
    }

}
