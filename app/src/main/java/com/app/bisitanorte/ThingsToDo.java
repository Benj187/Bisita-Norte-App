package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.navigation.NavigationBarView;

public class ThingsToDo extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_to_do);

        back = findViewById(R.id.backButton);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(ThingsToDo.this, HomeIntro.class);
            startActivity(intent);
        });

        NavigationBarView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.most);

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
        Intent intent = new Intent(ThingsToDo.this, HomeIntro.class);
        startActivity(intent);
    }
    public void goSave (){
        Intent intent = new Intent(ThingsToDo.this, Save.class);
        startActivity(intent);
    }
    public void goBooking (){
        Intent intent = new Intent(ThingsToDo.this, Booking.class);
        startActivity(intent);
    }
    public void goMessage (){
        Intent intent = new Intent(ThingsToDo.this, Messages.class);
        startActivity(intent);
    }
    public void goMore (){
        Intent intent = new Intent(ThingsToDo.this, More.class);
        startActivity(intent);
    }
}
