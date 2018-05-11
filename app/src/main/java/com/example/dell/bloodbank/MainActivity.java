package com.example.dell.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Dregister(View view)
    {
            Intent intent = new Intent(this,Main2Activity.class);
            startActivity(intent);

    }


    public void BBregister(View view)
    {

            Intent intent1 = new Intent(this,Main3Activity.class);
            startActivity(intent1);

    }

    public void request(View view)
    {

        Intent intent2 = new Intent(this,Main4Activity.class);
        startActivity(intent2);

    }
    public void Dlogin(View view)
{
        Intent intent3 = new Intent(this,Main5Activity.class);
        startActivity(intent3);

}
    public void BBlogin(View view)
    {
        Intent intent4 = new Intent(this,Main6Activity.class);
        startActivity(intent4);

    }



}

