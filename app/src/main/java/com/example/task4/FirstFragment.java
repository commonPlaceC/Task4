package com.example.task4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.task4.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        Button leftButton = binding.buttonLeft;
        Button leftRight = binding.buttonRight;

        


        return binding.getRoot();
    }

    private void switchFrag(FragmentContainerView fcv, Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(fcv.getId(), fragment)
                .commit();
    }
}