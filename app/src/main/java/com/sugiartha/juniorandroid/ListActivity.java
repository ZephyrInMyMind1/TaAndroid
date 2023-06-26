package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.SearchView;

public class ListActivity extends AppCompatActivity {

    private ListView lvItem;
    private SearchView searchView;
    private ArrayAdapter<String> adapter; // Declare the adapter as a class-level field
    private String[] namanegara = new String[]{
            "Indonesia", "Malaysia", "Singapore",
            "Italia", "Inggris", "Belanda",
            "Argentina", "Chile",
            "Mesir", "Uganda", "Belgia", "Spanyol", "Portugal",
            "Rusia", "Irlandia", "Kanada", "Brazil", "Argentina"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        searchView = findViewById(R.id.search_view);

        getSupportActionBar().setTitle("ListView Sederhana");

        lvItem = (ListView) findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(ListActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, namanegara);

        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ListActivity.this,
                        "Memilih : " + namanegara[position], Toast.LENGTH_LONG).show();
            }
        });

        setupSearchView(); // Call the setupSearchView method
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}