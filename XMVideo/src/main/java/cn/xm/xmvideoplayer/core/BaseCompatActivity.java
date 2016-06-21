package cn.xm.xmvideoplayer.core;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import cn.xm.xmvideoplayer.utils.StatusBarCompat;

/**
 * 作者：ximencx on 2016/6/12 20:58
 * 邮箱：454366460@qq.com
 */
public abstract class BaseCompatActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架
       ButterKnife.bind(this);
        //适配4.4状态栏
        StatusBarCompat.compat(this);
        //初始化控件
        initViews(savedInstanceState);
        //初始化ToolBar
        initToolBar();

    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    public abstract int getLayoutId();

    public abstract void initViews(Bundle savedInstanceState);

    public abstract void initToolBar();
}
