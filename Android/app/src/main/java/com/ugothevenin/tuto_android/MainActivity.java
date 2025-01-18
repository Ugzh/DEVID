package com.ugothevenin.tuto_android;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity {

    private final int REQUEST_FIRSTNAME = 100;

    private final String TAG = MainActivity.class.getSimpleName();
    public final static String KEY_FIRSTNAME = "KEY_FIRSTNAME";
    public final static String KEY_PERSON = "KEY_PERSON";
    EditText etFirstname;

    //public final static String KEY_FIRSTNAME = "KEY_FIRSTNAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etLastname = findViewById(R.id.et_main_lastname);
        EditText etAge = findViewById(R.id.et_main_number);
        etFirstname = findViewById(R.id.et_main_firstname);

        Button btnVal = findViewById(R.id.btn_main);

        btnVal.setOnClickListener(view->{
            String message = "";
            String firstname = etFirstname.getText().toString().trim();
            String lastname = etLastname.getText().toString().trim();
            String age = etAge.getText().toString().trim();

            if(firstname.isEmpty() || lastname.isEmpty() || age.isEmpty()){
                message = "Veuillez remplir tous les champs";
            } else {
                message = "Bonjour, je m'appelle " + firstname + " " + lastname + " et je suis " + (Integer.parseInt(age) >= 18 ? "majeur" : "mineur ");
            }
            //Exercice 1

            Intent intent = new Intent(this, MainActivity2.class);

            //intent.putExtra(KEY_FIRSTNAME, firstname);
            intent.putExtra(KEY_PERSON, new Person(firstname,lastname,Integer.parseInt(age)));

            startActivity(intent);
            finish();

            //Exercice 2 optionnel
            //startActivityForResult(new Intent(this, MainActivity2.class), REQUEST_FIRSTNAME);


            /*startActivity(new Intent(this, MainActivity2.class));
            Toast.makeText(this,  , Toast.LENGTH_SHORT).show();
            if(extras != null){
                finish();
            }*/
        });
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");

    }
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_FIRSTNAME){
            if(resultCode == RESULT_OK && data != null){
                etFirstname.setText(data.getStringExtra(MainActivity2.KEY_FIRSTNAME));
            }
            else {
                if ( data != null){ // provient du bouton back de MainActivity
                    Toast.makeText(this, "canceled from dev", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(this, "canceled from button", Toast.LENGTH_SHORT).show();
            }
        }
    }*/

}