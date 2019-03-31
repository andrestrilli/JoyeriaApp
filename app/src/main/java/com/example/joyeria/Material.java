package com.example.joyeria;

import android.support.v7.app.AppCompatActivity;

public class Material extends AppCompatActivity {

    private String Id;
    private String NombreMaterial;
    private String TipoMaterial;
    private int PrecioPulsera;
    private int PrecioCadena;

    public Material(String id, String nombreMaterial, String tipoMaterial, int precioPulsera, int precioCadena) {
        NombreMaterial = nombreMaterial;
        TipoMaterial = tipoMaterial;
        PrecioPulsera = precioPulsera;
        PrecioCadena = precioCadena;
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombreMaterial() {
        return NombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        NombreMaterial = nombreMaterial;
    }

    public String getTipoMaterial() {
        return TipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        TipoMaterial = tipoMaterial;
    }

    public int getPrecioPulsera() {
        return PrecioPulsera;
    }

    public void setPrecioPulsera(int precioPulsera) {
        PrecioPulsera = precioPulsera;
    }

    public int getPrecioCadena() {
        return PrecioCadena;
    }

    public void setPrecioCadena(int precioCadena) {
        PrecioCadena = precioCadena;
    }

    @Override
    public String toString() {
        return NombreMaterial;
    }


}
