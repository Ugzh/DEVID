package com.ugothevenin.tuto_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryHolder> {

    private ArrayList<Country> countries;

    public CountryAdapter(ArrayList<Country> countries){
        this.countries = countries;
    }
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
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
