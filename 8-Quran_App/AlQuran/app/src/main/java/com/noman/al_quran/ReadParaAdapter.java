package com.noman.al_quran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ReadParaAdapter extends BaseAdapter {
    Context ReadByParaContext;
    Context context;
    DatabaseHelper databaseHelper;
    LayoutInflater inflater;
    ArrayList<ParaRecord> AyatList;

    public ReadParaAdapter(Context applicationContext, Context ReadByParaContext, ArrayList<ParaRecord> AyatList) {
        this.context = applicationContext;
        databaseHelper = new DatabaseHelper(ReadByParaContext);
        inflater = (LayoutInflater.from(applicationContext));
        this.ReadByParaContext = ReadByParaContext;
        this.AyatList = AyatList;
    }

    @Override
    public int getCount() {
        return AyatList.size();
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
        view = inflater.inflate(R.layout.para_aya_listview, null);

        TextView title = view.findViewById(R.id.para_aya);
        title.setText(AyatList.get(i).getArabicText());

        return view;
    }

}
