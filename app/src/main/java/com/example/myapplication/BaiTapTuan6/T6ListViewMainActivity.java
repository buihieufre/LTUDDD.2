package com.example.myapplication.BaiTapTuan6;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.ArrayList;

public class T6ListViewMainActivity extends AppCompatActivity {
    ArrayList<GiayInfo> dataList = new ArrayList<>();
    private Button btn;
    private ListView listView;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.t6_mainactivity_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.t6main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.t6ListView);
        T6VolleyFn2 volley = new T6VolleyFn2();
        volley.getAllData(context, listView);
    }
}