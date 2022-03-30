package com.example.ebookreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
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
import java.io.InputStreamReader;

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
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    private void called(){
        //this is for debug purpose
        TextView tv1 = new TextView(MainActivity.this);
        tv1.setLayoutParams(params1);
        tv1.setText("functioncalled");
        linearLayout.addView(tv1);
    }
    private void readFile() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open(library)));
            String mline;
            while((mline = reader.readLine())!=null){
                TextView tv = new TextView(MainActivity.this);
                tv.setLayoutParams(params1);
                tv.setText(mline);
                linearLayout.addView(tv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                reader.close();
            }
        }
    }
}