package net.afandistudio.aplikasikpu.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import net.afandistudio.aplikasikpu.R;
import net.afandistudio.aplikasikpu.adapter.VoterAdapter;
import net.afandistudio.aplikasikpu.db.DbHelper;
import net.afandistudio.aplikasikpu.model.Voters;

import java.util.ArrayList;

public class ListVoterActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VoterAdapter adapter;
    private ArrayList<Voters> votersArrayList;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_voter);

        recyclerView = (RecyclerView) findViewById(R.id.rview);
        adapter = new VoterAdapter(this);

        dbHelper = new DbHelper(this);
        votersArrayList = dbHelper.getAllUsers();
        adapter.setListVoters(votersArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListVoterActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        votersArrayList = dbHelper.getAllUsers();
        adapter.setListVoters(votersArrayList);
        adapter.notifyDataSetChanged();
    }
}