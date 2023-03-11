package com.example.task4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.task4.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.SealedObject;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Bundle bundle;
    private int container_view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        bundle  = this.getArguments();
        if (bundle != null) {
            this.container_view = bundle.getInt("container_view_id");
        }

        Button leftButton = (Button)binding.buttonLeft;
        Button rightButton = (Button)binding.buttonRight;

        ArrayList<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            int imageId = (i % 2 == 0) ? R.drawable.android_logo : R.drawable.java_logo;
            itemList.add(new Item(Integer.toString(i + 1), imageId));
        }
        bundle = new Bundle();
        bundle.putSerializable("itemList", itemList);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                switchFrag(secondFragment);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThirdFragment thirdFragment = new ThirdFragment();
                thirdFragment.setArguments(bundle);
                switchFrag(thirdFragment);
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