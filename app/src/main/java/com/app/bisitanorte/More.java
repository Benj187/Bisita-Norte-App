package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class More extends AppCompatActivity {

    RelativeLayout myCard, helpCenter, settings, status;
    String Payed, CheckIn, CheckOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        myCard = findViewById(R.id.card_list);
        helpCenter = findViewById(R.id.help_list);
        settings = findViewById(R.id.setting_list);
        status = findViewById(R.id.status_list);

        myCard.setOnClickListener(view -> {
            Intent intent = new Intent(More.this, MyCards.class);
            startActivity(intent);
        });
        helpCenter.setOnClickListener(view -> {

        });
        settings.setOnClickListener(view -> {
            Intent intent = new Intent(More.this, Settings.class);
            startActivity(intent);
        });
        status.setOnClickListener(view -> {
            Intent intent = new Intent(More.this, VacationStatus.class);
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
        Intent intent = new Intent(More.this, HomeIntro.class);
        startActivity(intent);
        finish();
    }
    public void goSave (){
        Intent intent = new Intent(More.this, Save.class);
        startActivity(intent);
        finish();
    }
    public void goBooking (){
        Intent intent = new Intent(More.this, Booking.class);
        startActivity(intent);
        finish();
    }
    public void goMessage (){
        Intent intent = new Intent(More.this, Messages.class);
        startActivity(intent);
        finish();
    }
    public void goMore (){
        Intent intent = new Intent(More.this, More.class);
        startActivity(intent);
        finish();
    }
}