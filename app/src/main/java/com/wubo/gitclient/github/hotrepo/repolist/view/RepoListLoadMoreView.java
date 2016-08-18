package com.wubo.gitclient.github.hotrepo.repolist.view;


import com.wubo.gitclient.github.hotrepo.repolist.modle.Repo;

import java.util.List;

/**
 * 加载更多的视图抽象
 /**
 * Created by wulog on 2016/8/18.
 */
public interface RepoListLoadMoreView {
    /** 在开始loadMore业务时，将触发，用来显示上拉加载时的加载中视图*/
    void showLoadMoreLoading();

    /** 在结束loadMore业务时，将触发，隐藏上拉加载时的加载中视图*/
    void hideLoadMoreLoading();

    /** 显示上拉加载时的错误视图*/
    void showLoadMoreErro(String erroMsg);

    /** 数据添加到视图*/
    void addMoreData(List<Repo> datas);
}