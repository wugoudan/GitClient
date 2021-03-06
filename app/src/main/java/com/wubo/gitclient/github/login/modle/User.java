package com.wubo.gitclient.github.login.modle;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 个人用户信息响应结果
 * Created by wulog on 2016/8/18.
 */
public class User implements Serializable{
    // 登录所用的账号
    private String login;
    // 用户名
    private String name;
    // id
    private int id;

    // 用户头像路径
    @SerializedName("avatar_url")
    private String avatar;

    // 用户仓库路径
    @SerializedName("repos_url")
    private String repos;

    // 用户追随者路径
    @SerializedName("followers_url")
    private String followers;

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getRepos() {
        return repos;
    }

    public String getFollowers() {
        return followers;
    }
}
