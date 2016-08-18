package com.wubo.gitclient.compoents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wubo.gitclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ListView滑动到底部时的FooterView
 * 该View有3个状态，正在加载中、加载完成、加载错误
 * Created by WuBo_PC on 2016/7/29.
 */
public class FooterView extends FrameLayout{
    private static final int STATE_LOADING = 0;
    private static final int STATE_COMPLETE = 1;
    private static final int STATE_ERROR = 2;

    private int state = STATE_LOADING;

    @BindView(R.id.progressBar)ProgressBar progressBar;
    @BindView(R.id.tv_error)TextView tvError;

    public FooterView(Context context) {
        this(context, null);
    }

    public FooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_load_footer, this, true);
        ButterKnife.bind(this);
    }

    /** 是否正在加载中*/
    public boolean isLoading(){
        return state == STATE_LOADING;
    }
    /** 是否加载完成(没有更多数据)*/
    public boolean isComplete(){
        return state == STATE_COMPLETE;
    }

    /** 显示加载中*/
    public void showLoading(){
        state = STATE_LOADING;
        progressBar.setVisibility(View.VISIBLE);
        tvError.setVisibility(View.GONE);
    }

    /** 显示没有更多数据*/
    public void showError(String erroMsg){
        state = STATE_ERROR;
        tvError.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    public void setErrorClickListener(OnClickListener onClickListener){
        tvError.setOnClickListener(onClickListener);
    }
}
