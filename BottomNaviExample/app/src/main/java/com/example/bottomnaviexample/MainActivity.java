package com.example.bottomnaviexample;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    // fragmentManger : 액티비티와 프래그먼트의 중간에서 서로를 이어주는 역할
    private FragmentManager fm;

    // fragmentTransaction : 프래그먼트를 추가, 삭제, 교체 등의 작업 수행 + 행해진 트랜잭션의 상태 프래그먼트 백스택에 저장
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_airplane:
                        setFrag(0);
                        break;
                    case R.id.action_bus:
                        setFrag(1);
                        break;
                    case R.id.action_bt:
                        setFrag(2);
                        break;
                    case R.id.action_call:
                        setFrag(3);
                        break;
                    case R.id.action_run:
                        setFrag(4);
                        break;
                }

                return true;
            }
        });

        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();
        setFrag(0); //첫 프래그먼트 화면을 무엇으로 지정해줄 것인지 선택
    }

    //프래그먼트 교체가 일어나는 실행문
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction(); // 실제적인 프레그먼트 교체
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, frag1);
                ft.commit(); //저장
                break;
            case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag3);
                ft.commit(); //저장
                break;
            case 3:
                ft.replace(R.id.main_frame, frag4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame, frag5);
                ft.commit(); //저장
                break;
        }

    }

}