package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KetQuaMayTinhActivity extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ket_qua_may_tinh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textView1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv1 = findViewById(R.id.result);
        Intent i2 = getIntent();
        String sot1 = i2.getExtras().getString("firstNum");
        String sot2 = i2.getExtras().getString("secondNum");
        float soThuNhat = Float.parseFloat(sot1);
        float soThuHai = Float.parseFloat(sot2);
        float tong = soThuNhat +soThuHai;
        tv1.setText(String.valueOf(tong));
    }
}