package com.example.hoadu.tuan1;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.Button;
import com.rey.material.widget.EditText;
import com.rey.material.widget.Switch;

/**
 * Created by hoadu on 18/04/2017.
 */

public class LoginFragment extends android.support.v4.app.Fragment {
    private Switch aSwitch;
    private Button btnDangNhap;
    private android.widget.EditText edtTen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_login,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        aSwitch= (Switch) getActivity().findViewById(R.id.switchkey);
        aSwitch.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(Switch view, boolean checked) {
                      if(checked){
                          btnDangNhap.setVisibility(View.VISIBLE);
                          edtTen.setVisibility( View.VISIBLE);
                      }
                else{
                          btnDangNhap.setVisibility( View.INVISIBLE);
                          edtTen.setVisibility( View.INVISIBLE);
                      }
            }
        });



        btnDangNhap= (Button) getActivity().findViewById(R.id.btnDangNhap);
        edtTen= (android.widget.EditText) getActivity().findViewById(R.id.edtTen);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       Activity activity=getActivity();
                       MainActivity mainActivity= (MainActivity) activity;
                       mainActivity.getInputFragment().setData(edtTen.getText().toString());
                       mainActivity.showFragment(mainActivity.getInputFragment(),mainActivity.getLoginFragment());
                   }
               },800);


            }
        });
    }


}
