package com.noidfrx.aprendiendo_android_s6_fruitworld2.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.noidfrx.aprendiendo_android_s6_fruitworld2.R;
import com.noidfrx.aprendiendo_android_s6_fruitworld2.adapters.MyAdapter;
import com.noidfrx.aprendiendo_android_s6_fruitworld2.models.Fruta;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fruta> listaDeFrutas;
    private RecyclerView rvFrutas;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaListaDeFrutas();

        rvFrutas = findViewById(R.id.rvFrutas);
        rvFrutas.setHasFixedSize(true);
        rvFrutas.setItemAnimator(new DefaultItemAnimator());

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(this, listaDeFrutas, R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {

            /*  Lo que se hará al hacer click a un item   */
            @Override
            public void onItemClick(String nombre, String descripcion, int imgBackground, int imgIcon, int cantidad, int position) {
                Fruta f = new Fruta(nombre,descripcion,imgBackground,imgIcon,cantidad);
                if(f.aumentarCantidad()){
                    Toast.makeText(MainActivity.this, "Item de posición: "+position+" modificado con éxito", Toast.LENGTH_SHORT).show();
                    listaDeFrutas.set(position,f);
                    mAdapter.notifyItemChanged(position);
                }
                else{
                    Toast.makeText(MainActivity.this, "Problemas con el aumento de cantidad", Toast.LENGTH_SHORT).show();
                }



            }
        });
        rvFrutas.setLayoutManager(mLayoutManager);
        rvFrutas.setAdapter(mAdapter);

    }

    private void inicializaListaDeFrutas() {
        listaDeFrutas = new ArrayList<>();
        listaDeFrutas.add(new Fruta("Strawberry", "Strawberry description", R.drawable.strawberry_bg, R.drawable.ic_strawberry, 0));
        listaDeFrutas.add(new Fruta("Strawberry", "Strawberry description", R.drawable.strawberry_bg, R.drawable.ic_strawberry, 0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_frutas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_fruta:{
                addFruta();
                break;
            }
            default:break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void addFruta() {
        Toast.makeText(MainActivity.this, "Fruta añadida con éxito",Toast.LENGTH_SHORT).show();
        Fruta f = new Fruta(
                "Nueva fruta : "+counter,
                "Fruta "+counter+" añadida",
                R.drawable.fruit_world_2,
                R.drawable.ic_fruits,
                0);
        listaDeFrutas.add(counter,f);
        mAdapter.notifyItemInserted(counter);
        mLayoutManager.scrollToPosition(counter);
        counter++;
    }


}