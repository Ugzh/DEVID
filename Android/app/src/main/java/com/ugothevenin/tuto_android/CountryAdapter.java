package com.ugothevenin.tuto_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryHolder> implements IPrintToast {

    private ArrayList<Country> countries;
    private RecyclerViewActivity rv;


    public CountryAdapter(ArrayList<Country> countries, RecyclerViewActivity rv){
        this.countries = countries;
        this.rv = rv;
    }

    public CountryAdapter(){};
    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_country, parent, false);
        return new CountryHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        Country country = countries.get(position);
        holder.tvCountryName.setText(country.getCountryName());
        holder.ivFlag.setImageResource(country.getResId());
        holder.clItem.setOnClickListener(e -> {
            printToast(e.getContext(),holder.tvCountryName.getText().toString());
            //rv.printToast(countryName);

        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    @Override
    public void printToast(Context context, String country) {
        Toast.makeText(context, country, Toast.LENGTH_SHORT).show();
    }

}
