package com.example.task4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task4.databinding.FragmentThirdBinding;

import java.util.ArrayList;
import java.util.List;

public class ThirdFragment extends Fragment {

    FragmentThirdBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        List<Item> itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item("1", R.drawable.java_logo));
        itemArrayList.add(new Item("2"));
        itemArrayList.add(new Item("3"));

        RecyclerView itemList = binding.listItem;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(requireContext(), itemArrayList);
        itemList.setLayoutManager(layoutManager);
        itemList.setAdapter(adapter);

        return view;
    }
}