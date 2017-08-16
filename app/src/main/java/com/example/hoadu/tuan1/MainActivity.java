package com.example.hoadu.tuan1;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private LoginFragment loginFragment=new LoginFragment();
    private InputFragment inputFragment=new InputFragment();
    private SongFragment songFragment=new SongFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.layoutPanel,loginFragment);
        fragmentTransaction.add(R.id.layoutPanel,inputFragment);
        fragmentTransaction.add(R.id.layoutPanel,songFragment);
        fragmentTransaction.show(loginFragment);
        fragmentTransaction.hide(inputFragment);
        fragmentTransaction.hide(songFragment);
        fragmentTransaction.commit();
    }

    public void showFragment(android.support.v4.app.Fragment fragmentShow, android.support.v4.app.Fragment fragmentHide){
        android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(fragmentShow);
        fragmentTransaction.hide(fragmentHide);
        fragmentTransaction.commit();
    }

    public LoginFragment getLoginFragment(){
        return loginFragment;
    }
    public InputFragment getInputFragment(){
        return inputFragment;
    }
    public SongFragment getSongFragment(){
        return  songFragment;
    }
    public void onRadioButtonClicked(View v) {
        inputFragment.monRadioButtonClicked(v);
    }
    public void onCheckboxClicked(View v) {
        inputFragment.onCheckboxClicked(v);
    }
}
