package com.zulfa.loginspiner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nama,passwd;
    Spinner siapa;
    Button masuk;
    String[] HasilSping = {"Masukan Jenis :","Ibu","Anak"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.etnama);
        passwd = findViewById(R.id.etpass);
        siapa = findViewById(R.id.spin);
        masuk = findViewById(R.id.btnmasuk);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nama.getText().toString().length()==0){
                    nama.setError("Masukan Nama");
                }else if (passwd.getText().toString().length()==0){
                    passwd.setError("Masukan Password");
                } else if (siapa.getSelectedItem().toString().equals(HasilSping[1])){
                    Intent a = new Intent(MainActivity.this, IbuActivity.class);
                    startActivity(a);
                } else if (siapa.getSelectedItem().toString().equals(HasilSping[2])){
                    Intent b = new Intent(MainActivity.this, AnakActivity.class);
                    startActivity(b);
                }
            }
        });

        ArrayAdapter Spiner = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, HasilSping);
        siapa.setAdapter(Spiner);

    }

    public  void  Validasi() {
        if (nama.getText().toString().length() == 0) {
            nama.setError("GaBoleh Kosong!!!");
        } else if (passwd.getText().toString().length() == 0) {
            passwd.setError("GaBoleh Kosong!!!");
        }
    }
}
