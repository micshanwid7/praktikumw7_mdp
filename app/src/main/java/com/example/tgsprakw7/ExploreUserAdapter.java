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

public class ExploreUserAdapter extends RecyclerView.Adapter<ExploreUserAdapter.ExploreViewHolder> {

    private Context context;
    private ArrayList<Penjualan> listPenj;

    public ExploreUserAdapter(Context context, ArrayList<Penjualan> listPenj) {
        this.context = context;
        this.listPenj = listPenj;
    }

    @NonNull
    @Override
    public ExploreUserAdapter.ExploreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        ExploreViewHolder holder = new ExploreViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreUserAdapter.ExploreViewHolder holder, int position) {
        final Penjualan pen = listPenj.get(position);

        holder.usertoko.setText(pen.getNtoko());
        holder.user.setText(pen.getNuser());
        holder.tgl.setText(pen.getTglwaktu());
        holder.total.setText(pen.getTotal()+"");
        int merah = Color.RED;
        int kuning = Color.YELLOW;
        int hijau = Color.GREEN;

        if(pen.getStatus() == 1){
            holder.itemView.setBackgroundColor(merah);
        }else if(pen.getStatus() == 2){
            holder.itemView.setBackgroundColor(kuning);
        }else{
            holder.itemView.setBackgroundColor(hijau);
        }
    }

    @Override
    public int getItemCount() {
        return listPenj.size();
    }

    public class ExploreViewHolder extends RecyclerView.ViewHolder {
        TextView usertoko, user,tgl,total;

        public ExploreViewHolder(@NonNull View itemView) {
            super(itemView);

            usertoko = itemView.findViewById(R.id.tv_usertoko);
            user = itemView.findViewById(R.id.tv_user);
            tgl = itemView.findViewById(R.id.tv_tgl);
            total = itemView.findViewById(R.id.tv_total);

        }
    }
}
