package com.wubo.gitclient.github.hotuser;

import com.google.gson.annotations.SerializedName;
import com.wubo.gitclient.github.login.modle.User;

import java.util.List;

;

/**
 * Created by wulog on 2016/8/18.
 */
public class HotUserResult {

    @SerializedName("total_count")
    private int totalCount;

    @SerializedName("incomplete_results")
    private boolean incompleteResults;

    @SerializedName("items")
    private List<User> userList;

    public int getTotalCount() {
        return totalCount;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public List<User> getRepoList() {
        return userList;
    }
    
//    "total_count": 603,
//            "incomplete_results": false,
//            "items": [
}
