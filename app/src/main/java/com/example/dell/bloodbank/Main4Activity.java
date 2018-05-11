package com.example.dell.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    Spinner s1,s5;
    ArrayAdapter<CharSequence> adapter1,a5;
     ArrayList<String> dnames = new ArrayList<>();
     Button search;
     ListView list;
    Firebase ref;

    String x,n,place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
       // final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dnames);
        //list.setAdapter(arrayAdapter1);

        ref = new Firebase("https://bloodbank-2bf8f.firebaseio.com/Users/Donars");

        s1 = (Spinner) findViewById(R.id.spinner);
        adapter1 = ArrayAdapter.createFromResource(this, R.array.blood_types, R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter1);

        s5=(Spinner)findViewById(R.id.spinner5);
        a5=ArrayAdapter.createFromResource(this,R.array.tn_districts,R.layout.support_simple_spinner_dropdown_item);
        a5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s5.setAdapter(a5);

        list = (ListView) findViewById(R.id.results);


        s1 = (Spinner) findViewById(R.id.spinner);
        search = (Button) findViewById(R.id.button7);





    }
    public void sea (View view)
    {
        x=s1.getSelectedItem().toString();
        place=s5.getSelectedItem().toString();

        if(place.length()!=0) {
            ref = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AbsUsers/Donars/" + place + "/" + x + "/");
            final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dnames);
            list.setAdapter(arrayAdapter1);
            ref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    n = dataSnapshot.getValue(String.class);
                    dnames.add(n);
                    arrayAdapter1.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else
        {
            Toast.makeText(getBaseContext(), "please Enter a valid city", Toast.LENGTH_LONG).show();
        }
    }

}

