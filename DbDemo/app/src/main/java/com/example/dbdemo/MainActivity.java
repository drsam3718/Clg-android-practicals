package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dbdemo.adapter.RecyclerViewAdapter;
import com.example.dbdemo.data.MyDbHandler;
import com.example.dbdemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyDbHandler db = new MyDbHandler(MainActivity.this);

        contactArrayList = new ArrayList<>();


        List<Contact> contactList = db.getAllContact();
        for(Contact contact: contactList){
            Log.d("dbtest", "ID : " + contact.getId() + "\nName : " +contact.getName() + "\nNumber : " + contact.getPhoneNumber()+ "\n");
            contactArrayList.add(contact);
        }

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

        Log.d("dbtest1", "You have " + db.getCount()+ " records!!!");

    }
}