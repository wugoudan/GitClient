package com.wubo.gitclient.github;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.wubo.gitclient.R;
import com.wubo.gitclient.commons.ActivityUtils;
import com.wubo.gitclient.favorite.FavoriteFragment;
import com.wubo.gitclient.gank.GankFragment;
import com.wubo.gitclient.github.hotrepo.HotRepoFragment;
import com.wubo.gitclient.github.hotuser.HotUserFragment;
import com.wubo.gitclient.github.login.LoginActivity;
import com.wubo.gitclient.github.login.UserRepo;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wulog on 2016/8/18.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawerLayout) DrawerLayout drawerLayout; // 抽屉(包含内容+侧滑菜单)
    @BindView(R.id.navigationView) NavigationView navigationView; // 侧滑菜单视图

    // 热门仓库Fragment
    private HotRepoFragment hotRepoFragment;
    private HotUserFragment hotUserFragment;
    private FavoriteFragment favoriteFragment;
    private GankFragment gankFragment;

    private Button btnLogin;
    private ImageView ivIcon;

    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUtils = new ActivityUtils(this);
        // 设置当前视图(也就是说，更改了当前视图内容,将导至onContentChanged方法触发)
        setContentView(R.layout.activity_main);
    }

    @Override public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        // ActionBar处理
        setSupportActionBar(toolbar);
        // 设置navigationView的监听器
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(// 构建抽屉的监听
                this, drawerLayout, toolbar, R.string.drawerOpen, R.string.DrawerClose);
        toggle.syncState();// 根据drawerlayout同步其当前状态
        // 设置抽屉监听
        drawerLayout.addDrawerListener(toggle);
        btnLogin = ButterKnife.findById(navigationView.getHeaderView(0), R.id.btnLogin);
        ivIcon = ButterKnife.findById(navigationView.getHeaderView(0), R.id.ivIcon);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                activityUtils.startActivity(LoginActivity.class);
                finish();
            }
        });
        // 默认显示的是热门仓库fragment
        hotRepoFragment = new HotRepoFragment();
        replaceFragment(hotRepoFragment);
    }

    @Override protected void onStart() {
        super.onStart();
        // 没有授权的话
        if (UserRepo.isEmpty()) {
            btnLogin.setText(R.string.login_github);
            return;
        }
        btnLogin.setText(R.string.switch_account);
        // 设置Title
        getSupportActionBar().setTitle(UserRepo.getUser().getName());
        // 设置用户头像
        String photoUrl = UserRepo.getUser().getAvatar();
        ImageLoader.getInstance().displayImage(photoUrl, ivIcon);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    // 侧滑菜单监听器
    @Override public boolean onNavigationItemSelected(MenuItem item) {
        // 将默认选中项“手动”设置为false
        if (item.isChecked()) {
            item.setChecked(false);
        }
        // 根据选择做切换
        switch (item.getItemId()) {
            // 热门仓库
            case R.id.github_hot_repo:
                if (!hotRepoFragment.isAdded()) {
                    replaceFragment(hotRepoFragment);
                }
                break;
            // 热门开发者
            case R.id.github_hot_coder:
                if (hotUserFragment == null) hotUserFragment = new HotUserFragment();
                if (!hotUserFragment.isAdded()) {
                    replaceFragment(hotUserFragment);
                }
                break;
            // 我的收藏
            case R.id.arsenal_my_repo:
                if(favoriteFragment == null)favoriteFragment = new FavoriteFragment();
                if(!favoriteFragment.isAdded()){
                    replaceFragment(favoriteFragment);
                }
                break;
            // 每日干货
            case R.id.tips_daily:
                if(gankFragment == null)gankFragment = new GankFragment();
                if(!gankFragment.isAdded()){
                    replaceFragment(gankFragment);
                }
                break;
        }
        // 关闭drawerLayout
        drawerLayout.post(new Runnable() {
            @Override public void run() {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        // 返回true，代表将该菜单项变为checked状态
        return true;
    }
}