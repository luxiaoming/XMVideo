package cn.xm.xmvideoplayer.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 作者：ximencx on 2016/6/16 15:56
 * 邮箱：454366460@qq.com
 * tabhome的viewpager
 */
public class TabHomePagerAdaper extends PagerAdapter {
    private List<View> viewList;
    private List<String> titleList;

    public TabHomePagerAdaper(List<View> viewList, List<String> titleList) {
        this.viewList = viewList;
        this.titleList = titleList;
    }

    /**
     * 返回页卡的数量
     */
    @Override
    public int getCount() {

        return viewList.size();
    }

    /**
     * view是否来自对象
     */
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {

        return arg0 == arg1;
    }

    /**
     * 实例化一个页卡
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    /**
     * 销毁一个页卡
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(viewList.get(position));

    }

    /**
     * 设置ViewPager的标题
     */
    @Override
    public CharSequence getPageTitle(int position) {

        return titleList.get(position);
    }
}
