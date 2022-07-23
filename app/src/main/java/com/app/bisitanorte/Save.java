package com.app.bisitanorte;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

public class Save extends AppCompatActivity {
    RelativeLayout layout1;
    String save, unsave, SAVE, UNSAVE;
    SharedPreferences xp;

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        layout1 = findViewById(R.id.linear1);
        String Save = "save", unSave = "unsave";

        view = getLayoutInflater().inflate(R.layout.add_spot, null, false);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        save = sp.getString("Save","");
        unsave = sp.getString("UnSave","");

        xp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if (Save.equals(save)){
                SAVE = "save";
                ImageView spotimg = view.findViewById(R.id.spotimg);
                TextView spotname = view.findViewById(R.id.spotName);
                ImageView lct = view.findViewById(R.id.lct);
                TextView lctname = view.findViewById(R.id.lctName);
                view.setPadding(0, 0, 50, 0);
                layout1.setPadding(50, 0, 0, 0);
                layout1.addView(view);
                layout1.isShown();
            SharedPreferences.Editor editor = xp.edit();
            editor.putString("Save",SAVE);
            editor.commit();
        }
        else if (unSave.equals(unsave)){
            UNSAVE = "unsave";
                layout1.removeView(view);
            SharedPreferences.Editor editor = xp.edit();
            editor.putString("UnSave",UNSAVE);
            editor.commit();
        }
        NavigationBarView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.save);

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
    public void goHome (){
        Intent intent = new Intent(Save.this, HomeIntro.class);
        startActivity(intent);
        finish();
    }
    public void goSave (){
        Intent intent = new Intent(Save.this, Save.class);
        startActivity(intent);
        finish();
    }
    public void goBooking (){
        Intent intent = new Intent(Save.this, Booking.class);
        startActivity(intent);
        finish();
    }
    public void goMessage (){
        Intent intent = new Intent(Save.this, Messages.class);
        startActivity(intent);
        finish();
    }
    public void goMore (){
        Intent intent = new Intent(Save.this, More.class);
        startActivity(intent);
        finish();
    }
}