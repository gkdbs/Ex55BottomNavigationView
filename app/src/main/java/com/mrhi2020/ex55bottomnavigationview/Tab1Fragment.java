package com.mrhi2020.ex55bottomnavigationview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Tab1Fragment extends Fragment {

    TabLayout tabLayout;
    View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView= view;

        tabLayout= view.findViewById(R.id.layout_tab);
        //탭버튼 만들기
        tabLayout.addTab(tabLayout.newTab().setText("aaa").setTag("1"));
        tabLayout.addTab(tabLayout.newTab().setText("bbb").setTag("2"));

        Toast.makeText(getActivity(), "cv tab1", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "dv tab1", Toast.LENGTH_SHORT).show();
    }



}
