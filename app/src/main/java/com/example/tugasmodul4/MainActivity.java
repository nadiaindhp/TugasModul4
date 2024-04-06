package com.example.tugasmodul4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText tanggal, waktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanggal = (EditText) findViewById(R.id.tanggal);
        waktu = (EditText) findViewById(R.id.waktu);
    }

    public void setTanggal(View v) {
        final Calendar c = Calendar.getInstance();
        int tgl = c.get(Calendar.DAY_OF_MONTH);
        int bln = c.get(Calendar.MONTH);
        int thn= c.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new
                DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker view, int tgl, int bln, int thn) {
                        tanggal.setText(tgl + "-" + (bln + 1) + "-" + thn);
                    }
                }, tgl,bln,thn);
        datePickerDialog.show();
    }

    public void setWaktu(View v) {
        final Calendar c = Calendar.getInstance();
        int jam = c.get(Calendar.HOUR_OF_DAY);
        int menit = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        waktu.setText(jam + ":" + menit);
                    }
                }, jam, menit, false);
        timePickerDialog.show();
    }
}