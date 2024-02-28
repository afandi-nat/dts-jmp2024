package net.afandistudio.aplikasikpu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.afandistudio.aplikasikpu.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEntry = findViewById(R.id.btn_entry);
        btnEntry.setOnClickListener(this);
        Button btnList = findViewById(R.id.btn_lihat_data);
        btnList.setOnClickListener(this);
        Button btnLocation = findViewById(R.id.btn_location);
        btnLocation.setOnClickListener(this);
        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_entry) {
            Intent entryIntent = new Intent(MainActivity.this, EntryFormActivity.class);
            startActivity(entryIntent);
        }
        if (v.getId() == R.id.btn_lihat_data) {
            Intent listIntent = new Intent(MainActivity.this, ListDataActivity.class);
            startActivity(listIntent);
        }
        if (v.getId() == R.id.btn_location) {
            Intent locIntent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(locIntent);
        }
        if (v.getId() == R.id.btn_logout) {
            Intent listIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(listIntent);
            finish();
        }
    }
}