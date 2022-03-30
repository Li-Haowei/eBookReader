package com.example.ebookreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private String library = "惊悚乐园.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Log.d("creation",getAssets().open(library).toString());
        } catch (IOException e) {
            Log.d("creation","failed");
            e.printStackTrace();
        }
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void readFile() throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(getAssets().open(library).toString()));
            String line = reader.readLine();
            while(line!=null){
                Log.d("creation",line);
                line = reader.readLine();
            }
        }
        catch (IOException e) {
            Log.d("creation","shit went wrong");
        }
    }
}