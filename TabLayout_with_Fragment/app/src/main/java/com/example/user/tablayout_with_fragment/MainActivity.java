package com.example.user.tablayout_with_fragment;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayoutId);
        appBarLayout = findViewById(R.id.appBarId);
        viewPager = findViewById(R.id.viewPagerId);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding FragmentName
        adapter.AddFragment(new FragmentShare(),"Share");
        adapter.AddFragment(new FragmentHistory(),"History");
        adapter.AddFragment(new FragmentFavourite(),"Favourite");

        //Adapter Step
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
