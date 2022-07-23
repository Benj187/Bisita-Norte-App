package com.app.bisitanorte;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

import java.util.Calendar;

public class Hotels extends AppCompatActivity {

    DatePickerDialog datePickerDialog, datePickerDialog1;
    RelativeLayout CheckIn, CheckOut, AddPerson;
    Button back, bookNow;
    TextView DateIn, DateOut, RoomNum, AdultNum, ChildNum;
    View view;
    String Room, Adult, Children, Checkin, Checkout, hotelName;
    ImageView hotel1;
    private static final String[] HOTEL = new String[]{
            "VIGAN PLAZA HOTEL","OVERMAR RESORT HOTE","RUSTIC CROWN HOTEL"
    };
    AutoCompleteTextView editText;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        CheckIn = findViewById(R.id.checkIn);
        CheckOut = findViewById(R.id.checkOut);
        bookNow = findViewById(R.id.createButton);
        back = findViewById(R.id.backButton);
        DateIn = findViewById(R.id.monthin);
        DateOut = findViewById(R.id.monthout);
        AddPerson = findViewById(R.id.person);
        RoomNum = findViewById(R.id.roomNo);
        AdultNum = findViewById(R.id.adultNo);
        ChildNum = findViewById(R.id.childNo);
        hotel1 = findViewById(R.id.img1);

        editText = findViewById(R.id.hotel_place);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, HOTEL);
        editText.setAdapter(adapter);


        sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        hotel1.setOnClickListener(view1 -> {
            Intent intent = new Intent(Hotels.this, HotelDetails.class);
            startActivity(intent);
        });

        CheckIn.setOnClickListener(view -> {
            theDatePicker();
            datePickerDialog.show();
            DateIn.setText(getDateIn());
        });

        CheckOut.setOnClickListener(view -> {
            theDateCheckout();
            datePickerDialog1.show();
            DateOut.setText(getDateOut());
        });

        AddPerson.setOnClickListener(View -> {

            view = getLayoutInflater().inflate(R.layout.number_picker, null, false);

            androidx.appcompat.app.AlertDialog.Builder dialog = new androidx.appcompat.app.AlertDialog.Builder(Hotels.this);
            dialog.setView(view);
            dialog.setTitle("Setup");
            dialog.setMessage("Input the number of room, adult and children");
            View finalView = view;
            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    EditText room = finalView.findViewById(R.id.roomNo);
                    EditText adult = finalView.findViewById(R.id.AdultNo);
                    EditText child = finalView.findViewById(R.id.ChildNo);
                    Room = room.getText().toString().trim();
                    Adult = adult.getText().toString().trim();
                    Children = child.getText().toString().trim();
                    RoomNum.setText(Room);
                    AdultNum.setText(Adult);
                    ChildNum.setText(Children);
                }
            });
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.setCancelable(true);
                }
            });
            dialog.create();
            dialog.show();

        });

        bookNow.setOnClickListener(view -> {
            Intent intent = new Intent(Hotels.this, Payment.class);
            Checkin = DateIn.getText().toString();
            Checkout = DateOut.getText().toString();
            hotelName = editText.getText().toString().trim();
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("CheckIn",Checkin);
            editor.putString("CheckOut",Checkout);
            editor.putString("HotelName",hotelName);
            editor.commit();
            startActivity(intent);
        });

        back.setOnClickListener(view -> {
            Intent intent = new Intent(Hotels.this, HomeIntro.class);
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


    private void theDateCheckout() {

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day,month, year);
                DateOut.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style  = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog1 = new DatePickerDialog(this, style, dateSetListener, year, month, day);

    }


    private String getDateIn() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private String getDateOut() {
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
                DateIn.setText(date);
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
        Intent intent = new Intent(Hotels.this, HomeIntro.class);
        startActivity(intent);
    }
    public void goSave (){
        Intent intent = new Intent(Hotels.this, Save.class);
        startActivity(intent);
    }
    public void goBooking (){
        Intent intent = new Intent(Hotels.this, Booking.class);
        startActivity(intent);
    }
    public void goMessage (){
        Intent intent = new Intent(Hotels.this, Messages.class);
        startActivity(intent);
    }
    public void goMore (){
        Intent intent = new Intent(Hotels.this, More.class);
        startActivity(intent);
    }
}