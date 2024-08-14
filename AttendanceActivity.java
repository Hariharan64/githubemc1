package com.example.qrstaff;





import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AttendanceActivity extends AppCompatActivity {

    private AttendanceAdapter attendanceAdapter;
    private List<AttendanceRecord> attendanceRecords;
    private DatabaseReference databaseReference;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        // Initialize Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("attendance");

        // Initialize Views
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);




        // Setup TabLayout (Year and Month Tabs)
        setupTabs(tabLayout);

        // Setup RecyclerView
        attendanceRecords = new ArrayList<>();
        attendanceAdapter = new AttendanceAdapter(attendanceRecords);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(attendanceAdapter);

        // Load Attendance Data from Firebase
        loadAttendanceData();
    }

    private void setupTabs(TabLayout tabLayout) {
        // Add Year Tabs
        for (int year = 2024; year >= 2019; year--) {
            tabLayout.addTab(tabLayout.newTab().setText(String.valueOf(year)));
        }




        // Add Month Tabs
        tabLayout.addTab(tabLayout.newTab().setText("Aug"));
        // Add more month tabs as needed
    }

    private void loadAttendanceData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                attendanceRecords.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    AttendanceRecord record = snapshot.getValue(AttendanceRecord.class);
                    attendanceRecords.add(record);
                }
                attendanceAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("AttendanceActivity", "Error loading data", databaseError.toException());
            }
        });
    }
}