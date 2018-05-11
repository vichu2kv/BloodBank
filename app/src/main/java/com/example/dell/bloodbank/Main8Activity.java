package com.example.dell.bloodbank;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
    }

    public void BBCA(View view)
    {
        Bundle bundle = getIntent().getExtras();

        String bluff1 = bundle.getString("di");
        Bundle bundle21 = new Bundle();

        bundle21.putString("di1", bluff1);
        Intent intent52 = new Intent(this,Main81Activity.class);
        intent52.putExtras(bundle21);
        startActivity(intent52);
    }

    public void BBCP(View view)
    {
        Bundle bundle = getIntent().getExtras();

        String bluff2 = bundle.getString("di");
        Bundle bundle22 = new Bundle();

        bundle22.putString("di2", bluff2);
        Intent intent53 = new Intent(this,Main82Activity.class);
        intent53.putExtras(bundle22);
        startActivity(intent53);
    }

    public void manage(View view)
    {
        Bundle bundle = getIntent().getExtras();

        String bluff3 = bundle.getString("di");
        Bundle bundle33 = new Bundle();

        bundle33.putString("pi", bluff3);
        Intent intent75=new Intent(this,Main83Activity.class);
        intent75.putExtras(bundle33);
        startActivity(intent75);
    }

    public void camp(View view)
    {
        Uri uri = Uri.parse("https://console.firebase.google.com/project/bloodbank-2bf8f/notification/compose");
        Intent intent0 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent0);
    }
}
