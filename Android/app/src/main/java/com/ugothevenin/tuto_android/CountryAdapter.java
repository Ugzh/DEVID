package com.ugothevenin.tuto_android;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryHolder>{

    private ArrayList<Country> countries;
    private RecyclerViewActivity rv;
    private ISendContext iSendContext;
    private ICountryName iCountryName;

    private MyCallback myCallback;
    private CountryHolder holder;

    public CountryAdapter(ArrayList<Country> countries, @NonNull RecyclerViewActivity rv){
        this.countries = countries;
        this.rv = rv;
    }

    public CountryAdapter(ArrayList<Country> countries){
        this.countries = countries;
    };
    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_country, parent, false);
        return new CountryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        this.holder = holder;
        Country country = countries.get(position);
        holder.tvCountryName.setText(country.getCountryName());
        //holder.ivFlag.setImageResource(country.getResId());
        String url = "https://cdn.countryflags.com/thumbs/"+holder.tvCountryName.getText().toString().toLowerCase()+"/flag-800.png";
        Picasso.get().load(url).into(holder.ivFlag);
        if(country.getUrlPicture() != null)
            Picasso.get().load(country.getUrlPicture()).into(holder.ivFlag);
        else
            Picasso.get().load(country.getResId()).into(holder.ivFlag);


        //holder.clItem.setOnClickListener(e -> {
            //rv.printToast(country.getCountryName());
            //Toast.makeText(iSendContext.getContext(), country.getCountryName(),Toast.LENGTH_SHORT).show();
          /* if(iCountryName != null)
               iCountryName.displayCountryName(country.getCountryName());

           if(myCallback != null)
               myCallback.onAction(country.getCountryName());*/
        //});


    }

    public void setICountryName(ICountryName iCountryName) {
        this.iCountryName = iCountryName;
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void setMyCallback(MyCallback myCallback) {
        this.myCallback = myCallback;
    }





}
