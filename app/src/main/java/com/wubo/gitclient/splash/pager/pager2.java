package com.wubo.gitclient.splash.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.wubo.gitclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WuBo_PC on 2016/7/26.
 */

public class Pager2 extends FrameLayout {
    @BindView(R.id.ivBubble1) ImageView mBubble1;
    @BindView(R.id.ivBubble2) ImageView mBubble2;
    @BindView(R.id.ivBubble3) ImageView mBubble3;

    public Pager2(Context context) {
        super(context);
        initView();
    }

    public Pager2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public Pager2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_2, this);
        ButterKnife.bind(this);
        mBubble1.setVisibility(GONE);
        mBubble2.setVisibility(GONE);
        mBubble3.setVisibility(GONE);
    }

    //为图片添加动画
    public void showAnimation(){
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mBubble1.setVisibility(VISIBLE);
                YoYo.with(Techniques.FadeInLeft).duration(500).playOn(mBubble1);
            }
        },50);
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mBubble2.setVisibility(VISIBLE);
                YoYo.with(Techniques.FadeInLeft).duration(500).playOn(mBubble2);
            }
        },550);
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mBubble3.setVisibility(VISIBLE);
                YoYo.with(Techniques.FadeInLeft).duration(500).playOn(mBubble3);
            }
        },1050);
    }
}
