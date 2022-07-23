package com.app.bisitanorte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Booking extends AppCompatActivity {

    ImageView imgNone;
    TextView textNone;
    RelativeLayout layout;
    Button complete, cancelled, pending;
    String Pay;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        layout = findViewById(R.id.addHotel);
        imgNone = findViewById(R.id.img_none);
        textNone = findViewById(R.id.text_none);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Pay = sp.getString("Paid","");

        NavigationBarView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bookings);

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
        complete = findViewById(R.id.btn_completed);
        cancelled = findViewById(R.id.btn_cancelled);
        pending = findViewById(R.id.btn_pending);

        view = getLayoutInflater().inflate(R.layout.add_hotel, null, false);

        complete.setOnClickListener(View -> {
            complete.setTextColor(Color.parseColor("#F00B51"));
            cancelled.setTextColor(Color.parseColor("#919191"));
            pending.setTextColor(Color.parseColor("#919191"));

            layout.removeView(view);
        });

        cancelled.setOnClickListener(View -> {
                cancelled.setTextColor(Color.parseColor("#F00B51"));
                complete.setTextColor(Color.parseColor("#919191"));
                pending.setTextColor(Color.parseColor("#919191"));

                layout.removeView(view);
        });

        pending.setOnClickListener(V -> {
            pending.setTextColor(Color.parseColor("#F00B51"));
            cancelled.setTextColor(Color.parseColor("#919191"));
            complete.setTextColor(Color.parseColor("#919191"));

            String Payed = "Payed";

            if(Payed.equals(Pay)) {
                imgNone.setVisibility(View.GONE);
                textNone.setVisibility(View.GONE);
                ImageView spotimg = view.findViewById(R.id.spotimg);
                TextView spotname = view.findViewById(R.id.spotName);
                ImageView lct = view.findViewById(R.id.lct);
                TextView lctname = view.findViewById(R.id.lctName);
                view.setPadding(0, 0, 50, 0);
                layout.setPadding(50, 0, 0, 0);
                layout.addView(view);
                layout.isShown();
            }

        });

    }
    public void goHome (){
        Intent intent = new Intent(Booking.this, HomeIntro.class);
        startActivity(intent);
        finish();
    }
    public void goSave (){
        Intent intent = new Intent(Booking.this, Save.class);
        startActivity(intent);
        finish();
    }
    public void goBooking (){
        Intent intent = new Intent(Booking.this, Booking.class);
        startActivity(intent);
        finish();
    }
    public void goMessage (){
        Intent intent = new Intent(Booking.this, Messages.class);
        startActivity(intent);
        finish();
    }
    public void goMore (){
        Intent intent = new Intent(Booking.this, More.class);
        startActivity(intent);
        finish();
    }
}