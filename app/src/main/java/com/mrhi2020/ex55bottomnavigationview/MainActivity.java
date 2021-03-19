package com.mrhi2020.ex55bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;

    FragmentManager fragmentManager;
    Fragment[] fragments= new Fragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        fragments[0]= new Tab1Fragment();
        fragments[1]= new Tab2Fragment();
        fragments[2]= new Tab3Fragment();

        fragmentManager= getSupportFragmentManager();

        FragmentTransaction tran= fragmentManager.beginTransaction();
        tran.add(R.id.container, fragments[0]);
        tran.add(R.id.container, fragments[1]);
        tran.add(R.id.container, fragments[2]);
        tran.show(fragments[0]);
        tran.hide(fragments[1]);
        tran.hide(fragments[2]);
        tran.commit();

        bnv= findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction tran= fragmentManager.beginTransaction();

                switch (item.getItemId()){
                    case R.id.bnv_aa:
                        tran.show(fragments[0]);
                        tran.hide(fragments[1]);
                        tran.hide(fragments[2]);
                        break;
                    case R.id.bnv_bb:
                        tran.hide(fragments[0]);
                        tran.show(fragments[1]);
                        tran.hide(fragments[2]);
                        break;
                    case R.id.bnv_cc:
                        tran.hide(fragments[0]);
                        tran.hide(fragments[1]);
                        tran.show(fragments[2]);
                        break;
                }

                tran.commit();

                return true;
            }
        });
//        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
////                fragments[0].getView().setVisibility(View.GONE);
////                fragments[1].getView().setVisibility(View.GONE);
////                fragments[2].getView().setVisibility(View.GONE);
//
//                //탭의 선택에 따라 Fragment를 동적으로 변경
//                FragmentTransaction tran= fragmentManager.beginTransaction();
//                Fragment fragment=null;
//                switch (item.getItemId()){
//                    case R.id.bnv_aa:
//                        fragment= fragments[0];
//                        break;
//
//                    case R.id.bnv_bb:
//                        fragment= fragments[1];
//                        break;
//
//                    case R.id.bnv_cc:
//                        fragment= fragments[2];
//                        break;
//                }//switch
//
//                //기존 프래그먼트를 없애고 새로운 프래그먼트로 재배치
//                tran.replace(R.id.container,fragment);
//
//                tran.commit();//작업완료
//
//                //return true가 아니면 선택은 되지만 실제 BNV의 선택 효과가 이동하지 않음.
//                return true;
//            }
//        });
    }
}