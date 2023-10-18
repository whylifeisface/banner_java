package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPage;
    private TextView view1;
    private TextView view2;
    private TextView view3;

    public void onClick(View view) {

        if (Objects.equals(view, view1)) {
            viewPage.setCurrentItem(0);

        } else if (Objects.equals(view, view2)) {

            viewPage.setCurrentItem(1);


        } else if (Objects.equals(view, view3)) {

            viewPage.setCurrentItem(2);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Log.d("HandlerAndSleep", "HandlerAndSleep");
                switch (msg.what) {
                    case 10001:
                        Log.d("11", "handleMessage: "
                                + msg.obj);
                        if (viewPage != null) {
                            viewPage.setCurrentItem((int) msg.obj);
                        }
                }
            }

        };


//        handler.


        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());

        view1 = binding.view1;
        view2 = binding.view2;

        view3 = binding.view3;


        viewPage = binding.viewpage2;

        viewPage.setAdapter(new ViewPageAdapter(getSupportFragmentManager(), getLifecycle(), fragments));

        viewPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                for (int i = 0; i < binding.indicator.getChildCount(); i++) {
                    View child = binding.indicator.getChildAt(i);
                    if (i == position) {
                        child.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        child.setBackgroundResource(R.drawable.btn_white);
                    }
                }
            }
        });
        new Thread(() -> {
            int index = 0;
            while (true) {
                try {
                    Thread.sleep(1000);

                    if (index >= fragments.size()) {
                        index = 0;
                    } else {
                        index++;
                    }
                    Message message = Message.obtain();
                    message.what = 10001;

                    message.obj = index;
                    handler.sendMessage(message);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();

    }
}