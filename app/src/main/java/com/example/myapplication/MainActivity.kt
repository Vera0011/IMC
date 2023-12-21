package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val button: Button = findViewById(R.id.submit_button);

        button.setOnClickListener {
            execute();
        }
    }
        fun execute()
        {
            val input_kg : EditText = findViewById(R.id.kg_input);
            val input_m : EditText = findViewById(R.id.meter_input);
            val result_view : TextView = findViewById(R.id.text_result);

            if(input_kg.text.isNullOrEmpty() || input_m.text.isNullOrEmpty()) result_view.text = "Error - Añade todos los valores requeridos";
            else
            {
                try
                {
                    val parsedKG : Double = input_kg.text.toString().toDouble();
                    val parsedM : Double = input_m.text.toString().toDouble();

                    val result : Double = (parsedKG / parsedM.pow(2.0));

                    when
                    {
                        (result < 18.5) -> result_view.text = "Usted sufre delgadez, debería comer más";
                        (result in 18.5..24.9) -> result_view.text = "Su estado de forma es bueno";
                        (result in 25.0..29.9) -> result_view.text = "Usted sufre sobrepeso, debería cuidarse y llamar a un dietista";
                        else -> result_view.text = "Usted sufre obesidad, debería llamar a un médico urgentemente";
                    }
                }
                catch (error : Exception)
                {
                    result_view.text = "Error - Los valores introducidos son inválidos (verifica que sean numéricos y mayores a cero)";
                }
            }
    }
}