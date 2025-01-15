package com.ugothevenin.tuto_android;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class CountryHolder extends RecyclerView.ViewHolder {
    public ImageView ivFlag;
    public TextView tvCountryName;
    public ConstraintLayout clItem;

    public CountryHolder(@NonNull View itemView) {
        super(itemView);

        ivFlag = itemView.findViewById(R.id.iv_item_flag);
        tvCountryName = itemView.findViewById(R.id.iv_item_label);
        clItem = itemView.findViewById(R.id.cl_item_rv_country);
    }

}
