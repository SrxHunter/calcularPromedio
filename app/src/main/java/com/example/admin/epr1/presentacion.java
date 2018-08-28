package com.example.admin.epr1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class presentacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
    }
    public void Calculo(View v){
        startActivity(new Intent(presentacion.this, MainActivity.class));
    }
    public void CalculoExamen(View v){
        startActivity(new Intent(presentacion.this, calculo2.class));
    }
    public void Creditos(View v){
        startActivity(new Intent(presentacion.this, resultados.class));
    }
}
