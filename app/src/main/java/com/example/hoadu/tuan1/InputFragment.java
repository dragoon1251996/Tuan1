package com.example.hoadu.tuan1;

import android.app.Activity;
import android.app.Fragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.hoadu.adapter.CustomArrayAdapter;
import com.rey.material.app.DialogFragment;
import com.rey.material.widget.Button;
import com.rey.material.widget.CheckBox;
import com.rey.material.widget.Spinner;

import java.util.ArrayList;

import static android.content.Context.NOTIFICATION_SERVICE;


/**
 * Created by hoadu on 18/04/2017.
 */

public class InputFragment extends android.support.v4.app.Fragment implements View.OnClickListener{
    private NotificationCompat.Builder notification;
    public static final int MID=123;
    private ArrayList<String> arrayList=new ArrayList();
    private Button btnOK,btnRe;
    private Spinner spinner;
    private CheckBox cb1,cb2,cb3,cb4,cb5,cb6;
    private RadioButton radioGio,radioNgay;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_input,container,false);
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        notification=new NotificationCompat.Builder(getActivity());
        notification.setAutoCancel(true);
        spinner= (Spinner) getActivity().findViewById(R.id.array_spinner);


       btnRe= (Button) getActivity().findViewById(R.id.btnRecyclerView);
        btnRe.setOnClickListener(this);
        btnOK= (Button) getActivity().findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);
        cb1= (CheckBox) getActivity().findViewById(R.id.checkbox_1);
        cb2= (CheckBox) getActivity().findViewById(R.id.checkbox_2);
        cb3= (CheckBox) getActivity().findViewById(R.id.checkbox_3);
        cb4= (CheckBox) getActivity().findViewById(R.id.checkbox_4);
        cb5= (CheckBox) getActivity().findViewById(R.id.checkbox_5);
        cb6= (CheckBox) getActivity().findViewById(R.id.checkbox_6);
        radioGio= (RadioButton) getActivity().findViewById(R.id.radio_gio);
        radioNgay= (RadioButton) getActivity().findViewById(R.id.radio_ngay);

    }
    public void monRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_gio:
                if (checked ){
                    android.support.v4.app.DialogFragment newFragment = new TimePickerFragment();
                    newFragment.show(getFragmentManager(), "timePicker");
                }
                // Pirates are the best
                break;
            case R.id.radio_ngay:
                if (checked){
                    android.support.v4.app.DialogFragment newFragment = new DatePickerFragment();
                    newFragment.show(getFragmentManager(), "timePicker");
                }
                // Ninjas rule
                break;
        }
    }



    public void setData(String name){
        new AlertDialog.Builder(getActivity())
                .setTitle("   Wellcome   "+name)
                .setMessage(" Are you ready ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        Toast.makeText(getActivity(), "Chào mừng", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finishAffinity();
                    }
                })
                .setIcon(R.drawable.welcome)
                .show();
    }
    public void onCheckboxClicked(View view){
        boolean checked= ((com.rey.material.widget.CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_1:
                if (checked) arrayList.add(cb1.getText().toString());
                else arrayList.remove(cb1.getText().toString());
                break;
            case R.id.checkbox_2:
                if (checked) arrayList.add(cb2.getText().toString());
                else arrayList.remove(cb2.getText().toString());
                break;
            case R.id.checkbox_3:
                if (checked) arrayList.add(cb3.getText().toString());
                else arrayList.remove(cb3.getText().toString());
                    break;
            case R.id.checkbox_4:
                if (checked) arrayList.add(cb4.getText().toString());
                else arrayList.remove(cb4.getText().toString());
                    break;
            case R.id.checkbox_5:
                if (checked) arrayList.add(cb5.getText().toString());
                else arrayList.remove(cb5.getText().toString());
                    break;
            case R.id.checkbox_6:
                if (checked) arrayList.add(cb6.getText().toString());
                else arrayList.remove(cb6.getText().toString());
                    break;
            // TODO: Veggie sandwich
        }



    }

private CustomArrayAdapter myAdapter;
    @Override
    public void onClick(View view) {
//        Context ctx = getActivity();
//        Resources res = ctx.getResources();
        switch (view.getId()){
            case R.id.btnOK:
                myAdapter = new CustomArrayAdapter(getActivity(), R.layout.spinner_item, arrayList);
                myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(myAdapter);



                notification.setSmallIcon(R.mipmap.ic_launcher);
                notification.setTicker("Có thông báo");
                notification.setWhen(System.currentTimeMillis());
                notification.setContentTitle("Thông báo");
                notification.setContentText("Hết");
                Intent intent=new Intent(getActivity(),InputFragment.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                notification.setContentIntent(pendingIntent);

                NotificationManager manager= (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);
                manager.notify(MID,notification.build());
                break;
            case R.id.btnRecyclerView:
                Activity activity=getActivity();
                MainActivity mainActivity= (MainActivity) activity;
                mainActivity.showFragment(mainActivity.getSongFragment(),mainActivity.getInputFragment());
                break;
        }




//
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
//                R.array.planets_array, android.R.layout.simple_spinner_item);
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
////        spinner.setOnItemSelectedListener((com.rey.material.widget.Spinner.OnItemSelectedListener) this);
////        spinner.setOnItemSelectedListener(this);
    }


//
//    @Override
//    public void onItemSelected(Spinner parent, View view, int position, long id) {
//        myAdapter.notifyDataSetChanged();
//        parent.getSelectedItem().toString();
//
//    }


}
