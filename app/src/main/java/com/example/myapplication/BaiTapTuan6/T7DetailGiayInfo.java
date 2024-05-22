package com.example.myapplication.BaiTapTuan6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class T7DetailGiayInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_t7_detail_giay_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        GiayInfo product = intent.getParcelableExtra("PRODUCT");
        ImageView imageView = findViewById(R.id.t7image);
        TextView styleId = findViewById(R.id.t7styleID);
        TextView brand = findViewById(R.id.t7brand);
        TextView price = findViewById(R.id.t7Price);
        TextView info = findViewById(R.id.t7Info);
        if(product != null){
            Picasso.get().load(product.getSearch_image()).into(imageView);
            styleId.setText("ID: " + product.getStyleid());
            brand.setText("Brand: " + product.getBrands_filter_facet());
            price.setText("Price: " + product.getPrice());
            info.setText("Info: " + product.getProduct_additional_info());
        }
    }
}