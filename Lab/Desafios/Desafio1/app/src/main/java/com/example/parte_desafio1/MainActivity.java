package com.example.parte_desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText sueldo;
    private EditText Anios;
    private Button Calcular;

    String s, a, To;
    Double Suel, Ani, Total, Aumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sueldo = (EditText)findViewById(R.id.edSueldo);
        Anios = (EditText)findViewById(R.id.edAnios);
        Calcular = (Button)findViewById(R.id.btnCalcular);


        Calcular.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v)
            {
                if(!sueldo.getText().equals("") && !Anios.getText().equals(""))
                {
                    // Convitiendo a String
                    s = sueldo.getText().toString();
                    a = Anios.getText().toString();

                    // Convirtiendo a Double
                    Suel = Double.valueOf(s).doubleValue();
                    Ani = Double.valueOf(a).doubleValue();

                    if (Suel < 0 || Ani < 0 ){
                        Toast.makeText(MainActivity.this,
                                "Los datos ingresados no deben ser negativos.",
                                3000).show();
                    }
                    else if (Suel < 100)
                    {
                        Toast.makeText(MainActivity.this, "El sueldo debe ser mayor a $100.",
                                3000).show();
                    }else
                    {
                        if (Suel < 500 && Ani >= 10)
                        {
                            Aumento = Suel * 0.20;

                            Total = Suel + Aumento;

                            To = Double.toString(Total);
                        }else if(Suel < 500 && Ani < 10){
                            Aumento = Suel * 0.05;

                            Total = Suel + Aumento;

                            To = Double.toString(Total);
                        }else if(Suel >= 500){
                            Total = Suel;

                            To = Double.toString(Total);
                        }

                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                        intent.putExtra("Total", To);
                        startActivity(intent);
                    }
                }else {
                    if (sueldo.getText().equals("") || Anios.getText().equals("")){
                        Toast.makeText(MainActivity.this, "Debe de ingresar datos para procesar, no son permitidos campos vacíos.",
                                3000).show();
                    }
                }
            }
        });
    }
}