package com.example.chiranshu.project7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Search(View view) {
        EditText book_tobe_searched = (EditText) findViewById(R.id.edit_query);
        String searched = book_tobe_searched.getText().toString();
        Intent activity1 = new Intent(MainActivity.this, searched_list.class);
        activity1.putExtra("word", searched);
        startActivity(activity1);
    }
}
