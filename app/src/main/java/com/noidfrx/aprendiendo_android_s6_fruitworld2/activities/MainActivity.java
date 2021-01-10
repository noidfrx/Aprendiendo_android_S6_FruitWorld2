package com.noidfrx.aprendiendo_android_s6_fruitworld2.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaListaDeFrutas();

        rvFrutas = findViewById(R.id.rvFrutas);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter( listaDeFrutas, R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {

            /*  Lo que se hará al hacer click a un item   */
            @Override
            public void onItemClick(String nombre, String descripcion, int imgBackground, int imgIcon, int cantidad, int position) {
                Toast.makeText(MainActivity.this, "Esto es: "+nombre+" Posición: "+position, Toast.LENGTH_SHORT).show();
            }
        });
        rvFrutas.setLayoutManager(mLayoutManager);
        rvFrutas.setAdapter(mAdapter);

        registerForContextMenu(rvFrutas);
    }

    private void inicializaListaDeFrutas() {
        listaDeFrutas = new ArrayList<>();
        listaDeFrutas.add(new Fruta("Strawberry", "Strawberry description", R.drawable.strawberry_bg, R.drawable.ic_strawberry, 0));
        listaDeFrutas.add(new Fruta("Strawberry", "Strawberry description", R.drawable.strawberry_bg, R.drawable.ic_strawberry, 0));
        listaDeFrutas.add(new Fruta("Strawberry", "Strawberry description", R.drawable.strawberry_bg, R.drawable.ic_strawberry, 0));
        listaDeFrutas.add(new Fruta("Strawberry", "Strawberry description", R.drawable.strawberry_bg, R.drawable.ic_strawberry, 0));
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
                Toast.makeText(MainActivity.this, "Add fruta",Toast.LENGTH_SHORT).show();
                break;
            }
            default:break;

        }

        return super.onOptionsItemSelected(item);
    }


}