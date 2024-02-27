package net.afandistudio.aplikasikpu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import net.afandistudio.aplikasikpu.R;
import net.afandistudio.aplikasikpu.db.DbHelper;

public class EntryFormActivity extends AppCompatActivity {
    DbHelper dbHelper;
    private EditText edtNama, edtNik, edtHp, edtKelamin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_form);

        // Enable the Up button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        getSupportActionBar().setTitle("Entry Voter");

        dbHelper = new DbHelper(this);

        edtNama = findViewById(R.id.edt_nama);
        edtNik = findViewById(R.id.edt_nik);
        edtHp = findViewById(R.id.edt_hp);
        edtKelamin = findViewById(R.id.edt_sex);
        Button btnSave = findViewById(R.id.btn_submit);

        btnSave.setOnClickListener(v -> {
            if (edtNik.getText().toString().isEmpty()) {
                Toast.makeText(EntryFormActivity.this, "Error: NIK harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (edtNama.getText().toString().isEmpty()) {
                Toast.makeText(EntryFormActivity.this, "Error: Nama harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (edtHp.getText().toString().isEmpty()) {
                Toast.makeText(EntryFormActivity.this, "Error: No.HP harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (edtKelamin.getText().toString().isEmpty()) {
                Toast.makeText(EntryFormActivity.this, "Error: Jenis Kelamin harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                dbHelper.addUserDetail(edtNik.getText().toString(), edtNama.getText().toString(), edtHp.getText().toString(), edtKelamin.getText().toString());
                edtNama.setText("");
                edtNik.setText("");
                edtHp.setText("");
                edtKelamin.setText("");

                Toast.makeText(EntryFormActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();

                Intent saveIntent = new Intent(EntryFormActivity.this, MainActivity.class);
                startActivity(saveIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Customize the behavior of the back button
                // For example, you can finish the current activity
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}