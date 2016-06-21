package cn.xm.xmvideoplayer.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import cn.xm.xmvideoplayer.R;
import cn.xm.xmvideoplayer.core.BaseCompatActivity;
import cn.xm.xmvideoplayer.ui.fragment.fra_home;
import cn.xm.xmvideoplayer.ui.fragment.fra_list;
import cn.xm.xmvideoplayer.ui.fragment.fra_local;
import cn.xm.xmvideoplayer.ui.fragment.fra_setting;

public class act_home extends BaseCompatActivity {

    @Bind((R.id.rg_homebar))
    RadioGroup rgHomebar;

    private List<Fragment> listFra = new ArrayList<>();

    private static int currentindex = 0;

    @Override
    public int getLayoutId() {
        return R.layout.act_home;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        //初始化Fra
        initFra();
        //初始化rg
        initrg();
/*
        RRVideoService.builder().RRVideoApi().getHotWord()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HotWordBean>() {
                    @Override
                    public void call(HotWordBean hotWordBean) {
                        Log.e("hotWordBean", hotWordBean.getData().toString());
                    }
                });*/
    }

    /**
     * 初始化fra
     */
    private void initFra() {
        listFra.add(new fra_home());
        listFra.add(new fra_list());
        listFra.add(new fra_local());
        listFra.add(new fra_setting());
    }

    /**
     * 初始化rg
     */
    private void initrg() {
        //设置切换
        rgHomebar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_homebar_home:
                        switchFragment(R.id.fra_content, listFra.get(currentindex), listFra.get(0));
                        currentindex = 0;
                        break;
                    case R.id.rb_homebar_list:
                        switchFragment(R.id.fra_content, listFra.get(currentindex), listFra.get(1));
                        currentindex = 1;
                        break;
                    case R.id.rb_homebar_local:
                        switchFragment(R.id.fra_content, listFra.get(currentindex), listFra.get(2));
                        currentindex = 2;
                        break;
                    case R.id.rb_homebar_setting:
                        switchFragment(R.id.fra_content, listFra.get(currentindex), listFra.get(3));
                        currentindex = 3;
                        break;
                }
            }
        });
        //

    }

    @Override
    protected void onStart() {
        super.onStart();
        rgHomebar.check(R.id.rb_homebar_home);
        showFragment(R.id.fra_content, listFra.get(0));
    }

    @Override
    public void initToolBar() {

    }

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
