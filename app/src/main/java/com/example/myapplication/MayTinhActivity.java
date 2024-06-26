package com.example.myapplication;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MayTinhActivity extends AppCompatActivity {
    EditText so1,so2;
    Button actionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_may_tinh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textView1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        so1 =findViewById(R.id.edt1);
        so2 =findViewById(R.id.edt2);
        actionBtn = findViewById(R.id.actionBtn);
        actionBtn.setOnClickListener(v -> {
            Intent i = new Intent(MayTinhActivity.this, KetQuaMayTinhActivity.class);
            i.putExtra("firstNum", so1.getText().toString());
            i.putExtra("secondNum", so2.getText().toString());
            startActivity(i);
        });


    }

}