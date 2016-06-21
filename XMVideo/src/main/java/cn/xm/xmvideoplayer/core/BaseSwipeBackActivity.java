package cn.xm.xmvideoplayer.core;

import android.os.Bundle;

import butterknife.ButterKnife;
import cn.xm.xmvideoplayer.widget.swipebacklayout.SwipeBackActivity;
import cn.xm.xmvideoplayer.widget.swipebacklayout.SwipeBackLayout;

/**
 * Created by 11 on 2016/4/1.
 * <p/>
 * 侧滑返回Activity基类
 */
public abstract class BaseSwipeBackActivity extends SwipeBackActivity {

    public SwipeBackLayout mSwipeBackLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架
       ButterKnife.bind(this);
        //初始化侧滑返回layout
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        //初始化控件
        initViews(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();

    }

    public abstract int getLayoutId();

    public abstract void initViews(Bundle savedInstanceState);
}
