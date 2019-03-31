package com.example.joyeria;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

import java.util.ArrayList;

public class CreateJewel extends AppCompatActivity {
    private Spinner JewelType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_jewelry);
    }
}
