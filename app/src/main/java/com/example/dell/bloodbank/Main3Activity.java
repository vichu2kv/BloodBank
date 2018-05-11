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

public class Main3Activity extends AppCompatActivity {

    private EditText bbaphno;
    private EditText bbname;
    private EditText bbaddress;
    private EditText bbpassword,cbbpassword;
    private Button bbsub;
    Spinner s4;
    ArrayAdapter<CharSequence> a4;

    private Firebase RootRef1,All1,Passwords1,Allnum1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        bbaphno=(EditText) findViewById(R.id.editText2);
        bbname=(EditText) findViewById(R.id.editText);
        bbaddress=(EditText) findViewById(R.id.editText3);
        bbpassword=(EditText) findViewById(R.id.editText10);
        cbbpassword=(EditText) findViewById(R.id.editText12);

        s4=(Spinner)findViewById(R.id.spinner4);
        a4=ArrayAdapter.createFromResource(this,R.array.tn_districts,R.layout.support_simple_spinner_dropdown_item);
        a4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(a4);

        bbsub = (Button) findViewById(R.id.button6);

        bbsub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String bkey=bbaphno.getText().toString();
                String bname1=bbname.getText().toString();
                String baddress1=bbaddress.getText().toString();
                String bcity1=s4.getSelectedItem().toString();
                String bpassword1=bbpassword.getText().toString();
                String cbpassword1=cbbpassword.getText().toString();

                boolean pstatus1 = false;
                if (cbpassword1 != null && bpassword1 != null)
                {
                    if (bpassword1.equals(cbpassword1))
                    {
                        pstatus1 = true;
                    }
                }
                boolean nstatus1 = false;
                if(bkey.length()==10)
                {
                    nstatus1=true;
                }
                if(bname1.length()!=0)
                {
                    if(baddress1.length()!=0) {
                        if(bcity1.length()!=0) {
                            if(pstatus1==true && nstatus1==true) {


                                RootRef1 = new Firebase("https://bloodbank-2bf8f.firebaseio.com/Users/BloodBank/" + bkey + "/");
                                All1 = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AllUsers/" + bkey + "/");
                                Passwords1 = new Firebase("https://bloodbank-2bf8f.firebaseio.com/Pass/BloodBank/" + bkey + "/");

                                Allnum1=new Firebase("https://bloodbank-2bf8f.firebaseio.com/AllNumber/");

                                // Write a message to the database
                                Firebase childref1, Allchild1;
                                childref1 = RootRef1.child("name");
                                childref1.setValue(bname1);
                                Allchild1 = All1.child("name");
                                Allchild1.setValue(bname1);

                                Allnum1.push().setValue(bkey);


                                childref1 = RootRef1.child("address");
                                childref1.setValue(baddress1);
                                Allchild1 = All1.child("address");
                                Allchild1.setValue(baddress1);

                                childref1 = RootRef1.child("city");
                                childref1.setValue(bcity1);
                                Allchild1 = All1.child("city");
                                Allchild1.setValue(bcity1);

                                childref1 = RootRef1.child("password");
                                childref1.setValue(bpassword1);
                                Allchild1 = All1.child("password");
                                Allchild1.setValue(bpassword1);
                                Passwords1.push().setValue(bpassword1);

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
                if(pstatus1==false) {
                    Toast.makeText(getBaseContext(), "Your password doesn't match", Toast.LENGTH_LONG).show();
                }
                if(nstatus1==false)
                {
                    Toast.makeText(getBaseContext(), "Please Enter a valid phone number", Toast.LENGTH_LONG).show();
                }



            }


        });

    }
}
