package com.example.dell.bloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Main81Activity extends AppCompatActivity {

    Firebase bbroot1;
    EditText bbnewadd;
    Button bbna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main81);

        bbnewadd=(EditText) findViewById(R.id.editText9);
        bbna=(Button)findViewById(R.id.button17);

        bbna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle bundle21 = getIntent().getExtras();

                String bbstuff = bundle21.getString("di1");
                String bbnead=bbnewadd.getText().toString();
                bbroot1 = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AllUsers/" + bbstuff + "/");

                Firebase child1;

                child1=bbroot1.child("address");
                child1.setValue(bbnead);

                Toast.makeText(getBaseContext(),"Your responce have been recorded.press back to continue",Toast.LENGTH_LONG).show();

            }
        });
    }
}
