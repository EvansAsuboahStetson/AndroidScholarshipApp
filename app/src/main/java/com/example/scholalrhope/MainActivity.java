package com.example.scholalrhope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password,repassword;
    Button signup, signin;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        username = findViewById(R.id.username);
        password= findViewById(R.id.password);
        repassword=findViewById(R.id.repassword);

        signup= findViewById(R.id.btnsignup);
        signin= findViewById(R.id.btnsignin);
        DB = new DBHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass= password.getText().toString();

                String repass = repassword.getText().toString();

                if (user.equals("")|| pass.equals("")|| repass.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if (pass.equals(repass))
                    {
                        Boolean checkuser= DB.checkuserexist(user);
                        if (checkuser==false)
                        {
                            Boolean insert = DB.insertData(user,pass);
                            if (insert==true)
                            {
                                Toast.makeText(MainActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                 Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                 startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this,"Unsuccessful Registration! Try Again",Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(MainActivity.this,"UserAlready Already Exist. Please Sign In",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Passwords Do Not Match",Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}