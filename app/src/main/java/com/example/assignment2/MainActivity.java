package com.example.assignment2;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.app.DatePickerDialog.OnDateSetListener;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements OnDateSetListener {
    //
    private TextView dateText;
    //holds registration status
    private TextView reg;
    //holds date of birth
    private String dob;
    //holds the strings for the different types of registration
    private String reg_type [];
    //for the confirm button
    private Button confirm;
    //holds the registration fee
    private String reg_fee;
    //Dialog box to select registration status
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //used to setup text views, buttons etc to avoid onCreate() clutter
         setViews();


    }
    void setViews(){

        //dob TextBox cast to TextView
        dateText = (TextView) findViewById(R.id.edit_dob);
        reg = (TextView) findViewById(R.id.edit_reg);
        //Opens date picker when select date field clicked
        findViewById(R.id.edit_dob).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        //gets the 3 registration status from strings.xml
        reg_type = getResources().getStringArray(R.array.reg_type_array);
        //Creates Alert Dialog object
        builder = new AlertDialog.Builder(this);
        //brings up dialog box with choices for registration status
         Registration();

         confirm = (Button) findViewById(R.id.btnConfirm);
         //takes user to second activity
         ConfirmRegistration();

    }

   //shows the date picker
    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


    //sets the date in the text box based on what the user chose for the date picker
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
         dob = dayOfMonth+"/"+String.valueOf(month+1)+"/"+year;
         dateText.setText(dob);
    }
  //Opens dialog box show the list of registration status to choose from then sets the text to the selected status
    void Registration(){

       // reg_type = getResources().getStringArray(R.array.reg_type_array);



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Registration Status");
                builder.setSingleChoiceItems(reg_type, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        reg.setText(reg_type[i]);
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog mDialog = builder.create();
                mDialog.show();
            }
        });
    }
  //passes what the user entered to the second activity when the confirm button is clicked
    void ConfirmRegistration(){

          confirm.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  EditText sid = (EditText) findViewById(R.id.editStudentID);
                  String student_id = sid.getText().toString();

                  EditText name = (EditText) findViewById(R.id.name);
                  String nme = name.getText().toString();

                  EditText address = (EditText) findViewById(R.id.edit_address);
                  String address1 = address.getText().toString();

                  EditText contact = (EditText) findViewById(R.id.edit_contact);
                  String c_num = contact.getText().toString();

                  EditText email = (EditText) findViewById(R.id.edit_email);
                  String e_mail = email.getText().toString();

                  EditText res = (EditText) findViewById(R.id.edit_reg);
                  String resg = res.getText().toString();


                  Intent startIntent = new Intent(getApplicationContext(), DisplayActivity.class);

                  //sets the fee depending on the value registration status
                  if(resg=="Full Time"){
                      reg_fee="$200.00";
                  }
                  else if(resg=="Part Time"){
                      reg_fee="$150.00";
                  }else{
                      reg_fee="$300.00";
                  }

                  // pass information to secondActivity
                  startIntent.putExtra("com.example.assignment2.StudentID", student_id);
                  startIntent.putExtra("com.example.assignment2.Name", nme);
                  startIntent.putExtra("com.example.assignment2.Address", address1);
                  startIntent.putExtra("com.example.assignment2.ContactNumber", c_num);
                  startIntent.putExtra("com.example.assignment2.Email", e_mail);
                  startIntent.putExtra("com.example.assignment2.DOB", dob);
                  startIntent.putExtra("com.example.assignment2.Status", resg);
                  startIntent.putExtra("com.example.assignment2.Fee", reg_fee);

                  startActivity(startIntent);
              }
          });
    }
}






