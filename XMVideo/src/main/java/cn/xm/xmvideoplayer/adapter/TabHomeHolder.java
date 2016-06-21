package cn.xm.xmvideoplayer.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import cn.xm.xmvideoplayer.R;
import cn.xm.xmvideoplayer.entity.SeasonQueryBean;

/**
 * Created by gaohailong on 2016/5/17.
 */
public class TabHomeHolder extends BaseViewHolder<SeasonQueryBean.DataBean.ResultsBean> {

    private ImageView iv_bg;
    private TextView tv_title;
    private TextView tv_title2;

    public TabHomeHolder(ViewGroup parent) {
        super(parent, R.layout.item_tabhome);
        iv_bg = $(R.id.iv_bg);
        tv_title = $(R.id.tv_title);
        tv_title2 = $(R.id.tv_title2);
    }

    @Override
    public void setData(SeasonQueryBean.DataBean.ResultsBean data) {
        super.setData(data);
        //
        Glide.with(getContext())
                .load(data.getVerticalUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .into(iv_bg);
        tv_title.setText(data.getTitle());
        tv_title2.setText("更新至第"+data.getUpInfo()+"集");

    }

}
