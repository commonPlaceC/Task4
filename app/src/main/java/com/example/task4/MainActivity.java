package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.task4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        FragmentContainerView containerView = (FragmentContainerView)binding.containerView;
        FirstFragment firstFragment = new FirstFragment();
        switchFrag(containerView, firstFragment);
    }

    private void switchFrag(FragmentContainerView fcv, Fragment fragment) {
        int containerViewId = fcv.getId();

        Bundle bundle = new Bundle();
        bundle.putInt("container_view_id", containerViewId);
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(fcv.getId(), fragment)
                .commit();
    }
}