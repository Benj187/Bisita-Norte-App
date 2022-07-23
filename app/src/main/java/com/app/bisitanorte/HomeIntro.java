package com.app.bisitanorte;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

public class HomeIntro extends AppCompatActivity {
    String save, unsave;
    String Saveno1, Saveno2;
    CheckBox save1;
    ImageButton btnrent, btnhotel, btnspot, btntodo, btntrip;
    ImageView spot1;
    SharedPreferences sp;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        save1 = findViewById(R.id.heart1);
        btnhotel =findViewById(R.id.Hotels);
        btnspot =findViewById(R.id.Spots);
        btntodo =findViewById(R.id.ToDo);
        btnrent =findViewById(R.id.CarRent);
        btntrip =findViewById(R.id.Trips);
        spot1 = findViewById(R.id.tangadanfalls);


        spot1.setOnClickListener(view -> {
            Intent intent = new Intent(HomeIntro.this, HotelDetails.class);
            startActivity(intent);
        });

        VerifySave();

        btnhotel.setOnClickListener(view -> {
            Intent intent = new Intent(HomeIntro.this, Hotels.class);
            startActivity(intent);
        });
        btnspot.setOnClickListener(view -> {
            Intent intent = new Intent(HomeIntro.this, Spots.class);
            startActivity(intent);
        });
        btntodo.setOnClickListener(view -> {
            Intent intent = new Intent(HomeIntro.this, ThingsToDo.class);
            startActivity(intent);
        });
        btnrent.setOnClickListener(view -> {
            Intent intent = new Intent(HomeIntro.this, CarRental.class);
            startActivity(intent);
        });
        btntrip.setOnClickListener(view -> {
            Intent intent = new Intent(HomeIntro.this, Trips.class);
            startActivity(intent);
        });

        sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        save1.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked){
                    Saveno1 = "save";
                    save1.setBackgroundResource(R.drawable.ic_save);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Save",Saveno1);
                    editor.commit();
                    //ON
            }
            else {
                Saveno2 = "unsave";
                save1.setBackgroundResource(R.drawable.ic_heart);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("UnSave",Saveno2);
                editor.commit();
                //OFF
            }
        });

        NavigationBarView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
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

    public void VerifySave(){
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        save = sp.getString("Save","");
        unsave = sp.getString("UnSave","");

        String Save = "save", unSave = "unsave";
        if (Save.equals(save)){
            Saveno1 = "save";
            save1.setBackgroundResource(R.drawable.ic_save);
        }
        if (unSave.equals(unsave)){
            Saveno2 = "unsave";
            save1.setBackgroundResource(R.drawable.ic_heart);
        }
    }
    public void goHome (){
        Intent intent = new Intent(HomeIntro.this, HomeIntro.class);
        startActivity(intent);
    }
    public void goSave (){
        Intent intent = new Intent(HomeIntro.this, Save.class);
        startActivity(intent);
    }
    public void goBooking (){
        Intent intent = new Intent(HomeIntro.this, Booking.class);
        startActivity(intent);
    }
    public void goMessage (){
        Intent intent = new Intent(HomeIntro.this, Messages.class);
        startActivity(intent);
    }
    public void goMore (){
        Intent intent = new Intent(HomeIntro.this, More.class);
        startActivity(intent);
    }
}
