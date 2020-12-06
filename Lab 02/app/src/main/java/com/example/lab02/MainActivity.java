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
    String text;
    Button button;
    EditText input;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.Button1);
        input = (EditText)findViewById(R.id.Text1);
        answer = (TextView)findViewById(R.id.Text2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (input.getText().length() > 0) {
                text = input.getText().toString();
                count = Functions.CountWords(text);
                String value=String.valueOf(count);
                answer.setText(value);
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