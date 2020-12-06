package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int count;
    String text = new String();
    Button Button1;
    EditText Text1;
    TextView Text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button1 = (Button)findViewById(R.id.Button1);
        Text1 = (EditText)findViewById(R.id.Text1);
        Text2 = (TextView)findViewById(R.id.Text2);

        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Text1.getText().length() > 0) {
                text = Text1.getText().toString();
                count = Functions.CountWords(text);
                String value=String.valueOf(count);
                Text2.setText(value);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Input is empty",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

class Functions {

    public static int CountWords(String str){
        String[] count = str.trim().split("\\s|\\,|\\.");
        return count.length;
    }

}