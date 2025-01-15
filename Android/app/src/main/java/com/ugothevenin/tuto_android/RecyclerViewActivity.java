package com.ugothevenin.tuto_android;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ArrayList<Country> countries = new ArrayList<>();

        countries.add(new Country("MexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexicoMexico",R.drawable.mexico_flag_small));
        countries.add(new Country("France",R.drawable.france_flag_small));
        countries.add(new Country("Australia",R.drawable.australia_flag_small));
        countries.add(new Country("Tunisia",R.drawable.tunisia_flag_small));
        countries.add(new Country("India",R.drawable.india_flag_small));
        countries.add(new Country("China",R.drawable.china_flag_small));

        //Sort en appeler la méthode sur l'élément a et renvoie une valeur négative, permet de trier par ordre décroissant
        //countries.sort((a,b)-> a.compareTo(b) * -1);

        //Sort avec la méthode par defaut définie dans Country grâce à l'implements
        countries.sort(Country::compareTo);


        RecyclerView recyclerView = findViewById(R.id.rv_country);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CountryAdapter(countries, this));

    }
    /*public void printToast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }*/



}