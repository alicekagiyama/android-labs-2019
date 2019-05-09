package com.example.th;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button Button_skip1 = (Button) findViewById(R.id.button_zz);
        Button_skip1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, Main2Activity.class)); }
                });

        Button Button_skip2 = (Button) findViewById(R.id.button_alice);
        Button_skip2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, Main4Activity.class)); }
                });

        Button Button_skip3 = (Button) findViewById(R.id.button_medicine);
        Button_skip3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, Main3Activity.class)); }
                })


        ;}}

