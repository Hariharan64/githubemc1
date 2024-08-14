package com.example.qrstaff;




import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    private EditText edtAdminName;
    private Button btnSaveAdmin;

    private DatabaseReference databaseAdmin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edtAdminName = findViewById(R.id.edtAdminName);
        btnSaveAdmin = findViewById(R.id.btnSaveAdmin);

        databaseAdmin = FirebaseDatabase.getInstance().getReference("admin");

        btnSaveAdmin.setOnClickListener(v -> {
            String adminName = edtAdminName.getText().toString().trim();
            if (!TextUtils.isEmpty(adminName)) {
                databaseAdmin.child("username").setValue(adminName);
                Toast.makeText(this, "Admin name saved", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter an admin name", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
