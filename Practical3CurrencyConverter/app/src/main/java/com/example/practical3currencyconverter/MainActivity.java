package com.example.practical3currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText fromTV;
    TextView toTV;
    Spinner spinnerFrom, spinnerTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] spinner_items = new String[] {"INR(₹)", "USD($)", "EUR(€)", "RUB(₽)", "AED(د.إ)"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinner_items);

        fromTV = (EditText) findViewById(R.id.from_TV);
        toTV = (TextView) findViewById(R.id.to_TV);

        spinnerFrom = (Spinner) findViewById(R.id.from_spinner);
        spinnerFrom.setAdapter(adapter);

        spinnerTo = (Spinner) findViewById(R.id.to_spinner);
        spinnerTo.setAdapter(adapter);

        spinnerTo.setOnItemSelectedListener(this);
        spinnerFrom.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(spinnerTo.getSelectedItem().toString().equals("INR(₹)"))
        {
            if(spinnerFrom.getSelectedItem().toString().equals("INR(₹)"))
            {
                toTV.setText(fromTV.getText());
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("USD($)"))
            {
                double rupees=Double.parseDouble(fromTV.getText().toString())* 82.85;
                toTV.setText(rupees + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("EUR(€)"))
            {
                double rupees=Double.parseDouble(fromTV.getText().toString())* 87.44;
                toTV.setText(rupees + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("RUB(₽)"))
            {
                double rupees=Double.parseDouble(fromTV.getText().toString())* 1.10;
                toTV.setText(rupees + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("AED(د.إ)"))
            {
                double rupees=Double.parseDouble(fromTV.getText().toString())* 22.46;
                toTV.setText(rupees + "");
            }
        }
        else if(spinnerTo.getSelectedItem().toString().equals("USD($)"))
        {
            if(spinnerFrom.getSelectedItem().toString().equals("INR(₹)"))
            {
                double dollars = Double.parseDouble(fromTV.getText().toString())* 0.012;
                toTV.setText(dollars + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("USD($)"))
            {
                toTV.setText(fromTV.getText());
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("EUR(€)"))
            {
                double dollars = Double.parseDouble(fromTV.getText().toString())* 1.06;
                toTV.setText(dollars + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("RUB(₽)"))
            {
                double dollars = Double.parseDouble(fromTV.getText().toString())* 0.013;
                toTV.setText(dollars + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("AED(د.إ)"))
            {
                double rupees=Double.parseDouble(fromTV.getText().toString())* 0.27;
                toTV.setText(rupees + "");
            }
        }
        else if(spinnerTo.getSelectedItem().toString().equals("EUR(€)"))
        {
            if(spinnerFrom.getSelectedItem().toString().equals("INR(₹)"))
            {
                double euros = Double.parseDouble(fromTV.getText().toString())* 0.011;
                toTV.setText(euros + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("USD($)"))
            {
                double euros = Double.parseDouble(fromTV.getText().toString())* 0.95;
                toTV.setText(euros + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("EUR(€)"))
            {
                toTV.setText(fromTV.getText());
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("RUB(₽)"))
            {
                double euros = Double.parseDouble(fromTV.getText().toString())* 0.013;
                toTV.setText(euros + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("AED(د.إ)"))
            {
                double rupees=Double.parseDouble(fromTV.getText().toString())* 0.26;
                toTV.setText(rupees + "");
            }
        }
        else if(spinnerTo.getSelectedItem().toString().equals("RUB(₽)"))
        {
            if(spinnerFrom.getSelectedItem().toString().equals("INR(₹)"))
            {
                double ruble = Double.parseDouble(fromTV.getText().toString())* 0.91;
                toTV.setText(ruble + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("USD($)"))
            {
                double ruble = Double.parseDouble(fromTV.getText().toString())* 75.63;
                toTV.setText(ruble + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("EUR(€)"))
            {
                double ruble = Double.parseDouble(fromTV.getText().toString())* 79.84;
                toTV.setText(ruble + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("RUB(₽)"))
            {
                toTV.setText(fromTV.getText());
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("AED(د.إ)"))
            {
                double rupees=Double.parseDouble(fromTV.getText().toString())* 21.17;
                toTV.setText(rupees + "");
            }
        }
        else if(spinnerTo.getSelectedItem().toString().equals("AED(د.إ)"))
        {
            if(spinnerFrom.getSelectedItem().toString().equals("INR(₹)"))
            {
                double dirham = Double.parseDouble(fromTV.getText().toString())* 0.044;
                toTV.setText(dirham + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("USD($)"))
            {
                double dirham = Double.parseDouble(fromTV.getText().toString())* 3.67;
                toTV.setText(dirham + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("EUR(€)"))
            {
                double dirham = Double.parseDouble(fromTV.getText().toString())* 3.96;
                toTV.setText(dirham + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("RUB(₽)"))
            {
                double dirham = Double.parseDouble(fromTV.getText().toString())* 0.048;
                toTV.setText(dirham + "");
            }
            else if(spinnerFrom.getSelectedItem().toString().equals("AED(د.إ)"))
            {
                toTV.setText(fromTV.getText());
            }
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}