package com.example.fikridzakwan.footballmania;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adaptor extends RecyclerView.Adapter<Adaptor.ViewHolder> {

    Context context;
    int[] gambarClub;
    String[] namaClub,detailClub;

    public Adaptor(Context context, int[] gambarClub, String[] namaClub, String[] detailClub) {
        this.context = context;
        this.gambarClub = gambarClub;
        this.namaClub = namaClub;
        this.detailClub = detailClub;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_club, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaClub[i]);
        Glide.with(context).load(gambarClub[i]).into(viewHolder.imgLogo);

        // TODO Membuat onClikListener
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context,DetailClubActivity.class);
                pindah.putExtra("nc", namaClub[i]);
                pindah.putExtra("dc", detailClub[i]);
                pindah.putExtra("gc", gambarClub[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {

        return gambarClub.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView  txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtListTitle);
        }
    }
}
