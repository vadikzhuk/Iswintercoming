package com.example.android.iswintercoming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Creating private inner receiver
    private BroadcastReceiver mDateChangeReceiver = new BroadcastReceiver(){
        @Override    public void onReceive(Context context, Intent intent) {
            Log.v("Inner receiver event", "Catched");
            nedSays();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        nedSays();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        registerReceiver(mDateChangeReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mDateChangeReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //this method checks if winter is coming and returns true if it is and false if not. It uses month numbers as argument where 1 is for January and 12 is for December
    public Boolean isComingCheck(int monthNumber) {
        Boolean isComing = true;

        if (monthNumber == 12 || monthNumber == 1 || monthNumber == 2) {
            isComing = false;
        } else {
            isComing = true;
        }

        return isComing;
    }

    //this method displays if winter is coming or has already come. Accepts boolean as argument
    public void displayComing(Boolean dComing) {
        TextView coming = (TextView) findViewById(R.id.coming);

        if (!dComing) {
            coming.setText("Winter\nhas\ncome");
        } else {
            coming.setText("Winter\nis\ncoming");
        }
    }

    //this method displays what month actually is now. It uses month numbers as argument where 1 is for January and 12 is for December
    public void displayMonth(int monthNumber) {
        String monthString;
        TextView monthView = (TextView) findViewById(R.id.month);

        switch (monthNumber) {
            case 1:  monthString = "January";
                break;
            case 2:  monthString = "February";
                break;
            case 3:  monthString = "March";
                break;
            case 4:  monthString = "April";
                break;
            case 5:  monthString = "May";
                break;
            case 6:  monthString = "June";
                break;
            case 7:  monthString = "July";
                break;
            case 8:  monthString = "August";
                break;
            case 9:  monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: monthString = "Invalid month";
                break;
        }

        monthView.setText("It's " + monthString + ", bastard.");
    }

    //this method gets actual month and displays month and if winter is coming
    public void nedSays() {
        Calendar c = Calendar.getInstance(); //creating new calendar
        int month = c.get(Calendar.MONTH) + 1; //getting actual month

        displayComing(isComingCheck(month)); //displaying if winter is coming

        displayMonth(month); //displaying what month it actually is
    }
}
