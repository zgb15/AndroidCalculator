package com.example.myapplicationzoe;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private Button btn_suma;
    private Button btn_resta;
    private Button btn_division;
    private Button btn_multiplicacion;
    private Button btn_opuesto;
    private Button btn_porcentaje;
    private TextView text_respuesta;
    private EditText edit_numero_uno;
    private EditText edit_numero_dos;
    private Button btn_borrar;
    private Button btn_useResult;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // textView donde veremos el resultado
        text_respuesta = findViewById(R.id.respuesta);

        // los EditText 1 y 2, donde el usuario escribirá la primera y segunda cifra con las que quiera operar
        edit_numero_uno = findViewById(R.id.numero1);
        edit_numero_dos = findViewById (R.id.numero2);

        // botón que cogerá el resultado y lo pondrá en el primer EditText, para operar con este
        btn_useResult = findViewById(R.id.button_useResult);
        btn_useResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edit_numero_uno.setText(text_respuesta.getText().toString()+"");
                text_respuesta.setText("0");

            }
        });

        // botón suma
        btn_suma = findViewById(R.id.button_suma);
        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText( suma( Integer.parseInt(edit_numero_uno.getText().toString()),Integer.parseInt(edit_numero_dos.getText().toString()) )+"");
            }
        });

        // botón resta
        btn_resta = findViewById(R.id.button_resta);
        btn_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText( resta( Integer.parseInt(edit_numero_uno.getText().toString()),Integer.parseInt(edit_numero_dos.getText().toString()) )+"");

            }
        });

        // botón división
        btn_division = findViewById(R.id.button_division);
        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText( division( Integer.parseInt(edit_numero_uno.getText().toString()),Integer.parseInt(edit_numero_dos.getText().toString()) )+"");

            }
        });

        // botón multiplicación
        btn_multiplicacion = findViewById(R.id.button_multiplicacion);
        btn_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText( multiplicacion( Integer.parseInt(edit_numero_uno.getText().toString()),Integer.parseInt(edit_numero_dos.getText().toString()) )+"");

            }
        });

        // botón porcentaje
        btn_porcentaje = findViewById(R.id.button_porcentaje);
        btn_porcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText( porcentaje( Integer.parseInt(edit_numero_uno.getText().toString()),Integer.parseInt(edit_numero_dos.getText().toString()) )+"");
            }
        });

        // botón (-)
        btn_opuesto = findViewById(R.id.button_opuesto);
        btn_opuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_numero_uno.setText(String.valueOf((-1)*Integer.parseInt(edit_numero_uno.getText().toString())));
            }
        });

        // botón borrar, con el que rsetearemos los EditText para que el usuario vuelva a introducir las cifras
        btn_borrar = findViewById(R.id.button_delete);
        btn_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_numero_uno.setText("");
                edit_numero_dos.setText("");
            }
        });

    }

    // funciones de las operaciones (les pasaremos a y b cogidas de los EditText por parámetro, y retornarán el resultado de operarlas
    public int suma (int a, int b){
        return a+b;
    }

    public int resta (int a, int b){
        return a-b;
    }

    public int multiplicacion (int a, int b){
        return a*b;
    }

    public int division (int a, int b){
        int respuesta = 0;

        // mientras b NO sea 0
        if (b!=0){
            respuesta=a/b;
        }

        return respuesta;
    }

    public int porcentaje (int a, int b){
        return ((a*b)/100);
    }


}