package com.example.libraryoverdue;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText bookname, author, amount;
    TextView issue_date_tv, return_date_tv, submit_date_tv, result;
    Button issuedate, returndate, submitdate, calculate;
    Date date1, date2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookname = findViewById(R.id.book_title);
        author = findViewById(R.id.author_name);
        issuedate = findViewById(R.id.issue_date);
        returndate = findViewById(R.id.return_date);
        submitdate = findViewById(R.id.submittion_date);
        amount = findViewById(R.id.amount);

        calculate = findViewById(R.id.calculate);

        issue_date_tv = findViewById(R.id.issue_date_tv);
        return_date_tv = findViewById(R.id.return_date_tv);
        submit_date_tv = findViewById(R.id.submittion_date_tv);
        result = findViewById(R.id.result);

        datePicker(issue_date_tv, issuedate);
        datePicker(return_date_tv, returndate);
        datePicker(submit_date_tv, submitdate);

        calculate.setOnClickListener(v-> calculate_fine());
    }
    public void datePicker(TextView tv, Button btn){
        btn.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            @SuppressLint("SetTextI18n") DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    (view, year1, monthOfYear, dayOfMonth) -> tv.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1),
                    year, month, day);
            datePickerDialog.show();
        });
    }
    @SuppressLint("SetTextI18n")
    void calculate_fine() {

        if (author.length() == 0 || bookname.length() == 0  || issue_date_tv.getText().toString().equals("Issue Date")  || return_date_tv.getText().toString().equals("Return Date")  || submit_date_tv.getText().toString().equals("Submission Date")  || amount.getText().length() == 0 ){
            Toast.makeText( this, "Please Enter Valid Input", Toast.LENGTH_SHORT ).show();
        }else {
            try {
                @SuppressLint("SimpleDateFormat") SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");
                date1 = dates.parse(return_date_tv.getText().toString());
                date2 = dates.parse(submit_date_tv.getText().toString());
                long difference = date1.getTime() - date2.getTime();
                long differenceDates = difference / (24 * 60 * 60 * 1000);
                int penalty = Integer.parseInt( amount.getText().toString() );
                if (differenceDates > 0){
                    result.setText( "You have to pay " + differenceDates * penalty + " ₹" );
                    result.setTextColor( Color.parseColor( "#FF0000" ) );
                }else {
                    result.setText( "You are all set" );
                    result.setTextColor( Color.parseColor( "#006400" ) );
                }
            } catch (Exception exception) {
                System.out.println("===============" + exception);
            }
        }
    }
}