package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationBarView;

public class Spots extends AppCompatActivity {

    ImageView view1;
    CheckBox checkBox;
    SharedPreferences sp;
    String Save, Unsave, save, unsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);

        view1 = findViewById(R.id.tangadanfalls);
        checkBox = findViewById(R.id.heart1);

        VerifySave();

        sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        checkBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked){
                checkBox.setBackgroundResource(R.drawable.ic_save);
                Save = "save";
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Save", Save);
                editor.commit();
                //ON
            }
            else {
                Unsave = "unsave";
                checkBox.setBackgroundResource(R.drawable.ic_heart);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Unsave", Unsave);
                editor.commit();
                //OFF
            }
        });

        view1.setOnClickListener(view -> {
            Intent intent = new Intent(Spots.this, SpotDetails.class);
            startActivity(intent);
        });

        NavigationBarView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Spots);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                goHome();
                return true;
            }
            else if (item.getItemId() == R.id.save) {
                goSave();
                return true;
            }
            else if (item.getItemId() == R.id.bookings) {
                goBooking();
                return true;
            }
            else if (item.getItemId() == R.id.message) {
                goMessage();
                return true;
            }
            else if (item.getItemId() == R.id.more) {
                goMore();
                return true;
            }
            else {
                return false;
            }
        });
    }

    private void VerifySave() {
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        save = sp.getString("Save","");
        unsave = sp.getString("UnSave","");

        String Save = "save", unSave = "unsave";
        if (Save.equals(save)){
            Save = "save";
            checkBox.setBackgroundResource(R.drawable.ic_save);
        }
        if (unSave.equals(unsave)){
            Unsave = "unsave";
            checkBox.setBackgroundResource(R.drawable.ic_heart);
        }
    }

    public void goHome (){
        Intent intent = new Intent(Spots.this, HomeIntro.class);
        startActivity(intent);
    }
    public void goSave (){
        Intent intent = new Intent(Spots.this, Save.class);
        startActivity(intent);
    }
    public void goBooking (){
        Intent intent = new Intent(Spots.this, Booking.class);
        startActivity(intent);
    }
    public void goMessage (){
        Intent intent = new Intent(Spots.this, Messages.class);
        startActivity(intent);
    }
    public void goMore (){
        Intent intent = new Intent(Spots.this, More.class);
        startActivity(intent);
    }
}