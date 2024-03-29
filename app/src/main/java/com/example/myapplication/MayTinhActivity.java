package com.example.myapplication;

import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MayTinhActivity extends AppCompatActivity {
    EditText so1,so2;
    Button actionBtn;

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_may_tinh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        so1 = findViewById(R.id.edt1);
        so2 = findViewById(R.id.edt2);
        actionBtn = findViewById(R.id.actionBtn);
        tv1 = findViewById(R.id.textView);
        actionBtn.setOnClickListener(v -> {
            tingTong();
        });
    }

    private void tingTong() {
        String string1 = so1.getText().toString();
        float soThu1 = Float.parseFloat(string1);
        String string2 = so2.getText().toString();
        float soThu2 = Float.parseFloat(string2);
        float tong = soThu1 + soThu2;
        tv1.setText(String.valueOf(tong));
    }

}