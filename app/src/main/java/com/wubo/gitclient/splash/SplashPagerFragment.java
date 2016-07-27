package com.wubo.gitclient.splash;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.wubo.gitclient.R;
import com.wubo.gitclient.splash.pager.Pager2;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by WuBo_PC on 2016/7/26.
 */

public class SplashPagerFragment extends Fragment {


    @BindView(R.id.viewPager) ViewPager mViewPager;
    @BindView(R.id.indicator) CircleIndicator mIndicator;
    @BindView(R.id.ivPhoneBlank) ImageView mPhoneBlank;
    @BindView(R.id.ivPhoneFont) ImageView mPhoneFont;
    @BindView(R.id.layoutPhone) FrameLayout mLayoutPhone;
    @BindView(R.id.content) FrameLayout mContent;

    @BindColor(R.color.colorRed) int color0;
    @BindColor(R.color.colorGreen) int color1;
    @BindColor(R.color.colorBlue) int color2;

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

    /**页面滑动时改变，背景颜色*/
    private ViewPager.OnPageChangeListener pagerColorListener = new ViewPager.OnPageChangeListener() {
        ArgbEvaluator evaluator = new ArgbEvaluator();
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if(position == 0){
                int bgColor = (int) evaluator.evaluate(positionOffset, color2, color0);
                mContent.setBackgroundColor(bgColor);
                SplashActivity.setButtonBarColor(bgColor);
            }
            if(position == 1){
                int bgColor = (int) evaluator.evaluate(positionOffset, color0, color1);
                mContent.setBackgroundColor(bgColor);
                SplashActivity.setButtonBarColor(bgColor);
            }
            if(position == 2){
                int bgColor = (int) evaluator.evaluate(positionOffset, color1, color2);
                mContent.setBackgroundColor(bgColor);
                SplashActivity.setButtonBarColor(bgColor);
            }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /**页面滑动时，为手机图片设置Animation*/
    private ViewPager.OnPageChangeListener phoneViewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //页面1——>页面2
            if(position == 0){
                float scaleSize = (float) (0.3 + positionOffset * 0.7);
                //设置手机缩放
                mLayoutPhone.setScaleX(scaleSize);
                mLayoutPhone.setScaleY(scaleSize);

                //设置手机图片的平移
                mLayoutPhone.setTranslationX((positionOffset-1)*360);

                //设置手机图片中字体的透明度
                mPhoneFont.setAlpha(positionOffset);
            }

            //页面2——>页面3
            if(position == 1){
                mLayoutPhone.setTranslationX(-positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
            if(position == 2){
                Pager2 pager2 = (Pager2) adapter.getPager(position);
                pager2.showAnimation();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };




}
