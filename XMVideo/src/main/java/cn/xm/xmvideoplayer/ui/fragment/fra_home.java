package cn.xm.xmvideoplayer.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.xm.xmvideoplayer.R;
import cn.xm.xmvideoplayer.adapter.TabHomePagerAdaper;
import cn.xm.xmvideoplayer.core.BaseFragment;
import cn.xm.xmvideoplayer.view.HomeRecycleView;

/**
 * homefra
 */
public class fra_home extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.ll_search)
    LinearLayout llSearch;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;

    private String mParam1;
    private String mParam2;

    private List<String> listTilte = new ArrayList<>();
    private List<View> listView = new ArrayList<>();
    private HomeRecycleView seasonbuild;


    public static fra_home newInstance(String param1, String param2) {
        fra_home fragment = new fra_home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //初始化menu
        setHasOptionsMenu(true);

    }


    @Override
    public int getLayoutId() {
        return R.layout.fra_home;
    }

    @Override
    public void initViews() {
        //toolsbar
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
 /*       toolbar.setTitleTextColor(getResources().getColor(R.color.black_90));
        //toolbar返回键
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.black_90), PorterDuff.Mode.SRC_ATOP);
        activity.getSupportActionBar().setHomeAsUpIndicator(upArrow);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        //viewpager
        listTilte.add("英美剧");
        listTilte.add("电影");
        listTilte.add("纪录片");
        seasonbuild = HomeRecycleView.Builder();
        listView.add(seasonbuild.createView(activity));

        listView.add(HomeRecycleView.Builder().createView(activity));
        listView.add(HomeRecycleView.Builder().createView(activity));

        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new TabHomePagerAdaper(listView, listTilte));

        //TabLayout
        tabLayout.setupWithViewPager(viewPager);

        //recyecleview
        //initRecycleView();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_history:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        seasonbuild.destroy();
        ButterKnife.unbind(this);
    }
}
