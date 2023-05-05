package com.example.practical10validate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    public static final String NAME = "com.example.practical10validate.NAME";
    public static final String ENL = "com.example.practical10validate.ENL";
    public static final String SEM = "com.example.practical10validate.SEM";
    public static final String BRANCH = "com.example.practical10validate.BRANCH";
    public static final String MNO = "com.example.practical10validate.MNO";
    public static final String EMAIL = "com.example.practical10validate.EMAIL";

    TextInputLayout name, enl;
    MaterialButton check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextInputLayout)findViewById(R.id.name);
        enl = (TextInputLayout)findViewById(R.id.enrollment);
        check = (MaterialButton)findViewById(R.id.check);

        StudentDetails[] studentDetails;

        studentDetails = new StudentDetails[4];

        studentDetails[0] = new StudentDetails("Trusha", "200430116124", 6, "IT", "1431431432", "trushanandola@gmail.com");
        studentDetails[1] = new StudentDetails("Darsh", "200430116125", 6, "IT", "5252525252", "darshdobariya@gmail.com");
        studentDetails[2] = new StudentDetails("Dip", "200430116126", 6, "IT", "1234567890", "dipsambhavani@gmail.com");
        studentDetails[3] = new StudentDetails("Parth", "200430116127", 6, "IT", "6969696969", "parthbaraiya@gmail.com");

        Intent intent = new Intent(this, StudentDetailsActivity.class);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getEditText().getText().toString().isEmpty() || enl.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "please fill all the fields !!!", Toast.LENGTH_LONG).show();
                }else{
                    for (int i = 0; i < 4; i++){
                        if (name.getEditText().getText().toString().equals(studentDetails[i].getName())){
                            if (enl.getEditText().getText().toString().equals(studentDetails[i].getEnrolment())){
                                intent.putExtra(NAME, studentDetails[i].getName());
                                intent.putExtra(ENL, studentDetails[i].getEnrolment());
                                intent.putExtra(SEM, studentDetails[i].getSem());
                                intent.putExtra(BRANCH, studentDetails[i].getBranch());
                                intent.putExtra(MNO, studentDetails[i].getMobile());
                                intent.putExtra(EMAIL, studentDetails[i].getEmail());
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(), "invalid data !!!", Toast.LENGTH_LONG).show();
                                break;
                            }
                        }
                    }
                }
            }
        });


    }
}