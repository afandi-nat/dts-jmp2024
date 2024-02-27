package net.afandistudio.aplikasikpu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import net.afandistudio.aplikasikpu.R;
import net.afandistudio.aplikasikpu.db.DbHelper;
import net.afandistudio.aplikasikpu.model.Voters;

public class DetailVoterActivity extends AppCompatActivity {

    private DbHelper dbHelper;
    private TextView tvName, tvNik, tvHp, tvSex;

    private Voters voter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_voter);

        dbHelper = new DbHelper(this);

        tvNik = findViewById(R.id.tv_detail_nik);
        tvName = findViewById(R.id.tv_detail_name);
        tvHp = findViewById(R.id.tv_detail_hp);
        tvSex = findViewById(R.id.tv_detail_sex);

        Intent intent = getIntent();
        voter = (Voters) intent.getSerializableExtra("user");

        assert voter != null;
        tvName.setText(voter.getName());
        tvNik.setText(voter.getNik());
        tvHp.setText(voter.getPhone());
        tvSex.setText(voter.getSex());
    }
}