package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.navigation.NavigationBarView;

public class HotelDetails extends AppCompatActivity {

    Button back, bookNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        back = findViewById(R.id.backButton);
        bookNow = findViewById(R.id.BookNow);

        bookNow.setOnClickListener(view -> {
            Intent intent = new Intent(HotelDetails.this, Hotels.class);
            startActivity(intent);
        });

        back.setOnClickListener(view -> {
            Intent intent = new Intent(HotelDetails.this, Hotels.class);
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
        Intent intent = new Intent(HotelDetails.this, HomeIntro.class);
        startActivity(intent);
    }
    public void goSave (){
        Intent intent = new Intent(HotelDetails.this, Save.class);
        startActivity(intent);
    }
    public void goBooking (){
        Intent intent = new Intent(HotelDetails.this, Booking.class);
        startActivity(intent);
    }
    public void goMessage (){
        Intent intent = new Intent(HotelDetails.this, Messages.class);
        startActivity(intent);
    }
    public void goMore () {
        Intent intent = new Intent(HotelDetails.this, More.class);
        startActivity(intent);
    }
}