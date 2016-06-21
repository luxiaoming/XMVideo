package cn.xm.xmvideoplayer.core;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;
import cn.xm.xmvideoplayer.utils.StatusBarCompat;

/**
 * 作者：ximencx on 2016/6/12 20:58
 * 邮箱：454366460@qq.com
 */
public abstract class BaseFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架
        ButterKnife.bind(BaseFragmentActivity.this);
        //适配4.4状态栏
        StatusBarCompat.compat(this);
        //初始化控件
        initViews(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    /**
     * 获得layout
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * oncreat中初始化
     *
     * @param savedInstanceState
     */
    public abstract void initViews(Bundle savedInstanceState);


    /**
     * 强制刷新Fragment
     *
     * @param containerViewId
     * @param fragment
     */
    public void showFragment(int containerViewId, Fragment fragment) {
        getFragmentManager().beginTransaction().replace(containerViewId, fragment).commit();
    }

    /**
     * 切换Fragment
     *
     * @param containerViewId
     * @param from
     * @param to
     */
    public void switchFragment(int containerViewId, Fragment from, Fragment to) {
        if (from == to) {
            return;
        }
        FragmentTransaction trx = getFragmentManager().beginTransaction();
        if (from.isAdded()) {
            trx.hide(from);
        }
        if (!to.isAdded()) {
            trx.add(containerViewId, to);
        }
        trx.show(to).commit();
    }
}
