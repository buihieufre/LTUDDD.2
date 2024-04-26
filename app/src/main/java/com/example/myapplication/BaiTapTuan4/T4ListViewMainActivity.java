package com.example.myapplication.BaiTapTuan4;

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

public class T4ListViewMainActivity extends AppCompatActivity {
    ArrayList<PersonInfo> dataList = new ArrayList<>();
    private Button btn;
    private ListView listView;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_t4_list_view_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn = findViewById(R.id.btnGet);
        listView = findViewById(R.id.listView2);
        btn.setOnClickListener(v -> {
            VolleyFn2 volleyFn2 = new VolleyFn2();
            volleyFn2.getAllData(context, listView);
        });
    }
}