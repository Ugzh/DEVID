package com.ugothevenin.tuto_android;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;

public class MainActivity2 extends AppCompatActivity {
    //public final static String KEY_FIRSTNAME = "KEY_FIRSTNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText etFirstname = findViewById(R.id.et_main2);
        Button btnVal = findViewById(R.id.btn_main2);

        // Exercice 1
       /* Bundle extras = getIntent().getExtras();
        if(extras != null){
            etFirstname.setText(extras.getString(MainActivity.KEY_FIRSTNAME));
        }*/

       if(getIntent().getExtras() != null){
           Person person = getIntent().getParcelableExtra(MainActivity.KEY_PERSON);
            etFirstname.setText(person.getFirstname());
       }

        btnVal.setOnClickListener(e-> {
            // Exercice 1
            //startActivity(new Intent(this, MainActivity.class));

            //Exercice 2
            /*String info = etFirstname.getText().toString().trim();

            if(!info.isEmpty()){
                setResult(RESULT_OK,
                        new Intent().putExtra(KEY_FIRSTNAME, info));
            }*/

            /*Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(MainActivity.KEY_FIRSTNAME, etFirstname.getText().toString());
            startActivity(intent);*/
            finish();
        });
    }
}