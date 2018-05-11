package com.example.dell.bloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Main71Activity extends AppCompatActivity {

    Firebase root1;
    EditText newadd;
    Button na;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main71);

        newadd=(EditText) findViewById(R.id.editText8);
        na=(Button)findViewById(R.id.button16);

        na.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle bundle1 = getIntent().getExtras();

                String stuff11 = bundle1.getString("stark1");
                String nead=newadd.getText().toString();
                root1 = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AllUsers/" + stuff11 + "/");

                Firebase child1;

                child1=root1.child("address");
                child1.setValue(nead);

                Toast.makeText(getBaseContext(),"Your responce have been recorded.press back to continue",Toast.LENGTH_LONG).show();

            }
        });
    }
}
