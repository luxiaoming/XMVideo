package cn.xm.xmvideoplayer.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import cn.xm.xmvideoplayer.entity.SeasonQueryBean;

/**
 * Created by gaohailong on 2016/5/17.
 */
public class TabHomeAdapter extends RecyclerArrayAdapter<SeasonQueryBean.DataBean.ResultsBean> {

    public TabHomeAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new TabHomeHolder(parent);
    }

}
