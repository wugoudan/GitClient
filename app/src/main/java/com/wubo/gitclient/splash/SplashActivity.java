package com.wubo.gitclient.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wubo.gitclient.MainActivity;
import com.wubo.gitclient.R;
import com.wubo.gitclient.commons.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {

//    @BindView(buttonBar)
    static LinearLayout mButtonBar;
    @BindView(R.id.btnEnter) Button mBtnEnter;

    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mButtonBar = (LinearLayout) findViewById(R.id.buttonBar);
        activityUtils = new ActivityUtils(this);
        ButterKnife.bind(this);
    }

    /**按钮点击事件*/
    @OnClick({R.id.btnEnter})
    public void click(View view){
        switch (view.getId()){
            case R.id.btnLogin:
                // TODO: 2016/7/27 这里执行登陆页跳转

                break;
            case R.id.btnEnter:
                activityUtils.startActivity(MainActivity.class);
                finish();
                break;
        }
    }

    /**设置ButtonBar背景颜色*/
    public static void setButtonBarColor(int bgColor){
        mButtonBar.setBackgroundColor(bgColor);
    }
}
