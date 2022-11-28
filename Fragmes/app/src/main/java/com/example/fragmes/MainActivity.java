package com.example.fragmes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initValues();
        initListener();
    }

    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items, this);
        rvLista.setAdapter(adapter);
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }

    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo1));
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo2));
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo3));
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo4));
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo5));
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo6));
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo1));
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo1));
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo2));
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo3));
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo4));
        itemLists.add(new ItemList("Pastel Helado", "Pastel Helado de limon.", R.drawable.PostreCatalogo5));

        return itemLists;
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }
}