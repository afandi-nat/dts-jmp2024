package net.afandistudio.aplikasikpu.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.afandistudio.aplikasikpu.ui.DetailVoterActivity;
import net.afandistudio.aplikasikpu.R;
import net.afandistudio.aplikasikpu.db.DbHelper;
import net.afandistudio.aplikasikpu.model.Voters;

import java.io.Serializable;
import java.util.ArrayList;

public class VoterAdapter extends RecyclerView.Adapter<VoterAdapter.VoterViewHolder> {
    private ArrayList<Voters> listVoters = new ArrayList<>();
    private Activity activity;

    public VoterAdapter(Activity activity){
        this.activity = activity;
        DbHelper dbHelper = new DbHelper(activity);
    }

    public ArrayList<Voters> getListVoters(){
        return listVoters;
    }
    public void setListVoters(ArrayList<Voters> listVoters){
        if(listVoters.size() > 0 ){
            this.listVoters.clear();
        }
        this.listVoters.addAll(listVoters);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VoterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_voter, parent, false);
        return new VoterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoterViewHolder holder, int position) {
        holder.tvNik.setText(listVoters.get(position).getNik());
        holder.tvName.setText(listVoters.get(position).getName());
        holder.tvHp.setText(listVoters.get(position).getPhone());
        holder.tvSex.setText(listVoters.get(position).getSex());
        holder.btnDetail.setOnClickListener((View v) -> {
            Intent intent = new Intent(activity, DetailVoterActivity.class);
            intent.putExtra("user", (Serializable) listVoters.get(position));
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listVoters.size();
    }

    public static class VoterViewHolder extends RecyclerView.ViewHolder {

        TextView tvNik, tvName, tvHp, tvSex;
        Button btnDetail;
        public VoterViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNik = itemView.findViewById(R.id.tv_item_nik);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvHp = itemView.findViewById(R.id.tv_item_hp);
            tvSex = itemView.findViewById(R.id.tv_item_sex);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
