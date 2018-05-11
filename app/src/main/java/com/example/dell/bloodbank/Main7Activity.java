package com.example.dell.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        //Bundle bundle = getIntent().getExtras();

        //String stuff = bundle.getString("stark");
    }

    public void DCA(View view)
    {
        Bundle bundle = getIntent().getExtras();

        String stuff1 = bundle.getString("stark");
        Bundle bundle1 = new Bundle();

        bundle1.putString("stark1", stuff1);
        Intent intent50 = new Intent(this,Main71Activity.class);
        intent50.putExtras(bundle1);
        startActivity(intent50);
    }

    public void DCP(View view)
    {
        Bundle bundle = getIntent().getExtras();

        String stuff2 = bundle.getString("stark");
        Bundle bundle2 = new Bundle();

        bundle2.putString("stark2", stuff2);
        Intent intent51 = new Intent(this,Main72Activity.class);
        intent51.putExtras(bundle2);
        startActivity(intent51);
    }
}
