package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Messages extends AppCompatActivity {

    ImageButton addMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        addMessage = findViewById(R.id.addMessage);

        addMessage.setOnClickListener(view -> {
            Intent intent = new Intent(Messages.this,NewMessage.class);
            startActivity(intent);
        });

        NavigationBarView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.message);

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
        Intent intent = new Intent(Messages.this, HomeIntro.class);
        startActivity(intent);
        finish();
    }
    public void goSave (){
        Intent intent = new Intent(Messages.this, Save.class);
        startActivity(intent);
        finish();
    }
    public void goBooking (){
        Intent intent = new Intent(Messages.this, Booking.class);
        startActivity(intent);
        finish();
    }
    public void goMessage (){
        Intent intent = new Intent(Messages.this, Messages.class);
        startActivity(intent);
        finish();
    }
    public void goMore (){
        Intent intent = new Intent(Messages.this, More.class);
        startActivity(intent);
        finish();
    }
}