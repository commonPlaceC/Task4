package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.Window;

import com.example.task4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        FragmentContainerView containerView = binding.containerView;

        FirstFragment firstFragment = new FirstFragment();
        switchFrag(containerView, firstFragment);

    }

    private void switchFrag(FragmentContainerView fcv, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(fcv.getId(), fragment)
                .commit();
    }
}