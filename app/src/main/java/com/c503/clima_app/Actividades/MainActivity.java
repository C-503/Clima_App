package com.c503.clima_app.Actividades;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.c503.clima_app.Adaptadores.HoraAdaptada;
import com.c503.clima_app.Dominios.Hora;
import com.c503.clima_app.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterHora;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initRecyclerview();
        setVariable();
    }

    private void setVariable() {
        TextView next7dayBtn = findViewById(R.id.pronosticoBtn);
        next7dayBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FutureActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<Hora> items = new ArrayList<>();

        items.add(new Hora("9 PM", 28, "cloudy"));
        items.add(new Hora("11 PM", 29, "sunny"));
        items.add(new Hora("12 PM", 30, "wind"));
        items.add(new Hora("1 AM", 29, "rainy"));
        items.add(new Hora("2 AM", 27, "storm"));

        recyclerView = findViewById(R.id.reclicar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false ));

        adapterHora = new HoraAdaptada(items);
        recyclerView.setAdapter(adapterHora);
    }

}