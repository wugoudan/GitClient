package com.wubo.gitclient.hot.hotlist;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

/**
 * Created by WuBo_PC on 2016/7/27.
 */

public class HotListParesenter extends MvpNullObjectBasePresenter<HotListView>{

    public void loadList(){
        // TODO: 2016/7/27 这里需要执行网络操作
        //这是测试
        getView().showMessage("正在加载数据");
        getView().RefreshComplete();
    }

}
