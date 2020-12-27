package com.example.lab04;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    DatabaseHelper notesDB;
    Button refresh;
    ListAdapter listAdapter;
    ListView listView;
    ArrayList<String> datalist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "MainActivity created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UpdateList();
        refresh = (Button) findViewById(R.id.refresh);

        refresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("MainActivity", "Refreshing data");
                UpdateList();
            }
        });
    }


    public void UpdateList(){
        Log.d("MainActivity", "Updating data");
        datalist.clear();
        notesDB = new DatabaseHelper(this);
        listView = (ListView) findViewById(R.id.List);
        Cursor data = notesDB.getListContents();

        while(data.moveToNext()){
            datalist.add(data.getString(1));
            listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,datalist);
            listView.setAdapter(listAdapter); }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("MainActivity", "Creating menu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("MainActivity", "Menu item selected");
        switch (item.getItemId()){
            case R.id.createnote:
                Log.d("MainActivity", "Create note item selected");
                Intent addnote = new Intent(this, AddNoteActivity.class);
                startActivity(addnote);
                return true;
            case R.id.deletenote:
                Log.d("MainActivity", "Delete note item selected");
                Intent deletenote = new Intent(this, DeleteNoteActivity.class);
                startActivity(deletenote);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}