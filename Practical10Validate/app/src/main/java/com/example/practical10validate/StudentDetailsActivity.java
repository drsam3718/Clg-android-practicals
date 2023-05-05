package com.example.practical10validate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StudentDetailsActivity extends AppCompatActivity {
    TextView name, enl, sem, branch, mobile, mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        name = (TextView)findViewById(R.id.name1);
        enl = (TextView)findViewById(R.id.enl1);
        sem = (TextView)findViewById(R.id.sem1);
        branch = (TextView)findViewById(R.id.branch1);
        mobile = (TextView)findViewById(R.id.mobile1);
        mail = (TextView)findViewById(R.id.mail1);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra(MainActivity.NAME));
        enl.setText(intent.getStringExtra(MainActivity.ENL));
        sem.setText(String.valueOf(intent.getIntExtra(MainActivity.SEM, 4)));
        branch.setText(intent.getStringExtra(MainActivity.BRANCH));
        mobile.setText(intent.getStringExtra(MainActivity.MNO));
        mail.setText(intent.getStringExtra(MainActivity.EMAIL));
    }
}