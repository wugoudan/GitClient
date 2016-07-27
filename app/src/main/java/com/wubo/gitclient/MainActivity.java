package com.wubo.gitclient;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.wubo.gitclient.commons.ActivityUtils;
import com.wubo.gitclient.hot.HotMainFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.container) FrameLayout mContainer;
    @BindView(R.id.navigationView) NavigationView mNavigationView;
    @BindView(R.id.drawerLayout) DrawerLayout mDrawerLayout;

    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityUtils = new ActivityUtils(this);
        ButterKnife.bind(this);
        initToolBarAndDrawerLayout();
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        replaceFrament(new HotMainFragment());
    }

    /**替换主页面Fragment*/
    private void replaceFrament(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container,fragment);
        transaction.commit();
    }

    /**初始化ToolBar&DrawerLayout*/
    private void initToolBarAndDrawerLayout() {
        this.setSupportActionBar(mToolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.drawerOpen,
                R.string.DrawerClose);
        drawerToggle.syncState();
        mDrawerLayout.addDrawerListener(drawerToggle);
        mNavigationView.setNavigationItemSelectedListener(navigationItemListener);
    }

    //NavigationItem点击事件
    private NavigationView.OnNavigationItemSelectedListener navigationItemListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.github_hot_repo:
                    activityUtils.showToast("github_hot_repo");
                    break;
                case R.id.github_hot_coder:
                    activityUtils.showToast("github_hot_coder");
                    break;
                case R.id.github_trend:
                    activityUtils.showToast("github_trend");
                    break;
                //...
            }
            //此处返回true代表点击Item时选中Item项
            return true;
        }
    };


    @Override
    /**点击返回键时，是打开/关闭抽屉菜单*/
    public void onBackPressed() {
//        super.onBackPressed();
        if(mDrawerLayout.isDrawerOpen(Gravity.LEFT)){
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        }else{
            mDrawerLayout.openDrawer(Gravity.LEFT);
        }
    }


}
