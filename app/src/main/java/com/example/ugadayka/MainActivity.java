package com.example.ugadayka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etSlow;
    Button bControl;

    boolean gameFinal = false;
    Integer goose = (int)(Math.random() * 100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void GO(View view) {
        tvInfo = findViewById(R.id.textView);
        etSlow = findViewById(R.id.editTextTextPersonName);
        bControl = findViewById(R.id.button);

        if(!gameFinal){
            if(etSlow.getText().toString().length() != 0) {
                int pin = Integer.parseInt(etSlow.getText().toString());
                if (pin > 100 || pin < 0) {
                    tvInfo.setText("Попробуй угадать чило от 1 до 100");
                    etSlow.setText("Число не адекватное");
                } else {
                    if (pin == goose) {
                        tvInfo.setText("В точку");
                        bControl.setText("Сыграть ещё");
                        gameFinal = true;
                    }
                    if (pin > goose)
                        tvInfo.setText("Перелёт");
                    if (pin < goose)
                        tvInfo.setText("Недолёт");
                }
            }
        }
        else{
            goose = (int)(Math.random() * 100);
            bControl.setText("Нажать");
            tvInfo.setText("Попробуй угадать чило от 1 до 100");
            gameFinal = false;
        }
    }
}