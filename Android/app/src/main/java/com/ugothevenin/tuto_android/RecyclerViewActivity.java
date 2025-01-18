package com.ugothevenin.tuto_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private ArrayList<Country> countries;
    private CountryAdapter countryAdapter;
    RecyclerView recyclerView;
    public final static int REQUEST_COUNTRY = 4054;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        countries = new ArrayList<>();

        countries.add(new Country("Mexico",R.drawable.mexico_flag_small));
        countries.add(new Country("France",R.drawable.france_flag_small));
        countries.add(new Country("Australia",R.drawable.australia_flag_small));
        countries.add(new Country("Tunisia",R.drawable.tunisia_flag_small));
        countries.add(new Country("India",R.drawable.india_flag_small));
        countries.add(new Country("China",R.drawable.china_flag_small));countries.add(new Country("Mexico",R.drawable.mexico_flag_small));
        countries.add(new Country("France",R.drawable.france_flag_small));
        countries.add(new Country("Australia",R.drawable.australia_flag_small));
        countries.add(new Country("Tunisia",R.drawable.tunisia_flag_small));
        countries.add(new Country("India",R.drawable.india_flag_small));
        countries.add(new Country("China",R.drawable.china_flag_small));

        //Sort en appeler la méthode sur l'élément a et renvoie une valeur négative, permet de trier par ordre décroissant
        //countries.sort((a,b)-> a.compareTo(b) * -1);

        //Sort avec la méthode par defaut définie dans Country grâce à l'implements
        countries.sort(Country::compareTo);


        recyclerView = findViewById(R.id.rv_country);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        countryAdapter = new CountryAdapter(countries);
        countryAdapter.setMyCallback(o -> Toast.makeText(this, ((Country)o).getCountryName(), Toast.LENGTH_SHORT).show());

        recyclerView.setAdapter(countryAdapter);
        Button btnAddCountry = findViewById(R.id.btn_rv_addCountry);
        btnAddCountry.setOnClickListener(e->{
            //Créer un startactivityforresult()
            Intent intent = new Intent(this, CreateCountryActivity.class);
            startActivityForResult(intent, REQUEST_COUNTRY);
//            countries.add(new Country("Brésil", "https://cdn.countryflags.com/thumbs/brazil/flag-800.png"));
//            countryAdapter.notifyItemInserted(countryAdapter.getItemCount());
        });

        //Checker les touches du clavier et ajouter dans l'url
        //btnAddCountry.setOnKeyListener((this, integer, keyEvent)->{return true;});
    }


    /*public void printToast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }*/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_COUNTRY){
            if(resultCode == RESULT_OK && data != null){
                Country country = data.getParcelableExtra(CreateCountryActivity.KEY_COUNTRY_INFORMATIONS);
                Log.d("test", ""+country.getUrlPicture()+" "+country.getCountryName());
                countries.add(country);
                countryAdapter.notifyItemInserted(countryAdapter.getItemCount());
                recyclerView.scrollToPosition(countries.size() - 1);
            }
        }
    }
}