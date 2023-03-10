package com.example.task4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.task4.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private static final String TAG = "Second List";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        ListView itemList = binding.listItem;
        List<Item> itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item("1", R.drawable.java_logo));
        itemArrayList.add(new Item("2"));
        itemArrayList.add(new Item("3"));

        ListViewAdapter adapter = new ListViewAdapter(requireContext(), R.layout.item, itemArrayList);
        itemList.setAdapter(adapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Item item = itemArrayList.get(position);

                Toast.makeText(requireContext(), item.getText(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, item.getText());
            }
        });

        return view;
    }
}