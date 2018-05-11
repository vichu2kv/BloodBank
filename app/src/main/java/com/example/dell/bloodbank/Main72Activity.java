package com.example.dell.bloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Main72Activity extends AppCompatActivity {

    Firebase root2;
    EditText newph;
    Button np;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main72);

        newph=(EditText) findViewById(R.id.editText11);
        np=(Button)findViewById(R.id.button19);

        np.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle bundle2 = getIntent().getExtras();

                String stuff21 = bundle2.getString("stark2");
                String nph=newph.getText().toString();
                root2 = new Firebase("https://bloodbank-2bf8f.firebaseio.com/AllUsers/" + stuff21 + "/");

                Firebase child2;

                child2=root2.child("phone");
                child2.setValue(nph);

                Toast.makeText(getBaseContext(),"Your responce have been recorded.press back to continue",Toast.LENGTH_LONG).show();

            }
        });
    }
}
