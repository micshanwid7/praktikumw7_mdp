package com.example.tgsprakw7;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExploreTokoAdapter extends RecyclerView.Adapter<ExploreTokoAdapter.ExploreTViewHolder> {

    TokoActivity parent;
    private Context context;
    private ArrayList<Penjualan> listPemb;

    public ExploreTokoAdapter(Context context, ArrayList<Penjualan> listPemb, TokoActivity parent) {
        this.context = context;
        this.listPemb = listPemb;
        this.parent = parent;
    }

    @NonNull
    @Override
    public ExploreTokoAdapter.ExploreTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_toko,parent,false);
        ExploreTViewHolder holder = new ExploreTViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExploreTokoAdapter.ExploreTViewHolder holder, final int position) {
        final Penjualan pen = listPemb.get(position);

        holder.usertoko.setText(pen.getNtoko());
        holder.user.setText(pen.getNuser());
        holder.tgl.setText(pen.getTglwaktu());
        holder.total.setText(pen.getTotal()+"");
        holder.change.setText("DONE");
        int merah = Color.RED;
        final int kuning = Color.YELLOW;
        final int hijau = Color.GREEN;

        if(pen.getStatus() == 1){
            holder.itemView.setBackgroundColor(merah);
        }else if(pen.getStatus() == 2){
            holder.itemView.setBackgroundColor(kuning);
        }else{
            holder.itemView.setBackgroundColor(hijau);
            holder.change.setEnabled(false);
        }

        holder.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pen.getStatus() == 1){
                    pen.setStatus(2);
                    holder.itemView.setBackgroundColor(kuning);
                    parent.db.penjualanDao().updateStatus(2, pen.getTglwaktu());
                }else{
                    pen.setStatus(3);
                    holder.itemView.setBackgroundColor(hijau);
                    holder.change.setEnabled(false);
                    parent.db.penjualanDao().updateStatus(3, pen.getTglwaktu());
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return listPemb.size();
    }

    public class ExploreTViewHolder extends RecyclerView.ViewHolder {
        TextView usertoko, user,tgl,total;
        Button change;

        public ExploreTViewHolder(@NonNull View itemView) {
            super(itemView);

            usertoko = itemView.findViewById(R.id.tvt_usertoko);
            user = itemView.findViewById(R.id.tvt_user);
            tgl = itemView.findViewById(R.id.tvt_tgl);
            total = itemView.findViewById(R.id.tvt_total);
            change = itemView.findViewById(R.id.btn);
        }
    }
}
