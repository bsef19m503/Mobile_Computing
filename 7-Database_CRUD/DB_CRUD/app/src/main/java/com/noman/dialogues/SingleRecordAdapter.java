package com.noman.dialogues;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SingleRecordAdapter extends BaseAdapter {
    Context MainActivityContext;
    Context context;
    ArrayList<String> studentIDs;
    ArrayList<String> studentNames;
    LayoutInflater inflater;

    public SingleRecordAdapter(Context applicationContext, Context MainActivityContext, ArrayList<String> studentNames, ArrayList<String> studentIDs) {
        this.context = applicationContext;
        this.studentIDs = studentIDs;
        this.studentNames = studentNames;
        inflater = (LayoutInflater.from(applicationContext));
        this.MainActivityContext = MainActivityContext;
    }

    @Override
    public int getCount() {
        return studentIDs.size();
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

        TextView name = view.findViewById(R.id.nameTextView);
        TextView id = view.findViewById(R.id.idTextView);
        ImageButton updateBtn = view.findViewById(R.id.updateBtn);
        ImageButton deleteBtn = view.findViewById(R.id.deleteBtn);

        name.setText(studentNames.get(i));
        id.setText(studentIDs.get(i));
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Update", Toast.LENGTH_SHORT).show();
                updateDialog(i);

            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteDialog(i);
            }
        });

        return view;
    }

    private void deleteDialog(int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityContext);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure you want to delete this?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                studentNames.remove(index);
                studentIDs.remove(index);
                notifyDataSetChanged();
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void updateDialog(int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityContext);
        builder.setTitle("Update");

        View view = inflater.inflate(R.layout.activity_custom_dialog, null);
        EditText idInput = view.findViewById(R.id.idInput);
        EditText nameInput = view.findViewById(R.id.nameInput);
        idInput.setText(studentIDs.get(index));
        nameInput.setText(studentNames.get(index));

        builder.setView(view);

        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                studentIDs.set(index, idInput.getText().toString());
                studentNames.set(index, nameInput.getText().toString());
                notifyDataSetChanged();
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}
