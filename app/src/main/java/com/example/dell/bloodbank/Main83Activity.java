package com.example.dell.bloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Main83Activity extends AppCompatActivity {

    EditText per,idam,oor;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8;
    Button reg;
    Firebase manref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main83);

        per=(EditText) findViewById(R.id.editText14);
        idam=(EditText) findViewById(R.id.editText15);
        oor=(EditText) findViewById(R.id.editText18);
        cb1=(CheckBox) findViewById(R.id.checkBox);
        cb2=(CheckBox) findViewById(R.id.checkBox2);
        cb3=(CheckBox) findViewById(R.id.checkBox3);
        cb4=(CheckBox) findViewById(R.id.checkBox4);
        cb5=(CheckBox) findViewById(R.id.checkBox5);
        cb6=(CheckBox) findViewById(R.id.checkBox6);
        cb7=(CheckBox) findViewById(R.id.checkBox7);
        cb8=(CheckBox) findViewById(R.id.checkBox8);
        reg=(Button) findViewById(R.id.button9);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                String per1=per.getText().toString();
                String idam1=idam.getText().toString();
                String oor1=oor.getText().toString();
                Bundle bundle33 = getIntent().getExtras();

                String kaipesi = bundle33.getString("pi");
                StringBuffer cbb=new StringBuffer();
                StringBuffer cbb1=new StringBuffer();
                StringBuffer cbb2=new StringBuffer();
                StringBuffer cbb3=new StringBuffer();
                StringBuffer cbb4=new StringBuffer();
                StringBuffer cbb5=new StringBuffer();
                StringBuffer cbb6=new StringBuffer();
                StringBuffer cbb7=new StringBuffer();
                //cbb.append("A-").append(cb1.isChecked());
                if(cb1.isChecked()) {
                    cbb.append("A-");
                    //String cbb="A-";
                    manref = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AbsUsers/Donars/"+oor1+"/"+cbb+"/");

                    manref.push().setValue(per1);
                    manref.push().setValue(idam1);
                    manref.push().setValue(kaipesi);


                }
                if(cb2.isChecked()) {
                    cbb1.append("A+");
                    manref = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AbsUsers/Donars/" + oor1 + "/"+cbb1+"/");

                    manref.push().setValue(per1);
                    manref.push().setValue(idam1);
                    manref.push().setValue(kaipesi);


                }
                if(cb3.isChecked()) {
                    cbb2.append("B+");
                    manref = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AbsUsers/Donars/" + oor1 + "/"+cbb2+"/");

                    manref.push().setValue(per1);
                    manref.push().setValue(idam1);
                   manref.push().setValue(kaipesi);


                }
                if(cb4.isChecked()) {
                    cbb3.append("B-");
                    manref = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AbsUsers/Donars/" + oor1 + "/"+cbb3+"/");

                    manref.push().setValue(per1);
                    manref.push().setValue(idam1);
                    manref.push().setValue(kaipesi);


                }
                if(cb5.isChecked()) {
                    cbb4.append("AB+");
                    manref = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AbsUsers/Donars/" + oor1 + "/"+cbb4+"/");

                    manref.push().setValue(per1);
                    manref.push().setValue(idam1);
                    manref.push().setValue(kaipesi);


                }
                if(cb6.isChecked()) {
                    cbb5.append("AB-");
                    manref = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AbsUsers/Donars/" + oor1 + "/"+cbb5+"/");

                    manref.push().setValue(per1);
                    manref.push().setValue(idam1);
                    manref.push().setValue(kaipesi);


                }
                if(cb7.isChecked()) {
                    cbb6.append("O+");
                    manref = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AbsUsers/Donars/" + oor1 + "/"+cbb6+"/");

                    manref.push().setValue(per1);
                    manref.push().setValue(idam1);
                   manref.push().setValue(kaipesi);


                }
                if(cb8.isChecked()) {
                    cbb7.append("O-");
                    manref = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AbsUsers/Donars/" + oor1 + "/"+cbb7+"/");

                    manref.push().setValue(per1);
                    manref.push().setValue(idam1);
                    manref.push().setValue(kaipesi);


                }

                Toast.makeText(getBaseContext(),"Your responce have been recorded.press back to continue",Toast.LENGTH_LONG).show();

            }
        });
    }
}
