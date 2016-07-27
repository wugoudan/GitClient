package com.wubo.gitclient.hot.hotlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.wubo.gitclient.R;
import com.wubo.gitclient.commons.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

/**
 * Created by WuBo_PC on 2016/7/27.
 */

public class HotListFrament extends MvpFragment<HotListView,HotListParesenter> implements HotListView {

    @BindView(R.id.lvRepos) ListView mLRepos;
    @BindView(R.id.ptrClassicFrameLayout)
    PtrClassicFrameLayout mPtrClassicFrameLayout;
    @BindView(R.id.emptyView) TextView mEmptyView;
    @BindView(R.id.errorView) TextView mErrorView;

    private ActivityUtils activityUtils;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repo_list, container, false);
        activityUtils = new ActivityUtils(this);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPtrClassicFrameLayout();
    }

    /**初始化下拉刷新组建*/
    private void initPtrClassicFrameLayout() {
        //以下是设置下拉刷新Header样式
        StoreHouseHeader header = new StoreHouseHeader(getContext());
        header.setPadding(0,60,0,60);
        header.initWithString("JAVA");
        mPtrClassicFrameLayout.setHeaderView(header);
        mPtrClassicFrameLayout.addPtrUIHandler(header);
        mPtrClassicFrameLayout.setBackgroundResource(R.color.colorPrimaryDark);
        //下拉刷新监听
        mPtrClassicFrameLayout.setPtrHandler(ptrHandlerListener);
        //设置刷新时间为3000毫秒
        mPtrClassicFrameLayout.setDurationToCloseHeader(3000);
        //设置使用当前对象为Key，记录下一次刷新间隔，如果间隔太短不会出发监听
        mPtrClassicFrameLayout.setLastUpdateTimeRelateObject(this);
    }
    private PtrHandler ptrHandlerListener = new PtrDefaultHandler() {
        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            getPresenter().loadList();
        }
    };

    @Override
    public HotListParesenter createPresenter() {
        return new HotListParesenter();
    }

    @Override
    public void showMessage(String msg) {
        activityUtils.showToast(msg);
    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void RefreshComplete() {
        mPtrClassicFrameLayout.refreshComplete();
    }

    @Override
    public void setDatas(Object obj) {
        
    }
}
