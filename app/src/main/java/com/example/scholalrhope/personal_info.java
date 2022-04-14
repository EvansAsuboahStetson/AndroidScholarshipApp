package com.example.scholalrhope;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class personal_info extends AppCompatActivity {
Spinner spinner;
ImageView cancel_button;
CircleImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        spinner = findViewById(R.id.level_id_spinner);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        profile = findViewById(R.id.profile_img);

        cancel_button =findViewById(R.id.arrow_left);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();

            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowCustomDialog();

            }
        });
    }
    void ShowCustomDialog()
    {
        final Dialog dialog = new Dialog(personal_info.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);

        dialog.setContentView(R.layout.activity_customise_popup);

        dialog.show();
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        Window window = dialog.getWindow();
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    }
}