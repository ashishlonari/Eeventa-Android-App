package com.example.eventa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.eventa.Fragment.AccountFragment;
import com.example.eventa.Fragment.EventFragment;
import com.example.eventa.Fragment.NewsFragment;
import com.example.eventa.Fragment.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    
    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView =findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        //To Start Event Fragment by Default at start of app
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new EventFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()){

                        case R.id.nav_event:
                            selectedFragment=new EventFragment();

                            break;

                        case R.id.nav_news:
                            selectedFragment=new NewsFragment();

                            break;

                        case R.id.nav_notification:
                            selectedFragment=new NotificationFragment();
                            break;

                        case R.id.nav_account:
                            selectedFragment=new AccountFragment();
                            break;

                    }

                    if(selectedFragment !=null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

                    }



                    return  true;
                }
            };

}