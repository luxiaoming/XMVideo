package cn.xm.xmvideoplayer.ui.activity;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.xm.xmvideoplayer.R;
import cn.xm.xmvideoplayer.adapter.SeasonDetailAdapter;
import cn.xm.xmvideoplayer.constant.IntenConstant;
import cn.xm.xmvideoplayer.constant.VideoConstant;
import cn.xm.xmvideoplayer.core.BaseSwipeBackActivity;
import cn.xm.xmvideoplayer.data.api.RRVideoService;
import cn.xm.xmvideoplayer.entity.SeasonDetailBean;
import cn.xm.xmvideoplayer.entity.SeasonDetailBean.DataBean.SeasonBean;
import cn.xm.xmvideoplayer.entity.VideoUrlBean;
import cn.xm.xmvideoplayer.utils.DensityUtil;
import cn.xm.xmvideoplayer.widget.PLVideoTextureActivity;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 电视剧详情
 */
public class act_seasondetail extends BaseSwipeBackActivity {


    @Bind(R.id.detail_image)
    ImageView detailImage;

    @Bind(R.id.toolbar)
    Toolbar mtoolbar;

    @Bind(R.id.coll_toolbar_layout)
    CollapsingToolbarLayout mcollToolbarLayout;
    @Bind(R.id.recycler_view)
    EasyRecyclerView mrecyclerView;
    /**
     * 解码方式 0软解 1硬解
     */
    private int mIsHwCodecEnabled = 0;
    private ActionBar mActionBar;

    private SeasonDetailAdapter mAdapter;
    private Subscription subscribe;

    private String seasonid;
    private Subscription subscribepath;
    private TextView tv_playcount;
    private TextView tv_score;
    private TextView tv_content;

    @Override
    public int getLayoutId() {
        return R.layout.act_seasondetail;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

        seasonid = getIntent().getStringExtra(IntenConstant.seasonid);

        //toolbar
        inittoolbar();
        //recycleview
        initrecycle();

        //getdata
        getDetaildata();

    }

    /**
     * 初始化recycle
     */
    private void initrecycle() {
        //
        mAdapter = new SeasonDetailAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        gridLayoutManager.setSpanSizeLookup(mAdapter.obtainGridSpanSizeLookUp(5));
        mrecyclerView.setLayoutManager(gridLayoutManager);
        //
        mAdapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                return initheadview();
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
        mrecyclerView.setAdapterWithProgress(mAdapter);
        mAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Snackbar.make(mrecyclerView, "相应条目点击", Snackbar.LENGTH_SHORT).show();
                playvideo(VideoConstant.quality, seasonid, mAdapter.getItem(position).getSid());
            }
        });
        //

    }

    /**
     * 播放视频
     */
    private void playvideo(String quality, String seasonId, String episodeSid) {
        //获取播放地址
        subscribepath = RRVideoService.builder().RRVideoApi()
                .getVideoUrl(quality, seasonId, episodeSid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<VideoUrlBean, VideoUrlBean.DataBean.M3u8Bean>() {
                    @Override
                    public VideoUrlBean.DataBean.M3u8Bean call(VideoUrlBean videoUrlBean) {
                        return videoUrlBean.getData().getM3u8();
                    }
                })
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        //
                        Snackbar.make(mrecyclerView, "获取播放链接ing", Snackbar.LENGTH_SHORT).show();
                    }
                })
                .subscribe(new Action1<VideoUrlBean.DataBean.M3u8Bean>() {
                    @Override
                    public void call(VideoUrlBean.DataBean.M3u8Bean data) {
                        //启动播放器
                        Intent intent = new Intent(act_seasondetail.this, PLVideoTextureActivity.class);
                        intent.putExtra("videoPath", data.getUrl());
                        intent.putExtra("mediaCodec", mIsHwCodecEnabled);
                        startActivity(intent);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Snackbar.make(mrecyclerView, "获取播放链接失败", Snackbar.LENGTH_SHORT).show();
                    }
                });
    }


    /**
     * 初始化toolbar
     */
    private void inittoolbar() {
        // 初始化ToolBar
        setSupportActionBar(mtoolbar);
        mActionBar = getSupportActionBar();
   /*     if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }*/
        //返回键
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
//        upArrow.setColorFilter(getResources().getColor(R.color.black_90), PorterDuff.Mode.SRC_ATOP);
        mtoolbar.setNavigationIcon(upArrow);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    /*    //设置title颜色
        //mcollToolbarLayout.setTitle("title");
        mcollToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.black_90));
        mcollToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.black_90));
        mtoolbar.setTitleTextColor(getResources().getColor(R.color.black_90));*/
        mcollToolbarLayout.setExpandedTitleMarginEnd(DensityUtil.dip2px(this, 12.0f));
        mcollToolbarLayout.setExpandedTitleMarginStart(DensityUtil.dip2px(this, 12.0f));

    }

    /**
     * 获取网络数据
     */
    private void getDetaildata() {
        if ("".equals(seasonid) || seasonid.length() == 0) {
            return;
        }
        //请求网络
        subscribe = RRVideoService.builder().RRVideoApi()
                .getSeasonDetail(seasonid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<SeasonDetailBean, SeasonBean>() {
                    @Override
                    public SeasonBean call(SeasonDetailBean seasonDetailBean) {
                        return seasonDetailBean.getData().getSeason();
                    }
                })
                .subscribe(new Subscriber<SeasonBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Snackbar.make(mrecyclerView, "网络异常", Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(SeasonBean data) {
                        updataview(data);
                    }
                });

    }

    /**
     * 更新view
     *
     * @param data
     */
    private void updataview(final SeasonBean data) {
        //list排序
        Comparator<SeasonBean.EpisodeBriefBean> comparable = new Comparator<SeasonBean.EpisodeBriefBean>() {

            @Override
            public int compare(SeasonBean.EpisodeBriefBean data1, SeasonBean.EpisodeBriefBean data2) {
                return -(Integer.parseInt(data1.getEpisode()) - Integer.parseInt(data2.getEpisode()));
            }
        };
        List<SeasonBean.EpisodeBriefBean> playUrlList = data.getEpisode_brief();
        Collections.sort(playUrlList, comparable);
        //header
        updateheaer(data.getViewCount() + "", data.getScore() + "", data.getBrief());
        mAdapter.addAll(playUrlList);

        //
        mcollToolbarLayout.setTitle(data.getTitle());
        Glide.with(this).load(data.getCover()).centerCrop().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(detailImage);
    }

    /**
     * 初始化headerview
     *
     * @return
     */
    private View initheadview() {
        View view = getLayoutInflater().inflate(R.layout.item_seasonlist_header, null);
        tv_playcount = ButterKnife.findById(view, R.id.tv_playcount);
        tv_score = ButterKnife.findById(view, R.id.tv_score);
        tv_content = ButterKnife.findById(view, R.id.tv_content);

        return view;
    }

    /**
     * 更新headerview数据
     *
     * @param playcount
     * @param score
     * @param content
     */
    private void updateheaer(String playcount, String score, String content) {
        if (content.length() == 0) {
            content = "暂时没有简介哦~~";
        }
        tv_content.setText(content);
        tv_score.setText("评分：" + score);
        tv_playcount.setText("播放量:" + playcount);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_history:
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscribe != null) {
            subscribe.unsubscribe();
        }
        if (subscribepath != null) {
            subscribepath.unsubscribe();
        }
    }
}
