package com.example.myapplication.ListView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ListViewActivity extends AppCompatActivity {

    ListView myListView;
    String[] myData = {
            "Alice",
            "Bob",
            "Charlie",
            "David",
            "Emily",
            "Frank",
            "Grace",
            "Hannah",
            "Isaac",
            "Julia"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        EdgeToEdge.enable(this);
        myListView =  (ListView) findViewById(R.id.myList);
        ArrayAdapter<String> cheeseAdapter = new ArrayAdapter<String> (
                this,
                R.layout.activity_list_view2,
                R.id.simpleItemTextView,
                myData
        );
        myListView.setAdapter(cheeseAdapter);

    }


}