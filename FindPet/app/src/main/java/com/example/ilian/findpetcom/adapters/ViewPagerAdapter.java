package com.example.ilian.findpetcom.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

//AQUI ESTAN CONTENIDOS LOS TRES  TABS/FRAGMENTS-------------------------------------------------
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> listFragment=new ArrayList<>();
    private final List<String > lstTitulos=new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstTitulos.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitulos.get(position);

    }

    public void addFragment(Fragment fragment, String title){
        listFragment.add(fragment);
        lstTitulos.add(title);

    }
}
