package com.example.sgstore;


import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tab =findViewById(R.id.tabs);
        tab.setupWithViewPager(viewPager);

        tab.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()){

                }
                super.onTabSelected(tab);
            }
        });
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            if (position==0) {
                return "PUBG Global";
            }
            else {
                return "PUBG KR";
            }
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0) {
                return new PubgGlobalFragment();
            }
            else {
                return new PubgKoreanFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}