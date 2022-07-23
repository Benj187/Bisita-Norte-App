package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class VacationStatus extends AppCompatActivity {

    Button xbtn;
    TextView DateIn, DateOut, HotelInName, HotelOutName;
    String Pay, CheckIn, CheckOut, Hotelname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_status);


        xbtn = findViewById(R.id.backButton);
        HotelInName = findViewById(R.id.CheckIN);
        HotelOutName = findViewById(R.id.CheckOUT);
        DateIn = findViewById(R.id.DateNo1);
        DateOut = findViewById(R.id.DateNo2);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Hotelname = sp.getString("HotelName","");
        CheckIn = sp.getString("CheckIn", "");
        CheckOut = sp.getString("CheckOut", "");
        Pay = sp.getString("Paid","");

        String Payed = "Payed", None = "None";

        if (Payed.equals(Pay)) {
            HotelInName.setText(Hotelname);
            HotelOutName.setText(Hotelname);
            DateIn.setText(CheckIn);
            DateOut.setText(CheckOut);
        }
        else {
            DateIn.setText(None);
            DateOut.setText(None);
        }

        xbtn.setOnClickListener(view -> {
            Intent intent = new Intent(VacationStatus.this, More.class);
            startActivity(intent);
        });

        NavigationBarView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.more);

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
        Intent intent = new Intent(VacationStatus.this, HomeIntro.class);
        startActivity(intent);
        finish();
    }
    public void goSave (){
        Intent intent = new Intent(VacationStatus.this, Save.class);
        startActivity(intent);
        finish();
    }
    public void goBooking (){
        Intent intent = new Intent(VacationStatus.this, Booking.class);
        startActivity(intent);
        finish();
    }
    public void goMessage (){
        Intent intent = new Intent(VacationStatus.this, Messages.class);
        startActivity(intent);
        finish();
    }
    public void goMore (){
        Intent intent = new Intent(VacationStatus.this, More.class);
        startActivity(intent);
        finish();
    }
}