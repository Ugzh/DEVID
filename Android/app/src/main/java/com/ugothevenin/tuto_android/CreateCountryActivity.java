package com.ugothevenin.tuto_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.internal.TextWatcherAdapter;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class CreateCountryActivity extends AppCompatActivity {
    public static final String KEY_COUNTRY_INFORMATIONS = "KEY_COUNTRY_INFORMATIONS";
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_country);
        EditText etUrl = findViewById(R.id.et_createCountry_URL);
        EditText etCountryName = findViewById(R.id.et_createCountry_countryName);
        CircleImageView civ = findViewById(R.id.civ_createCountry_flag);
        Button btnValidate = findViewById(R.id.btn_createCountry_validate);

        etUrl.addTextChangedListener(new TextWatcherAdapter(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etUrl.hasFocus()) {
                    Log.d("test", s.toString());
                    if(!s.toString().isEmpty())
                        Picasso.get().load(s.toString()).placeholder(R.drawable.loading).into(civ);
                    else
                        Picasso.get().load(R.drawable.blank).into(civ);
                }
            }
        });

        btnValidate.setOnClickListener(e->{
            String url = etUrl.getText().toString().trim();
            String countryName = etCountryName.getText().toString().trim();

            if(!url.isEmpty() && !countryName.isEmpty())
                setResult(RESULT_OK, new Intent().putExtra(KEY_COUNTRY_INFORMATIONS, new Country(countryName, url)));
            finish();

        });
    }
}