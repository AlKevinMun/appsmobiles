package com.example.multicontador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.TextView;

import com.example.multicontador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    int contadorG;
    int contador1;
    int contador2;
    int contador3;
    int contador4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        binding.ResetG.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                contador1 = 0;
                contador2 = 0;
                contador3 = 0;
                contador4 = 0;
                contadorG = 0;
                binding.Contador1.setText("0");
                binding.Contador2.setText("0");
                binding.Contador3.setText("0");
                binding.Contador4.setText("0");
                binding.ContadorG.setText("0");
            }
        });

        binding.Sumar1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                contadorG++;
                binding.ContadorG.setText(""+contadorG);
                contador1++;
                binding.Contador1.setText(""+contador1);

            }
        });
        binding.Sumar2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                contadorG++;
                binding.ContadorG.setText(""+contadorG);
                contador2++;
                binding.Contador2.setText(""+contador2);

            }
        });
        binding.Sumar3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                contadorG++;
                binding.ContadorG.setText(""+contadorG);
                contador3++;
                binding.Contador3.setText(""+contador3);

            }
        });
        binding.Sumar4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                contadorG++;
                binding.ContadorG.setText(""+contadorG);
                contador4++;
                binding.Contador4.setText(""+contador4);

            }
        });
        binding.Reset1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                contadorG=contadorG-contador1;
                binding.ContadorG.setText(""+contadorG);
                contador1=0;
                binding.Contador1.setText(""+contador1);

            }
        });
        binding.Reset2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                contadorG=contadorG-contador2;
                binding.ContadorG.setText(""+contadorG);
                contador2=0;
                binding.Contador2.setText(""+contador2);

            }
        });
        binding.Reset3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                contadorG=contadorG-contador3;
                binding.ContadorG.setText(""+contadorG);
                contador3=0;
                binding.Contador3.setText(""+contador3);

            }
        });
        binding.Reset4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                contadorG=contadorG-contador4;
                binding.ContadorG.setText(""+contadorG);
                contador4=0;
                binding.Contador4.setText(""+contador4);

            }
        });
    }


}