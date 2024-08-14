package com.example.qrstaff;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CalendarAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> dates;
    private LayoutInflater inflater;
    private int selectedPosition = -1;

    public CalendarAdapter(Context context, ArrayList<String> dates) {
        this.context = context;
        this.dates = dates;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dates.size();
    }

    @Override
    public Object getItem(int position) {
        return dates.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView dateTextView = (TextView) convertView.findViewById(android.R.id.text1);
        dateTextView.setText(dates.get(position));
        dateTextView.setTextColor(Color.BLACK);
        dateTextView.setPadding(8, 8, 8, 8);
        dateTextView.setGravity(View.TEXT_ALIGNMENT_CENTER);

        // Highlight the selected date
        if (position == selectedPosition) {
            convertView.setBackgroundColor(Color.GREEN);
        } else {
            convertView.setBackgroundColor(Color.TRANSPARENT);
        }

        return convertView;
    }

    public void setSelectedPosition(int position) {
        selectedPosition = position;
        notifyDataSetChanged();
    }
}
