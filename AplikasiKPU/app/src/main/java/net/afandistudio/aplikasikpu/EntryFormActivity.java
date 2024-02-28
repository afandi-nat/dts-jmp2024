package net.afandistudio.aplikasikpu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.afandistudio.aplikasikpu.db.DbHelper;

public class EntryFormActivity extends AppCompatActivity {
    DbHelper dbHelper;
    private EditText edtNik, edtName, edtAddress, edtSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_form);

        getSupportActionBar().setTitle("Entry Data");

        dbHelper = new DbHelper(this);

        edtNik = findViewById(R.id.edt_nik);
        edtName = findViewById(R.id.edt_name);
        edtAddress = findViewById(R.id.edt_address);
        edtSex = findViewById(R.id.edt_sex);

        Button btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtNik.getText().toString().isEmpty()){
                    Toast.makeText(EntryFormActivity.this, "NIK tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else if(edtName.getText().toString().isEmpty()){
                    Toast.makeText(EntryFormActivity.this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else if(edtAddress.getText().toString().isEmpty()){
                    Toast.makeText(EntryFormActivity.this, "Alamat tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else if(edtSex.getText().toString().isEmpty()){
                    Toast.makeText(EntryFormActivity.this, "Jenis Kelamin tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else{
                    dbHelper.addUser(edtNik.getText().toString(), edtName.getText().toString(), edtAddress.getText().toString(), edtSex.getText().toString());
                    edtNik.setText("");
                    edtName.setText("");
                    edtAddress.setText("");
                    edtSex.setText("");
                    Toast.makeText(EntryFormActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();

                    Intent saveIntent = new Intent(EntryFormActivity.this, MainActivity.class);
                    startActivity(saveIntent);
                }
            }
        });
    }

}