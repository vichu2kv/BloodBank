package com.example.dell.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;


public class Main6Activity extends AppCompatActivity {
    EditText num1;

    EditText pass1;

    Button leo;

    Firebase getpass1;

    String p1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        num1 = (EditText) findViewById(R.id.editText16);
        pass1 = (EditText) findViewById(R.id.editText17);
        leo = (Button) findViewById(R.id.button18);
    }

    public void BBenter(View view)
    {
        String num11 = num1.getText().toString();
        String pass11 = pass1.getText().toString();
        if(num11.length()==10) {
            getpass1=new Firebase("https://bloodbank-2bf8f.firebaseio.com/Pass/BloodBank/" + num11 + "/");
            getpass1.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    p1=dataSnapshot.getValue().toString();
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
            if (pass11.equals(p1)) {

                Bundle bundle = new Bundle();

                bundle.putString("di", num11);
                Intent intent20 = new Intent(this, Main8Activity.class);
                intent20.putExtras(bundle);
                startActivity(intent20);
            } else {
                Toast.makeText(getBaseContext(), "The password you entered doesnt match with the number", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(getBaseContext(), "please Enter a valid number", Toast.LENGTH_LONG).show();
        }
    }
}
