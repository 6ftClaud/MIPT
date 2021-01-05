 cWZEX wecl;llllllllllxzčsdėxpackage com.example.lab04;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatabaseHelper notesDB;
    Button back, delete;
    Spinner spinner;
    String EntryName;
    ArrayList<String> datalist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DeleteNoteActivity", "DeleteNoteActivity created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        UpdateList();
        loadSpinnerData();

        spinner = findViewById(R.id.spinner);
        back =  findViewById(R.id.back);
        delete =  findViewById(R.id.delete);

        spinner.setOnItemSelectedListener(this);

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("DeleteNoteActivity", "Deleting " + EntryName);
                notesDB.deleteData(EntryName);
                Toast.makeText(DeleteNoteActivity.this, "Deleting " + EntryName, Toast.LENGTH_SHORT).show();
                UpdateList();
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("DeleteNoteActivity", "Back button clicked");
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        EntryName = parent.getItemAtPosition(position).toString();
        Log.d("DeleteNoteActivity", "Entry selected: " + EntryName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void loadSpinnerData() {
        Log.d("DeleteNoteActivity", "Loading spinner data");
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, datalist);
        spinner.setAdapter(adapter);
    }

    public void UpdateList(){
        Log.d("DeleteNoteActivity", "Data updated");
        notesDB = new DatabaseHelper(this);
        Cursor data = notesDB.getListContents();

        while(data.moveToNext()){
            datalist.add(data.getString(1));}
    }
}