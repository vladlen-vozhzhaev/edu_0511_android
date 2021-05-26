package com.example.secondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.List;

public class UserPagerActivity extends AppCompatActivity {
    private ViewPager userViewPager;
    private List<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pager);
        userViewPager = findViewById(R.id.userViewPager);
        users = Users.get(this).getUserList();
        int position = getIntent().getIntExtra("position",1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        userViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) { // фарагмент с текущим пользователем
                User user = users.get(position);
                Bundle args = new Bundle();
                args.putInt("position",position);
                UserFragment fragment = new UserFragment();
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public int getCount() { // возвращает кол-во эллементов списка
                return users.size();
            }
        });
        userViewPager.setCurrentItem(position);
    }
}