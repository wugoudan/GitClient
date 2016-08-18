package com.wubo.gitclient.github.hotrepo.repolist.view;


import com.wubo.gitclient.github.hotrepo.repolist.modle.Repo;

import java.util.List;

/**
 * Created by wulog on 2016/8/18.
 */
public interface RepoListPtrView {
    /** 显示下拉刷新时的内容视图*/
    void showContentView();
    /** 显示下拉刷新时的错误视图*/
    void showErrorView(String errorMsg);
    /** 显示下拉刷新时的空视图*/
    void showEmptyView();
    void showMessage(String msg);
    void stopRefresh();
    void refreshData(List<Repo> data);
}
