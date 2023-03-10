package com.example.task4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task4.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    FragmentThirdBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();



        return view;
    }
}