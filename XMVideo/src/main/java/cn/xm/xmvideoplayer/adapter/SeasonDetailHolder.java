package cn.xm.xmvideoplayer.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import cn.xm.xmvideoplayer.R;
import cn.xm.xmvideoplayer.entity.SeasonDetailBean;

/**
 * Created by gaohailong on 2016/5/17.
 */
public class SeasonDetailHolder extends BaseViewHolder<SeasonDetailBean.DataBean.SeasonBean.EpisodeBriefBean> {

    private TextView tv_title;
    private TextView tv_title2;
    private List<SeasonDetailBean.DataBean.SeasonBean.EpisodeBriefBean> list=new ArrayList<>();

    public SeasonDetailHolder(ViewGroup parent, List<SeasonDetailBean.DataBean.SeasonBean.EpisodeBriefBean> list) {
        super(parent, R.layout.item_seasonlist);
        tv_title = $(R.id.tv_title);
        tv_title2 = $(R.id.tv_title2);
        this.list=list;
    }

    @Override
    public void setData(SeasonDetailBean.DataBean.SeasonBean.EpisodeBriefBean data) {
        super.setData(data);
        //
        tv_title.setText((list.size()-getLayoutPosition()+1)+"");
        if (getLayoutPosition() == 1) {
            tv_title2.setVisibility(View.VISIBLE);
        } else {
            tv_title2.setVisibility(View.INVISIBLE);
        }
    }

}
