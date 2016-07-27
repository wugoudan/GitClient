package com.wubo.gitclient.hot.hotlist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by WuBo_PC on 2016/7/27.
 */

public class HotFragementAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> datas = new ArrayList<>();

    public HotFragementAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addDataToAdapter(Fragment fragment){
        if(fragment != null){
            datas.add(fragment);
        }
    }

    public void addAllDataToAdapter(ArrayList<Fragment> fragments){
        if(fragments.size() > 0){
            datas.addAll(fragments);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "JAVA"+position;
    }
}
