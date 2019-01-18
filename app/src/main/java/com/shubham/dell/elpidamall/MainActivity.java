package com.shubham.dell.elpidamall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   private Button customer_signup;
   private Button vendor_sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vendor_sign=findViewById(R.id.vendor_signup);
        customer_signup = findViewById(R.id.cus_signup);
        customer_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenSignupForCustomer();
            }
        });
        vendor_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSignupForVendor();
            }
        });
    }

    public void OpenSignupForCustomer()
    {
        Intent inn = new Intent(this,Customer_Signup.class);
        startActivity(inn);
    }
    public void OpenSignupForVendor()
    {
        Intent inn=new Intent(this,Vendor_Signup.class);
        startActivity(inn);
    }
}
