package com.example.dell.bloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Main82Activity extends AppCompatActivity {

    Firebase bbroot2;
    EditText bbnewph;
    Button bbnp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main82);

        bbnewph=(EditText) findViewById(R.id.editText13);
        bbnp=(Button)findViewById(R.id.button20);

        bbnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle bundle22 = getIntent().getExtras();

                String bbstuff1 = bundle22.getString("di2");
                String bbneph=bbnewph.getText().toString();
                bbroot2 = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AllUsers/" + bbstuff1 + "/");

                Firebase child1;

                child1=bbroot2.child("phone");
                child1.setValue(bbneph);

                Toast.makeText(getBaseContext(),"Your responce have been recorded.press back to continue",Toast.LENGTH_LONG).show();

            }
        });
    }
}
