package com.example.scholalrhope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button btnlogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameLogin);
        password= findViewById(R.id.passwordLogin);

        btnlogin = findViewById(R.id.btnsigninLogin);
        DB= new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")|| pass.equals(""))
                {
                    Toast.makeText(LoginActivity.this,"Please Fill or the Fields",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Boolean checkuserpass = DB.checkusernamepass(user,pass);
                    if (checkuserpass==true)
                    {
                        Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        intent.putExtra("username",user);
                        startActivity(intent);
                        overridePendingTransition(R.anim.right_in, R.anim.left_out);

                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }
}