package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CarRentalAvailable extends AppCompatActivity {

    ImageButton xbtn;
    Button rentNow1, rentNow2, rentNow3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rental_available);

        xbtn = findViewById(R.id.x_btn);
        rentNow1 = findViewById(R.id.rentNows1);
        rentNow2 = findViewById(R.id.rentNows2);
        rentNow3 = findViewById(R.id.rentNows3);

        xbtn.setOnClickListener(view -> {
            Intent intent = new Intent(CarRentalAvailable.this, CarRental.class);
            startActivity(intent);
        });

        rentNow1.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "You Successfully Rented a Car ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(CarRentalAvailable.this, CarRental.class);
            startActivity(intent);
        });
        rentNow2.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "You Successfully Rented a Car ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(CarRentalAvailable.this, CarRental.class);
            startActivity(intent);
        });
        rentNow3.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "You Successfully Rented a Car ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(CarRentalAvailable.this, CarRental.class);
            startActivity(intent);
        });

    }

}