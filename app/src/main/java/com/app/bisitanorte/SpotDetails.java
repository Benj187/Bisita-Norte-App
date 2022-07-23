package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.navigation.NavigationBarView;

public class SpotDetails extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_details);

        back = findViewById(R.id.backButton);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(SpotDetails.this, Spots.class);
            startActivity(intent);
        });

        NavigationBarView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Hotels);

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
        Intent intent = new Intent(SpotDetails.this, HomeIntro.class);
        startActivity(intent);
    }
    public void goSave (){
        Intent intent = new Intent(SpotDetails.this, Save.class);
        startActivity(intent);
    }
    public void goBooking (){
        Intent intent = new Intent(SpotDetails.this, Booking.class);
        startActivity(intent);
    }
    public void goMessage (){
        Intent intent = new Intent(SpotDetails.this, Messages.class);
        startActivity(intent);
    }
    public void goMore () {
        Intent intent = new Intent(SpotDetails.this, More.class);
        startActivity(intent);
    }
}