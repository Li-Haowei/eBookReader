package com.example.ebookreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private String library = "惊悚乐园.txt";
    private ScrollView SL;
    private Button btnPre;
    private Button btnNext;
    private LinearLayout.LayoutParams params1;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SL = findViewById(R.id.SL);
        btnPre = findViewById(R.id.btnpre);
        btnNext = findViewById(R.id.btnnext);
        params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(linearParams);
        SL.addView(linearLayout);

        btnNext.setOnClickListener(view -> {
            TextView tv = new TextView(MainActivity.this);
            tv.setLayoutParams(params1);
            tv.setText("what's up");
            linearLayout.addView(tv);
        });
        btnPre.setOnClickListener(view -> {
            TextView tv = new TextView(MainActivity.this);
            tv.setLayoutParams(params1);
            tv.setText("what's up!");
            linearLayout.addView(tv);
        });

    }
    private void readFile() throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(getAssets().open(library).toString()));
            String line = reader.readLine();
            while(line!=null){
                TextView tv = new TextView(this);
                tv.setText(line);
                line = reader.readLine();
                linearLayout.addView(tv);
            }
        }
        catch (IOException e) {
            Log.d("creation","shit went wrong");
        }
    }
}