package net.afandistudio.aplikasikpu.ui;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.afandistudio.aplikasikpu.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInfo = findViewById(R.id.btn_information);
        Button btnEntry = findViewById(R.id.btn_entry);
        Button btnLihatData = findViewById(R.id.btn_lihat);
        Button btnKeluar = findViewById(R.id.btn_keluar);
        btnInfo.setOnClickListener(this);
        btnEntry.setOnClickListener(this);
        btnLihatData.setOnClickListener(this);
        btnKeluar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_entry){
            Intent entryIntent = new Intent(MainActivity.this, EntryFormActivity.class);
            startActivity(entryIntent);
        }
        if (v.getId() == R.id.btn_lihat){
            Intent listIntent = new Intent(MainActivity.this, ListVoterActivity.class);
            startActivity(listIntent);
        }
        if (v.getId() == R.id.btn_keluar){
            Intent listIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(listIntent);
            finish();
        }
    }
}
