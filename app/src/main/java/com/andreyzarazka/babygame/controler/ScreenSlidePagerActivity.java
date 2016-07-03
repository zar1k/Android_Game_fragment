package com.andreyzarazka.babygame.controler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.andreyzarazka.babygame.R;
import com.andreyzarazka.babygame.fragment.AnimalsFragment;
import com.andreyzarazka.babygame.fragment.CarFragment;
import com.andreyzarazka.babygame.fragment.ColorsFragment;
import com.andreyzarazka.babygame.fragment.ShapeFragment;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePagerActivity extends FragmentActivity {
    private static final int NUM_PAGES = 4;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Полноэкраный режим
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_page_view);

        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        List<Fragment> fragments = getFragments();

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), fragments);
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(new AnimalsFragment());
        fList.add(new CarFragment());
        fList.add(new ColorsFragment());
        fList.add(new ShapeFragment());

        return fList;
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments = null;

        public ScreenSlidePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}