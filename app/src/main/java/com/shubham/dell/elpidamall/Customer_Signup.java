package com.shubham.dell.elpidamall;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Customer_Signup extends AppCompatActivity {
private Button cus;
private EditText cusname,cusaddress,cusemail,cusphone,cusdob;
private FirebaseAuth mAuth;
private DatabaseReference mDatareference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__signup);
        cus=findViewById(R.id.signupasCus);
        cusname=findViewById(R.id.firstnameCus);
        cusaddress=findViewById(R.id.addressCus);
        cusemail=findViewById(R.id.EmailCus);
        cusdob=findViewById(R.id.dobCus);
        cusphone=findViewById(R.id.phone_numberCus);
        mAuth=FirebaseAuth.getInstance();
        mDatareference=FirebaseDatabase.getInstance().getReference();
        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpCus();
            }
        });
    }
    public void signUpCus()
    {   String customer_email=cusemail.getText().toString();
        String customer_phone=cusphone.getText().toString();
        mAuth.createUserWithEmailAndPassword(customer_email,customer_phone)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Customer_Signup.this,"Successful",Toast.LENGTH_SHORT).show();
                            saveCustomer();
                        }
                        else
                        {
                            Toast.makeText(Customer_Signup.this,"Unsuccessful",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void saveCustomer()
    {
        String customer_email=cusemail.getText().toString();
        String customer_phone=cusphone.getText().toString();
        String customer_addr=cusaddress.getText().toString();
        String customer_dob=cusdob.getText().toString();
        String customer_name=cusname.getText().toString();
        saveCus saveData=new saveCus(customer_email,customer_addr,customer_name,customer_phone,customer_dob);
        mDatareference.child("Customer").setValue(saveData);
    }
}
