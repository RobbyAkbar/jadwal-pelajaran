package com.smkn2.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.smkn2.viewpager.ViewPager0_Tab0;
import com.smkn2.viewpager.ViewPager0_Tab1;
import com.smkn2.viewpager.ViewPager0_Tab2;
import com.smkn2.viewpager.ViewPager0_Tab3;
import com.smkn2.viewpager.ViewPager0_Tab4;
import com.smkn2.viewpager.ViewPager0_Tab5;

public class ViewPagerAdapter37 extends FragmentPagerAdapter {

    public ViewPagerAdapter37(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new ViewPager0_Tab0();
            case 1:
                return new ViewPager0_Tab1();
            case 2:
                return new ViewPager0_Tab2();
            case 3:
                return new ViewPager0_Tab3();
			case 4:
				return new ViewPager0_Tab4();
			case 5:
				return new ViewPager0_Tab5();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Senin";
            case 1:
                return "Selasa";
            case 2:
                return "Rabu";
            case 3:
                return "Kamis";
			case 4:
				return "Jum'at";
			case 5:
				return "Sabtu";
        }
        return null;
    }
}
