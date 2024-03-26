package com.c503.clima_app.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.c503.clima_app.Dominios.Hora;
import com.c503.clima_app.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HoraAdaptada  extends RecyclerView.Adapter<HoraAdaptada.viewHolder> {

    ArrayList<Hora> items;
    Context context;

    public HoraAdaptada(ArrayList<Hora> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hora, parent, false);
        context = parent.getContext();
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.HoraTXt.setText(items.get(position).getHoras());
        holder.TempTxt.setText(items.get(position).getTemperatura()+"°");

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
        TextView HoraTXt, TempTxt;
        ImageView pic;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            HoraTXt = itemView.findViewById(R.id.horatxt);
            TempTxt = itemView.findViewById(R.id.temperaturatxt);
            pic = itemView.findViewById(R.id.pic);


        }
    }
}
