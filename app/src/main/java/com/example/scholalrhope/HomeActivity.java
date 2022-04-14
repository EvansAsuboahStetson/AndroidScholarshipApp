package com.example.scholalrhope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.io.Console;

public class HomeActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    Button MyScholarshipBut;
    Button PlannerBut;
    Button ChooseSchBut;
    Button BackBut;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationView = findViewById(R.id.navigation_menu_id);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();



        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Animation buttonsAni= AnimationUtils.loadAnimation(this,R.anim.top_down);

        MyScholarshipBut = findViewById(R.id.MyScholarships);
        ChooseSchBut= findViewById(R.id.ChooseScholarships);
        PlannerBut=findViewById(R.id.Planner);
        BackBut= findViewById(R.id.btnLog);

        MyScholarshipBut.startAnimation(buttonsAni);
        ChooseSchBut.startAnimation(buttonsAni);
        PlannerBut.startAnimation(buttonsAni);
        BackBut.startAnimation(buttonsAni);


        MyScholarshipBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animShake = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.shake_but);
                view.startAnimation(animShake);
            }
        });
        ChooseSchBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animShake = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.shake_but);
                view.startAnimation(animShake);
            }
        });
        PlannerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animShake = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.shake_but);
                view.startAnimation(animShake);
            }
        });
        BackBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animShake = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.shake_but);
                view.startAnimation(animShake);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_account:
                        Log.i("Menu Drawer Clicked","Account");

                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(getApplicationContext(),ProfilePage.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.right_in, R.anim.left_out);
                        break;
                    case R.id.nav_settings:
                        Log.i("Menu Drawer Clicked","Settings");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_logout:
                        Log.i("Menu Drawer Clicked","Logout");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }

        });






    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}