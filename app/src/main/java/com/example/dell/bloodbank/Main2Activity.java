package com.example.dell.bloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {
    Spinner spinner,s3;
    ArrayAdapter<CharSequence> adapter,a3;
    private EditText aphno;
    private EditText name;
    private EditText address;
    private EditText password,cpassword;
    private Button sub;
    Long t1,t2;

    private Firebase RootRef,AbsRef,All,Passwords,Allnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner=(Spinner)findViewById(R.id.spinner2);
        adapter=ArrayAdapter.createFromResource(this,R.array.blood_types,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        s3=(Spinner)findViewById(R.id.spinner3);
        a3=ArrayAdapter.createFromResource(this,R.array.tn_districts,R.layout.support_simple_spinner_dropdown_item);
        a3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(a3);

        aphno=(EditText) findViewById(R.id.editText2);
        name=(EditText) findViewById(R.id.editText);
        address=(EditText) findViewById(R.id.editText3);
        password=(EditText) findViewById(R.id.editText10);
        cpassword=(EditText) findViewById(R.id.editText12);
        sub = (Button) findViewById(R.id.button6);


        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String key=aphno.getText().toString();
                String name1=name.getText().toString();
                String address1=address.getText().toString();
                String city1=s3.getSelectedItem().toString();
                String password1=password.getText().toString();
                String cpassword1=cpassword.getText().toString();
                String blood=spinner.getSelectedItem().toString();

                boolean pstatus = false;
                if (cpassword1.length()!=0 && password1.length()!=0)
                {
                    if (password1.equals(cpassword1))
                    {
                        pstatus = true;
                    }
                }
                boolean nstatus = false;
                if(key.length()==10)
                {
                    nstatus=true;
                }
                if(name1.length()!=0)
                {
                    if(address1.length()!=0) {
                        if(city1.length()!=0) {
                            if (pstatus == true && nstatus == true) {
                                RootRef = new Firebase("https://bloodbank-2bf8f.firebaseio.com/Users/Donars/" + blood + "/" + key + "/");

                                AbsRef = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AbsUsers/Donars/" + city1 + "/" + blood + "/");

                                All = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AllUsers/" + key + "/");

                                Passwords = new Firebase("https://bloodbank-2bf8f.firebaseio.com/Pass/Donar/" + key + "/");

                                Allnum=new Firebase("https://bloodbank-2bf8f.firebaseio.com/AllNumber/");

                                // Write a message to the database
                                Firebase childref, Allchild;
                                Allchild = All.child("name");
                                Allchild.setValue(name1);
                                childref = RootRef.child("name");
                                childref.setValue(name1);
                                AbsRef.push().setValue(name1);

                                Allchild = All.child("address");
                                Allchild.setValue(address1);
                                childref = RootRef.child("address");
                                childref.setValue(address1);
                                AbsRef.push().setValue(address1);

                                Allchild = All.child("phone");
                                Allchild.setValue(key);
                                childref = RootRef.child("phone");
                                childref.setValue(key);
                                AbsRef.push().setValue(key);
                                Allnum.push().setValue(key);

                                Allchild = All.child("city");
                                Allchild.setValue(city1);
                                childref = RootRef.child("city");
                                childref.setValue(city1);

                                Allchild = All.child("password");
                                Allchild.setValue(password1);
                                childref = RootRef.child("password");
                                childref.setValue(password1);
                                Passwords.push().setValue(password1);


                                Toast.makeText(getBaseContext(), "Your responce have been recorded.press back to continue", Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getBaseContext(), "please Enter a valid city", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "please Enter a valid address", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getBaseContext(), "please Enter a valid name", Toast.LENGTH_LONG).show();
                }

                if(pstatus==false) {
                    Toast.makeText(getBaseContext(), "Your password doesn't match", Toast.LENGTH_LONG).show();
                }
                if(nstatus==false)
                {
                    Toast.makeText(getBaseContext(), "Please Enter a valid phone number", Toast.LENGTH_LONG).show();
                }

            }


        });
    }
}
