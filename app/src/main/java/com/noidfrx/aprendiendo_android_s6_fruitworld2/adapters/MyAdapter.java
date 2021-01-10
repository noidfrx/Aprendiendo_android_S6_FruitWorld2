package com.noidfrx.aprendiendo_android_s6_fruitworld2.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noidfrx.aprendiendo_android_s6_fruitworld2.R;
import com.noidfrx.aprendiendo_android_s6_fruitworld2.models.Fruta;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Fruta> listaDeFrutas;
    private int layout;
    private OnItemClickListener itemClickListener;
    private Activity activity;

    public MyAdapter(Activity activity, List<Fruta> listaDeFrutas, int layout, OnItemClickListener itemClickListener) {
        this.listaDeFrutas = listaDeFrutas;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.bind(listaDeFrutas.get(position),itemClickListener, activity);
    }

    @Override
    public int getItemCount() {
        return listaDeFrutas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        private ImageView ivFruta;
        private TextView tvNombre,tvDescripcion,tvCantidad;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFruta = itemView.findViewById(R.id.ivFruta);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvCantidad = itemView.findViewById(R.id.tvCantidad);
            itemView.setOnCreateContextMenuListener(this);

        }

        public void bind(Fruta fruta, OnItemClickListener listener, Activity activity){
            Picasso.with(activity).load(fruta.getImgBackground()).fit().into(ivFruta);
            tvNombre.setText(fruta.getNombre());
            tvDescripcion.setText(fruta.getDescripcion());
            tvCantidad.setText(""+fruta.getCantidad());


            /*  Se entregan valores hacia el main para cuando interfaz se instancie allá    */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(fruta.getNombre(),fruta.getDescripcion(),fruta.getImgBackground(),fruta.getImgIcon(),fruta.getCantidad(),getAdapterPosition());
                }
            });

        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            MenuInflater inflater = activity.getMenuInflater();
            inflater.inflate(R.menu.context_menu_frutas,menu);

        }
    }

    public interface OnItemClickListener{
        void onItemClick(String nombre, String descripcion, int imgBackground, int imgIcon, int cantidad, int position);
    }



}


