package com.wubo.gitclient.splash.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.wubo.gitclient.R;

/**
 * Created by WuBo_PC on 2016/7/26.
 */

public class pager1 extends FrameLayout {
    public pager1(Context context) {
        super(context);
        initView();
    }

    public pager1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public pager1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_1,this);
    }
}
