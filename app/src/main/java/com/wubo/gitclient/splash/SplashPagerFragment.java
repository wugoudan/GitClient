package com.wubo.gitclient.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wubo.gitclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by WuBo_PC on 2016/7/26.
 */

public class SplashPagerFragment extends Fragment {


    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.indicator)
    CircleIndicator mIndicator;
//    @BindView(R.id.ivPhoneBlank)
//    ImageView mPhoneBlank;
//    @BindView(R.id.ivPhoneFont)
//    ImageView mPhoneFont;
//    @BindView(R.id.layoutPhone)
//    FrameLayout mLayoutPhone;
//    @BindView(R.id.content)
//    FrameLayout mContent;

    private SplashPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_pager, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new SplashPagerAdapter(getContext());
        mViewPager.addOnPageChangeListener(pagerColorListener);
        mViewPager.addOnPageChangeListener(phoneViewListener);
        mViewPager.setAdapter(adapter);
        mIndicator.setViewPager(mViewPager);
    }

    private ViewPager.OnPageChangeListener pagerColorListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private ViewPager.OnPageChangeListener phoneViewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };




}
