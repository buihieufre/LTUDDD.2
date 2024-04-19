package com.example.myapplication.BaiTapTuan3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ListViewMainActivity extends AppCompatActivity {
    ArrayList<Info> dataModels = new ArrayList<>(); //Khởi tạo arraylist, không được khởi tạo xong để 0, mặc định sẽ trỏ đến null
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.t3activity_list_view_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lv = (ListView) findViewById(R.id.listView);
        dataModels.add(new Info("Coffee 1","10", R.drawable.product_item_1));
        dataModels.add(new Info("Coffee 2","11", R.drawable.product_item_2));
        dataModels.add(new Info("Coffee 3","1", R.drawable.product_item_3));
        dataModels.add(new Info("Coffee 4","20", R.drawable.product_item_4));
        InfoAdapter adapter = new InfoAdapter(dataModels, this);
        lv.setAdapter(adapter);
    }
}