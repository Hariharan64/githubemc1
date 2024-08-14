package com.example.qrstaff;





import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder> {

    private final List<AttendanceRecord> attendanceList;

    public AttendanceAdapter(List<AttendanceRecord> attendanceList) {
        this.attendanceList = attendanceList;
    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_attendance, parent, true);
        return new AttendanceViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {
        AttendanceRecord record = attendanceList.get(position);
        holder.dateTextView.setText(record.getDate());
        holder.punchInTextView.setText("Punch In: " + record.getPunchInTime());
        holder.punchOutTextView.setText("Punch Out: " + (record.getPunchOutTime() != null ? record.getPunchOutTime() : "N/A"));
        holder.totalHoursTextView.setText("Total Hours: " + (record.getTotalHours() != null ? record.getTotalHours() : "N/A"));
        holder.statusTextView.setText("Status: " + record.getStatus());
    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }

    public static class AttendanceViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView, punchInTextView, punchOutTextView, totalHoursTextView, statusTextView;

        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            punchInTextView = itemView.findViewById(R.id.punchInTextView);
            punchOutTextView = itemView.findViewById(R.id.punchOutTextView);
            totalHoursTextView = itemView.findViewById(R.id.totalHoursTextView);
            statusTextView = itemView.findViewById(R.id.statusTextView);
        }
    }
}
