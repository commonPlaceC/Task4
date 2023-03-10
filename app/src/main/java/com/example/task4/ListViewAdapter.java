package com.example.task4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Item> {

    private final LayoutInflater inflater;
    private final int layout;
    private final List<Item> items;

    public ListViewAdapter(@NonNull Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View view = inflater.inflate(this.layout, parent, false);

        Item item = items.get(position);

        TextView textView = view.findViewById(R.id.item_text);
        textView.setText(item.getText());
        ImageView imageView = view.findViewById(R.id.item_image);
        if (item.getImageId() != 0 ) {
            imageView.setImageResource(item.getImageId());
        }

        return view;
    }
}
