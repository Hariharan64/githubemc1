package com.example.qrstaff;




public class AttendanceRecord {
    private String date;
    private String punchInTime;
    private String punchOutTime;
    private String totalHours;
    private String status;

    // Default constructor required for calls to DataSnapshot.getValue(AttendanceRecord.class)
    public AttendanceRecord() {}

    public AttendanceRecord(String date, String punchInTime, String punchOutTime, String totalHours, String status) {
        this.date = date;
        this.punchInTime = punchInTime;
        this.punchOutTime = punchOutTime;
        this.totalHours = totalHours;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public String getPunchInTime() {
        return punchInTime;
    }

    public String getPunchOutTime() {
        return punchOutTime;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public String getStatus() {
        return status;
    }
}
