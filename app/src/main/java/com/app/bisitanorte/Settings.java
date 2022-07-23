package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationBarView;

public class Settings extends AppCompatActivity {
    RelativeLayout accInfo, logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        accInfo = findViewById(R.id.acc_info);
        logOut = findViewById(R.id.log_out);

        logOut.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.this,Login.class);
            startActivity(intent);
        });

        accInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        NavigationBarView bottomNavigationView = findViewById(R.id.bottom_navigation);
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
        Intent intent = new Intent(Settings.this, HomeIntro.class);
        startActivity(intent);
    }
    public void goSave (){
        Intent intent = new Intent(Settings.this, Save.class);
        startActivity(intent);
    }
    public void goBooking (){
        Intent intent = new Intent(Settings.this, Booking.class);
        startActivity(intent);
    }
    public void goMessage (){
        Intent intent = new Intent(Settings.this, Messages.class);
        startActivity(intent);
    }
    public void goMore (){
        Intent intent = new Intent(Settings.this, More.class);
        startActivity(intent);

    }
}