package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.myapplication.databinding.FragmentThirdBinding;


public class ThirdFragment extends Fragment {


    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //https://ts1.cn.mm.bing.net/th/id/R-C.eec02321ea106169d757f427b98b358d?rik=%2bgK43uKTPrZbCw&riu=http%3a%2f%2f00.minipic.eastday.com%2f20170823%2f20170823152907_d41d8cd98f00b204e9800998ecf8427e_4.jpeg&ehk=FsISayQ5Gjp%2boHXA8OW7nhrZdn2JEzUKk3lfW%2br0P70%3d&risl=&pid=ImgRaw&r=0
        // Inflate the layout for this fragment
        FragmentThirdBinding binding = FragmentThirdBinding.inflate(inflater);

//        binding.imageView3
        Glide.with(requireContext())
                .load("https://images.unsplash.com/photo-1695653422909-20d8cc35ca2e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1974&q=80")
                .into(binding.imageView3);

        return binding.getRoot();
    }
}