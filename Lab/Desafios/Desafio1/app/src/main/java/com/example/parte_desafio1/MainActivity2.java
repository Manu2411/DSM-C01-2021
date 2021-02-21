package com.example.parte_desafio1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends Activity {

    private Bundle bundle;
    private TextView tvSueldo;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvSueldo = (TextView)findViewById(R.id.tv_Suel);

        bundle = getIntent().getExtras();
        String Total = bundle.getString("Total");

        tvSueldo.append("$ " + Total + ".");
    }

}
