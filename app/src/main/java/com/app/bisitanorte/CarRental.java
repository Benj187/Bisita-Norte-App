package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.android.material.navigation.NavigationBarView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CarRental extends AppCompatActivity {

    int durHour, durMin, pickUpHour, pickUpMin;
    Button back, SearchCar, withD, withoutD;
    EditText pickUpDate, duration, pickUpTime;
    DatePickerDialog datePickerDialog;
    String pickupDate, Dur, pickupTime;
    private static final String[] LOCATION = new String[]{
            "Ilocos Norte","Ilocos Sur","La Union","Pangasinan","Dagupan City", "Isabela",
            "Nueva Vizcaya","Baguio City","Batangas","Quezon City","Tarlac","Cavite","Pampanga",
            "Bulacan","Rizal"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rental);

        SearchCar = findViewById(R.id.createButton);
        back = findViewById(R.id.backButton);
        pickUpDate = findViewById(R.id.PickupDate);
        duration = findViewById(R.id.durationInput);
        pickUpTime = findViewById(R.id.PickupTime);
        withD = findViewById(R.id.btn_withDriver);
        withoutD = findViewById(R.id.btn_withoutDriver);

        AutoCompleteTextView editText = findViewById(R.id.carRent);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, LOCATION);
        editText.setAdapter(adapter);

        withD.setOnClickListener(view -> {
            withD.setTextColor(Color.parseColor("#F00B51"));
            withoutD.setTextColor(Color.parseColor("#919191"));
        });

        withoutD.setOnClickListener(view -> {
            withoutD.setTextColor(Color.parseColor("#F00B51"));
            withD.setTextColor(Color.parseColor("#919191"));
        });

        pickUpDate.setOnClickListener(view -> {
            theDatePicker();
            datePickerDialog.show();
            pickUpDate.setText(getPickupDate());
        });

        duration.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        CarRental.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            durHour = hourOfDay;
                            durMin = minute;
                            String time = durHour + ":" + durMin;

                                @SuppressLint("SimpleDateFormat") SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                  Date date = f24Hours.parse(time);
                                  @SuppressLint("SimpleDateFormat") SimpleDateFormat f12Hours = new SimpleDateFormat(
                                          "hh:mm aa"
                                  );
                                  duration.setText(f12Hours.format(Objects.requireNonNull(date)));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 24,0,true
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(durHour,durMin);
                timePickerDialog.show();
            }
        });

        pickUpTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog1 = new TimePickerDialog(
                        CarRental.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                pickUpHour = hourOfDay;
                                pickUpMin = minute;
                                String time = pickUpHour + ":" + pickUpMin;

                                @SuppressLint("SimpleDateFormat") SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    @SuppressLint("SimpleDateFormat") SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );

                                    pickUpTime.setText(f12Hours.format(Objects.requireNonNull(date)));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 12,0,false
                );
                timePickerDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog1.updateTime(pickUpHour,pickUpMin);
                timePickerDialog1.show();
            }
        });
        //Input getString
        pickupDate = pickUpDate.getText().toString().trim();
        Dur = duration.getText().toString().trim();
        pickupTime = pickUpTime.getText().toString().trim();

        SearchCar.setOnClickListener(view -> {

            Intent intent = new Intent(CarRental.this, CarRentalAvailable.class);
            intent.putExtra("PickUpDate", pickupDate);
            intent.putExtra("Duration", Dur);
            intent.putExtra("PickUpTime", pickupTime);
            startActivity(intent);
        });

        back.setOnClickListener(view -> {
            Intent intent = new Intent(CarRental.this, HomeIntro.class);
            startActivity(intent);
        });
        NavigationBarView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.CarRent);

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

    private String getPickupDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void theDatePicker() {

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day,month, year);
                pickUpDate.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style  = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year){
        return getMonthString(month) + "-" + day + "-" + year;
    }

    private String getMonthString(int month){
        if(month == 1)
        {return "JAN";}
        if(month == 2)
        {return "FEB";}
        if(month == 3)
        {return "MAR";}
        if(month == 4)
        {return "APR";}
        if(month == 5)
        {return "MAY";}
        if(month == 6)
        {return "JUN";}
        if(month == 7)
        {return "JUL";}
        if(month == 8)
        {return "AUG";}
        if(month == 9)
        {return "SEP";}
        if(month == 10)
        {return "OCT";}
        if(month == 11)
        {return "NOV";}
        if(month == 12)
        {return "DEC";}

        return "JAN";
    }

    public void goHome (){
        Intent intent = new Intent(CarRental.this, HomeIntro.class);
        startActivity(intent);
    }
    public void goSave (){
        Intent intent = new Intent(CarRental.this, Save.class);
        startActivity(intent);
    }
    public void goBooking (){
        Intent intent = new Intent(CarRental.this, Booking.class);
        startActivity(intent);
    }
    public void goMessage (){
        Intent intent = new Intent(CarRental.this, Messages.class);
        startActivity(intent);
    }
    public void goMore (){
        Intent intent = new Intent(CarRental.this, More.class);
        startActivity(intent);

    }
}