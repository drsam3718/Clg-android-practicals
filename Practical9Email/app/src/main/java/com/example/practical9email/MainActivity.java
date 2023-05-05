package com.example.practical9email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextInputLayout sendto, subject, body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting instance of edittext and button
        sendto = (TextInputLayout)findViewById(R.id.editText1);
        subject = (TextInputLayout)findViewById(R.id.editText2);
        body = (TextInputLayout)findViewById(R.id.editText3);
        button = (Button) findViewById(R.id.button);

        // attach setOnClickListener to button with Intent object define in it
        button.setOnClickListener(view -> {
            String emailsend = sendto.getEditText().getText().toString();
            String emailsubject = subject.getEditText().getText().toString();
            String emailbody = body.getEditText().getText().toString();

            // define Intent object with action attribute as ACTION_SEND
            Intent intent = new Intent(Intent.ACTION_SEND);

            // add three fields to intent using putExtra function
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailsend});
            intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
            intent.putExtra(Intent.EXTRA_TEXT, emailbody);

            // set type of intent
            intent.setType("message/rfc822");

            // startActivity with intent with chooser as Email client using createChooser function
            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        });
    }
}
