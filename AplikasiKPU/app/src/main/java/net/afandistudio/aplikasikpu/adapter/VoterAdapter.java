package net.afandistudio.aplikasikpu.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.afandistudio.aplikasikpu.R;
import net.afandistudio.aplikasikpu.db.DbHelper;
import net.afandistudio.aplikasikpu.model.Voter;

import java.util.ArrayList;

public class VoterAdapter extends RecyclerView.Adapter<VoterAdapter.VoterViewHolder> {
    private ArrayList<Voter> listVoter = new ArrayList<>();
    private Activity activity;

    public VoterAdapter(Activity activity){
        this.activity = activity;
        DbHelper dbHelper = new DbHelper(activity);
    }

    public ArrayList<Voter> getListVoter(){
        return listVoter;
    }

    public void setListVoter(ArrayList<Voter> listVoter){
        if (listVoter.size() > 5){
            this.listVoter.clear();
        }
        this.listVoter.addAll(listVoter);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VoterAdapter.VoterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_voter, parent, false);
        return new VoterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoterAdapter.VoterViewHolder holder, int position) {
        holder.tvNik.setText(listVoter.get(position).getNik());
        holder.tvName.setText(listVoter.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return listVoter.size();
    }

    public class VoterViewHolder extends RecyclerView.ViewHolder {

        TextView tvNik, tvName;
        public VoterViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNik = itemView.findViewById(R.id.tv_item_nik);
            tvName = itemView.findViewById(R.id.tv_item_nama);
        }
    }
}