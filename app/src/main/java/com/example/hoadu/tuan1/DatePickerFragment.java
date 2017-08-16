package com.example.hoadu.tuan1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by hoadu on 19/04/2017.
 */

public class DatePickerFragment extends android.support.v4.app.DialogFragment
        implements DatePickerDialog.OnDateSetListener {
    int year;
    int month;
    int day ;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int years, int months, int days) {
        year=years;
        month=months;
        day=days;
        Toast.makeText(getContext(),year+":"+(month+1)+":"+day,Toast.LENGTH_SHORT).show();
        // Do something with the date chosen by the user
    }
}