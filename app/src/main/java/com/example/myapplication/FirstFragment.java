package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.myapplication.databinding.FragmentFirstBinding;

import java.io.File;
import java.util.Objects;


public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFirstBinding binding = FragmentFirstBinding.inflate(inflater);
        Glide.with(requireContext())
                .load("https://plus.unsplash.com/premium_photo-1694825173178-3d2c9bbf5b5f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw5fHx8ZW58MHx8fHx8&auto=format&fit=crop&w=600&q=60")
                .error(R.drawable.ic_launcher_background)
                .into(binding.imageView);

        return binding.getRoot();
    }
}