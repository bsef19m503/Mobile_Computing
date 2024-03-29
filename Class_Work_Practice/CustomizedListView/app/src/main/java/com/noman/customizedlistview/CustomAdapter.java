package com.noman.customizedlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> daysList;
    int pics[];
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, ArrayList<String> daysList, int[] pics) {
        this.context = applicationContext;
        this.daysList = daysList;
        this.pics = pics;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return daysList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_listview, null);
        TextView day = view.findViewById(R.id.dayView);
        ImageView icon = view.findViewById(R.id.dayPic);
        day.setText(daysList.get(i));
        icon.setImageResource(pics[i]);
        return view;
    }
}
