package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddNoteActivity extends AppCompatActivity {

    DatabaseHelper notesDB;
    Button create, back;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("AddNoteActivity", "AddNoteActivity created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = (EditText) findViewById(R.id.name);
        create = (Button) findViewById(R.id.create);
        back = (Button) findViewById(R.id.back);
        notesDB = new DatabaseHelper(this);

        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("AddNoteActivity", "Add button clicked");
                String newEntry = name.getText().toString();
                if (name.length() != 0) {
                    Log.d("AddNoteActivity", "Adding " + newEntry + " to list");
                    AddData(newEntry);
                    name.setText("");
                } else {
                    Toast.makeText(AddNoteActivity.this, "Name field cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("AddNoteActivity", "Back button clicked");
                finish();
            }
        });
    }

    public void AddData(String newEntry) {

        boolean insertData = notesDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
            finish();
        }else{
        }
    }
}