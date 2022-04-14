package com.example.scholalrhope;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;

public class resume extends AppCompatActivity {
    EditText GPA;
    EditText wGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        GPA=findViewById(R.id.GPA_id);
        GPA.setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "5" )});

        wGPA=findViewById(R.id.weighted_Gpa_id);
        wGPA.setFilters( new InputFilter[]{ new MinMaxFilter( "1" , "5" )});


    }
}