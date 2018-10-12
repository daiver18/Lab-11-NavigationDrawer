package com.example.daiverandresdoria.menufy.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.daiverandresdoria.menufy.Fragments.AlertsFragment;
import com.example.daiverandresdoria.menufy.Fragments.EmailFragment;
import com.example.daiverandresdoria.menufy.Fragments.InfoFragment;
import com.example.daiverandresdoria.menufy.R;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Switch swirchON_OFF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        setDrawerLayout();
        setNavigationView();
        setDefaultfragment();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean fragmentTransicion = false;
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.email:
                        fragment = new EmailFragment();
                        fragmentTransicion = true;
                        break;
                    case R.id.alert:
                        fragment = new AlertsFragment();
                        fragmentTransicion = true;
                        break;
                    case R.id.info:
                        fragment = new InfoFragment();
                        fragmentTransicion = true;
                        break;
                }
                if (fragmentTransicion){
                    changeFragment(fragment,item);
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });

        swirchON_OFF.setOnCheckedChangeListener(this);
    }

    private void setToolbar(){
        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home");
    }

    private void setDrawerLayout(){
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    private void setNavigationView(){
        navigationView = findViewById(R.id.navView);
        swirchON_OFF = (Switch) navigationView.getMenu().findItem(R.id.switch_option).getActionView();
    }

    private void setDefaultfragment(){
        MenuItem item = navigationView.getMenu().getItem(0);
        Fragment fragment = new EmailFragment();
        changeFragment(fragment,item);
    }

    private void changeFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        getSupportActionBar().setTitle(item.getTitle());
        item.setChecked(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            Toast.makeText(MainActivity.this,"Is On",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this,"Is Off",Toast.LENGTH_SHORT).show();
        }
    }
}
