package com.example.practical11sqlite;

import static java.util.Arrays.asList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.practical11sqlite.data.DbHandler;
import com.example.practical11sqlite.model.StudentDetails;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextInputLayout name, enrolment, mobile, mail, sem, branch;
    AutoCompleteTextView autosem, autobranch;

    MaterialButton insert, reset;

    DbHandler db = new DbHandler(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextInputLayout)findViewById(R.id.Name);
        enrolment = (TextInputLayout)findViewById(R.id.enl);
        mobile = (TextInputLayout)findViewById(R.id.mobile);
        mail = (TextInputLayout)findViewById(R.id.email);

        sem = (TextInputLayout)findViewById(R.id.sem);
        autosem = (AutoCompleteTextView)findViewById(R.id.autosem);

        branch = (TextInputLayout)findViewById(R.id.branch);
        autobranch = (AutoCompleteTextView)findViewById(R.id.autoBranch);

        insert = (MaterialButton) findViewById(R.id.insert); 
        reset = (MaterialButton) findViewById(R.id.reset); 

        ArrayList<String> sems = new ArrayList<>(asList("1", "2", "3", "4", "5", "6", "7", "8"));
        ArrayAdapter<String> adapter1= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sems);
        autosem.setAdapter(adapter1);

        ArrayList<String> branches = new ArrayList<>(asList("IT", "Civil", "Electrical", "Mechanical"));
        ArrayAdapter<String> adapter2= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, branches);
        autobranch.setAdapter(adapter2);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getEditText().getText().toString().isEmpty() || enrolment.getEditText().getText().toString().isEmpty() || sem.getEditText().getText().toString().isEmpty() || branch.getEditText().getText().toString().isEmpty() || mail.getEditText().getText().toString().isEmpty() || mobile.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "please fill all the fields !!!", Toast.LENGTH_LONG).show();
                }else{
                    StudentDetails studentDetails = new StudentDetails(name.getEditText().getText().toString(), enrolment.getEditText().getText().toString(), Integer.parseInt(sem.getEditText().getText().toString()), branch.getEditText().getText().toString(), mail.getEditText().getText().toString()+mail.getSuffixText(), mobile.getEditText().getText().toString());
                    db.addStudentDetails(studentDetails);
                    Toast.makeText(getApplicationContext(), "**Data inserted successfully**", Toast.LENGTH_LONG).show();
//                    String message = Objects.requireNonNull(name.getEditText()).getText().toString()+"\n"+ enrolment.getEditText().getText().toString()+"\n"+ Integer.parseInt(sem.getEditText().getText().toString())+"\n"+ branch.getEditText().getText().toString()+"\n"+ mail.getEditText().getText().toString()+"\n"+ mobile.getEditText().getText().toString();
//
//                    StudentDetailsDialog studentDetailsDialog = new StudentDetailsDialog(message);
//                    studentDetailsDialog.show(getSupportFragmentManager(), "student details dialog");
                    name.getEditText().setText("");
                    enrolment.getEditText().setText("");
                    sem.getEditText().setText("");
                    branch.getEditText().setText("");
                    mail.getEditText().setText("");
                    mobile.getEditText().setText("");
                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.getEditText().setText("");
                enrolment.getEditText().setText("");
                sem.getEditText().setText("");
                branch.getEditText().setText("");
                mail.getEditText().setText("");
                mobile.getEditText().setText("");
            }
        });
    }
}