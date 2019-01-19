package com.shubham.dell.elpidamall;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class Vendor_Signup extends AppCompatActivity {


    //decaration vendor signup inputs

    FirebaseDatabase database;
    String codeSent;
    private FirebaseAuth firebaseAuthVendor;
    EditText vendor_name, firm_name, vendor_email, vendor_phone_no, vendor_address, vendor_turnover, business_start_date,verifyotp;
    Button signupasVendor,verifyvendor;
    RadioGroup type_of_vendor;
    RadioButton radioButton1WholeSeller, radioButton2Manufacturer, radioButton3Retailer, selectedRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor__signup);

        vendor_name = (EditText) findViewById(R.id.vendor_name);
        firm_name = (EditText) findViewById(R.id.firm_name);
        vendor_email = (EditText) findViewById(R.id.vendor_email);
        vendor_phone_no = (EditText) findViewById(R.id.vendor_phone_no);
        vendor_address = (EditText) findViewById(R.id.vendor_address);
        vendor_turnover = (EditText) findViewById(R.id.vendor_turnover);
        business_start_date = (EditText) findViewById(R.id.business_start_date);
        verifyotp=(EditText) findViewById(R.id.otp);
        verifyvendor=findViewById(R.id.code);
        signupasVendor = (Button) findViewById(R.id.signupasVendor);
        type_of_vendor = (RadioGroup) findViewById(R.id.type_of_vendor);
        radioButton1WholeSeller = (RadioButton) findViewById(R.id.radioButton1WholeSeller);
        radioButton2Manufacturer = (RadioButton) findViewById(R.id.radioButton2Manufacturer);
        radioButton3Retailer = (RadioButton) findViewById(R.id.radioButton3Retailer);

        firebaseAuthVendor=FirebaseAuth.getInstance();

    verifyvendor.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sendVerificationCode();

        }
    });
    signupasVendor.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkFields();
            verifySignUpCode();
            Vendor_Signup();
        }
    });
    }
    private void checkFields()
    {
        int selectedRBId = type_of_vendor.getCheckedRadioButtonId();

        if (vendor_name.getText().toString().equals(""))
            Toast.makeText(Vendor_Signup.this, "fill the vendor name", Toast.LENGTH_SHORT).show();

        else if (firm_name.getText().toString().equals(""))
            Toast.makeText(Vendor_Signup.this, "fill the firm name", Toast.LENGTH_SHORT).show();

        else if (vendor_email.getText().toString().equals(""))
            Toast.makeText(Vendor_Signup.this, "fill the email adress", Toast.LENGTH_SHORT).show();

        else if (vendor_phone_no.getText().toString().equals(""))
            Toast.makeText(Vendor_Signup.this, "fill the phone number", Toast.LENGTH_SHORT).show();

        else if (vendor_address.getText().toString().equals(""))
            Toast.makeText(Vendor_Signup.this, "fill the address", Toast.LENGTH_SHORT).show();

        else if (vendor_turnover.getText().toString().equals(""))
            Toast.makeText(Vendor_Signup.this, "fill the turnover", Toast.LENGTH_SHORT).show();

        else if (business_start_date.getText().toString().equals(""))
            Toast.makeText(Vendor_Signup.this, "fill Bussiness Start date", Toast.LENGTH_SHORT).show();
        else if (verifyotp.getText().toString().equals(""))
            Toast.makeText(Vendor_Signup.this, "Otp required", Toast.LENGTH_SHORT).show();

        else {
            if (selectedRBId != -1) {
                selectedRadioButton = (RadioButton) findViewById(selectedRBId);

            }
            else
                Toast.makeText(Vendor_Signup.this, "Nothing is selected,select your type", Toast.LENGTH_SHORT).show();
        }}
    private void Vendor_Signup(){
        // initialising database


        database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReferenceVendor = database.getReference("Vendors");

                // data going to store in database
                String vendor_name1 = vendor_name.getText().toString();
                String firm_name1 = firm_name.getText().toString();
                String vendor_email1 = vendor_email.getText().toString();
                String vendor_phone_no1 = vendor_phone_no.getText().toString();
                String vendor_address1 = vendor_address.getText().toString();
                String vendor_turnover1 = vendor_turnover.getText().toString();
                String business_start_date1 = business_start_date.getText().toString();
                String selectedRadioButton1 = selectedRadioButton.getText().toString();

                Vendors saveVendors = new Vendors(vendor_name1, firm_name1, vendor_email1, vendor_phone_no1, vendor_address1, vendor_turnover1,
                        business_start_date1, selectedRadioButton1);
                //write two line code for storing data
               databaseReferenceVendor.child("phone").setValue(saveVendors);

    }
    private void verifySignUpCode(){
        String code = verifyotp.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signUpWithPhoneAuthCredential(credential);

    }


    private void signUpWithPhoneAuthCredential(PhoneAuthCredential credential) {
        firebaseAuthVendor.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //here you can open new activity
                            Toast.makeText(getApplicationContext(),
                                    "Login Successfull", Toast.LENGTH_LONG).show();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(getApplicationContext(),
                                        "Incorrect Verification Code ", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }

    private void sendVerificationCode() {

        String phone = vendor_phone_no.getText().toString();

        if (phone.isEmpty()) {
            vendor_phone_no.setError("Phone number is required");
            vendor_phone_no.requestFocus();
            return;
        }

        if (phone.length() < 10) {
            vendor_phone_no.setError("Please enter a valid phone");
            vendor_phone_no.requestFocus();
            return;
        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks);

    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            codeSent = s;
        }
    };
}
