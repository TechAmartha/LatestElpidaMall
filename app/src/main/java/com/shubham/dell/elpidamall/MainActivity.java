package com.shubham.dell.elpidamall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button customer_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customer_signup = findViewById(R.id.signup);
        customer_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenSignupForCustomer();
            }
        });
    }

    public void OpenSignupForCustomer()
    {
        Intent inn = new Intent(this,Customer_Signup.class);
        startActivity(inn);
    }
}
