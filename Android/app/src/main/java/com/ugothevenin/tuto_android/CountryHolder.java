package com.ugothevenin.tuto_android;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryHolder extends RecyclerView.ViewHolder {
    public ImageView ivFlag;
    public TextView tvCountryName;

    public CountryHolder(@NonNull View itemView) {
        super(itemView);

        ivFlag = itemView.findViewById(R.id.iv_item_flag);
        tvCountryName = itemView.findViewById(R.id.iv_item_label);
    }

}
