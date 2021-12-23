package com.example.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //gets the string values from the main activity using the intent from the main activity
        String s1 = getIntent().getStringExtra("com.example.assignment2.StudentID");
        String s2 = getIntent().getStringExtra("com.example.assignment2.Name");
        String s3 = getIntent().getStringExtra("com.example.assignment2.Address");
        String s4 = getIntent().getStringExtra("com.example.assignment2.ContactNumber");
        String s5 = getIntent().getStringExtra("com.example.assignment2.Email");
        String s6 = getIntent().getStringExtra("com.example.assignment2.DOB");
        String s7 = getIntent().getStringExtra("com.example.assignment2.Status");
        String s8 = getIntent().getStringExtra("com.example.assignment2.Fee");

        //Locates TextViews for each item entered in the main activity to be displayed in the 2nd activity
        TextView t1 = (TextView) findViewById(R.id.displaystudent_id);
        TextView t2 = (TextView) findViewById(R.id.displayname_id);
        TextView t3 = (TextView) findViewById(R.id.displayaddress_view);
        TextView t4 = (TextView) findViewById(R.id.displaycontact_view);
        TextView t5 = (TextView) findViewById(R.id.displayemail_view);
        TextView t6 = (TextView) findViewById(R.id.displaydob_view);
        TextView t7 = (TextView) findViewById(R.id.displayreg_view);
        TextView t8 = (TextView) findViewById(R.id.displayreg_fee);

        //Sets the TextView for student id to the value the user entered
        t1.setText("Student ID:\n"+s1);
        //Sets the TextView for student name to the value the user entered
        t2.setText("Name:\n"+s2);
        //Sets the TextView for address to the value the user entered
        t3.setText("Address:\n"+s3);
        //Sets the TextView for contact number to the value the user entered
        t4.setText("Contact Number:\n"+s4);
        //Sets the TextView for email to the value the user entered
        t5.setText("Email:\n"+s5);
        //Sets the TextView for DOB to the value the user entered
        t6.setText("Date of Birth:\n"+s6);
        //Sets the TextView for registration status to the value the user entered
        t7.setText("Registration Status:\n"+s7);
        //Sets the TextView for registration based on what the user chose as their registration status
        t8.setText("Registration Fee:\n"+s8);


    }
}
