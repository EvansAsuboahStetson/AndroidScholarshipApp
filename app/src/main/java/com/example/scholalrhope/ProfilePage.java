package com.example.scholalrhope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class ProfilePage extends AppCompatActivity {
    TextView myPersonal_Info;
    TextView myResume;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        myPersonal_Info = findViewById(R.id.mypersonal_info);
        myResume = findViewById(R.id.myResume);
        myResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),resume.class);
                startActivity(intent);
            }
        });

        myPersonal_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),personal_info.class);
                startActivity(intent);
            }
        });

    }
}