package com.example.task4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.task4.databinding.FragmentFirstBinding;

import javax.crypto.SealedObject;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private int container_view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        Bundle bundle  = this.getArguments();
        if (bundle != null) {
            this.container_view = bundle.getInt("container_view_id");
        }

        Button leftButton = (Button)binding.buttonLeft;
        Button rightButton = (Button)binding.buttonRight;

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                switchFrag(secondFragment);
            }
        });


        return view;
    }

    private void switchFrag(Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(container_view, fragment)
                .commit();
    }
}