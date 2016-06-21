package cn.xm.xmvideoplayer.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import cn.xm.xmvideoplayer.entity.SeasonDetailBean;

/**
 * Created by gaohailong on 2016/5/17.
 */
public class SeasonDetailAdapter extends RecyclerArrayAdapter<SeasonDetailBean.DataBean.SeasonBean.EpisodeBriefBean> {

    public SeasonDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new SeasonDetailHolder(parent,getAllData());
    }

}
