package com.wubo.gitclient.hot;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wubo.gitclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 热门仓库页面
 * Created by WuBo_PC on 2016/7/27.
 */

public class HotMainFragment extends Fragment {

    @BindView(R.id.tabLayout) TabLayout mTabLayout;
    @BindView(R.id.viewPager) ViewPager mViewPager;

    private HotFragementAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot_repo, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapterData();
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initAdapterData(){
        adapter = new HotFragementAdapter(getChildFragmentManager());
        for (int i = 0; i < 10; i++) {
            adapter.addDataToAdapter(new HotListFrament());
        }
    }

}
