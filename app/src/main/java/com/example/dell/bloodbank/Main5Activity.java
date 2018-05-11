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


public class Main5Activity extends AppCompatActivity {

    EditText num;

    EditText pass;

    Button tony;

    Firebase getpass;
    String p;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        num = (EditText) findViewById(R.id.editText6);
        pass = (EditText) findViewById(R.id.editText7);
        tony = (Button) findViewById(R.id.button8);









    }
    public void Denter(View view) {

        String num1 = num.getText().toString();
        String pass1 = pass.getText().toString();
        if(num1.length()==10) {
            getpass=new Firebase("https://bloodbank-2bf8f.firebaseio.com/Pass/Donar/" + num1 + "/");
            getpass.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    p=dataSnapshot.getValue().toString();
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
            if (pass1.equals(p)) {

                Bundle bundle = new Bundle();

                bundle.putString("stark", num1);


                Intent intent100 = new Intent(this, Main7Activity.class);

                intent100.putExtras(bundle);

                startActivity(intent100);
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
