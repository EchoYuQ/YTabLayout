package com.androidkun.xtablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
    }

    private void initViewPager() {
        List<String> titles = new ArrayList<>();
        titles.add("全部课");
        titles.add("付费课");
        titles.add("免费课");
        titles.add("过期课");
        for (int i = 0; i < titles.size(); i++) {
            if(i%2==0){
                fragments.add(new Fragment2());
            }else{
                fragments.add(new Fragment1());
            }
        }
        FragmentAdapter adatper = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adatper);
        viewPager.setOffscreenPageLimit(4);
        //将TabLayout和ViewPager关联起来。
        XTabLayout tabLayout = (XTabLayout) findViewById(R.id.xTablayout);
//        tabLayout.setupWithViewPager(viewPager);
        //给TabLayout设置适配器
        tabLayout.setupWithViewPager(viewPager);
    }
}
