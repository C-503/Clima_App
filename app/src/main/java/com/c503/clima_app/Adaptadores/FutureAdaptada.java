package com.c503.clima_app.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.c503.clima_app.Dominios.FuturosDominios;
import com.c503.clima_app.Dominios.Hora;
import com.c503.clima_app.R;

import java.util.ArrayList;

public class FutureAdaptada extends RecyclerView.Adapter<FutureAdaptada.viewHolder> {

    ArrayList<FuturosDominios> items;
    Context context;

    public FutureAdaptada(ArrayList<FuturosDominios> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_futuro, parent, false);
        context = parent.getContext();
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.DiaTxt.setText(items.get(position).getDia());
        holder.StatusTxt.setText(items.get(position).getStatus());
        holder.lowTxt.setText(items.get(position).getLowTemp()+"°");
        holder.MaxTxt.setText(items.get(position).getHighTemp()+"°");

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicPath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView DiaTxt, StatusTxt, lowTxt, MaxTxt;
        ImageView pic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            DiaTxt = itemView.findViewById(R.id.DiaTxt);
            StatusTxt = itemView.findViewById(R.id.StatusTxt);
            lowTxt = itemView.findViewById(R.id.lowTxt);
            MaxTxt = itemView.findViewById(R.id.MaxTxt);
            pic = itemView.findViewById(R.id.pic);


        }
    }
}
