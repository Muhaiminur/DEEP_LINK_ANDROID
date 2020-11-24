package com.example.deep_link;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView deep_text;
    Button share_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            deep_text = findViewById(R.id.deep_link);
            share_page = findViewById(R.id.share_page);
            Intent intent = getIntent();
            String action = intent.getAction();
            Uri data = intent.getData();
            if (data != null && data.isHierarchical()) {
                String uri = this.getIntent().getDataString();
                deep_text.setText(uri);
                Log.d("paisi", data.toString());
            } else {
                deep_text.setText("Not Open with Deep Link");
            }
            share_page.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, SHARE_PAGE.class));
                }
            });
        } catch (Exception e) {
            Log.d("Error Line Number", Log.getStackTraceString(e));
        }
    }
}
