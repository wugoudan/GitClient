package com.wubo.gitclient.hot.hotlist;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by WuBo_PC on 2016/7/27.
 *
 * 这是最热仓库木块MVP，View接口
 */

interface HotListView extends MvpView{
    //显示信息
    void showMessage(String msg);
    //显示加载错误页面
    void showErrorView();
    //显示加载内容为空页面
    void showEmptyView();
    //刷新完成
    void RefreshComplete();
    //设置数据
    void setDatas(Object obj);
}
