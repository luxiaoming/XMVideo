package cn.xm.xmvideoplayer.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.ButterKnife;
import cn.xm.xmvideoplayer.R;
import cn.xm.xmvideoplayer.adapter.TabHomeAdapter;
import cn.xm.xmvideoplayer.constant.IntenConstant;
import cn.xm.xmvideoplayer.data.api.RRVideoService;
import cn.xm.xmvideoplayer.entity.SeasonQueryBean;
import cn.xm.xmvideoplayer.ui.activity.act_seasondetail;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 作者：ximencx on 2016/6/16 16:16
 * 邮箱：454366460@qq.com
 */
public class HomeRecycleView implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    private Handler handler = new Handler();
    private TabHomeAdapter mAdapter;

    /**
     * 当前页数
     */
    private int currentpage = 1;

    private Subscription subscribe;

    public static HomeRecycleView Builder() {
        return new HomeRecycleView();
    }

    /**
     * 初始化Recycleview
     */
    public EasyRecyclerView createView(final Activity activity) {

        mAdapter = new TabHomeAdapter(activity);

        final View view = activity.getLayoutInflater().inflate(R.layout.incd_content_recycleview, null);
        EasyRecyclerView mrecyclerView = ButterKnife.findById(view, R.id.recycler_view);
        //
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 3);
        gridLayoutManager.setSpanSizeLookup(mAdapter.obtainGridSpanSizeLookUp(3));
        mrecyclerView.setLayoutManager(gridLayoutManager);
        mrecyclerView.setAdapterWithProgress(mAdapter);
        //
        mAdapter.setMore(R.layout.load_more_layout, this);
        mAdapter.setNoMore(R.layout.no_more_layout);
        mAdapter.setError(R.layout.error_layout);
        mAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //跳转到电视剧
                Intent intent = new Intent(activity,act_seasondetail.class);
                intent.putExtra(IntenConstant.seasonid, mAdapter.getItem(position).getId()+"");
                activity.startActivity(intent);
            }
        });

        mrecyclerView.setRefreshListener(this);
        onRefresh();
        return mrecyclerView;
    }

    /**
     * 请求网络数据
     *
     * @param cat
     * @param rows
     * @param page
     * @param sort
     * @param isfinish
     */
    private void getData(final boolean isclear, String cat, String rows, String page, String sort, String isfinish) {
        //
        //noWIFILayout.setVisibility(View.VISIBLE);
        //Snackbar.make(getView(), "NO WIFI，不能愉快的看视频啦..", Snackbar.LENGTH_LONG).show();
        subscribe = RRVideoService.builder().RRVideoApi().getSeasonQuery(cat, rows, page, sort, isfinish)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<SeasonQueryBean, SeasonQueryBean.DataBean>() {
                    @Override
                    public SeasonQueryBean.DataBean call(SeasonQueryBean seasonQueryBean) {
                        return seasonQueryBean.getData();
                    }
                })
                .subscribe(new Subscriber<SeasonQueryBean.DataBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //noWIFILayout.setVisibility(View.VISIBLE);
                        //Snackbar.make(getView(), "NO WIFI，不能愉快的看视频啦..", Snackbar.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(SeasonQueryBean.DataBean DataBean) {
                        if (isclear) {
                            mAdapter.clear();
                        }
                        mAdapter.addAll(DataBean.getResults());
                    }
                });
    }

    @Override
    public void onLoadMore() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                currentpage++;
                getData(false, "", "12", currentpage + "", "heat", "");
            }
        });
    }

    @Override
    public void onRefresh() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                getData(true, "", "12", "1", "heat", "");
            }
        });
    }

    public void destroy() {
        subscribe.unsubscribe();
    }
}
