package cn.xm.xmvideoplayer.data.api;

import android.test.InstrumentationTestCase;
import android.util.Log;

import org.junit.Test;

import cn.xm.xmvideoplayer.entity.HotWordBean;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者：ximencx on 2016/6/13 17:56
 * 邮箱：454366460@qq.com
 */
public class RRVideoModuleTest extends InstrumentationTestCase{


    @Test
    public void testGetRRVideoApi() throws Exception {
        //
        RRVideoService.builder().RRVideoApi().getHotWord()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HotWordBean>() {
                    @Override
                    public void call(HotWordBean hotWordBean) {
                        Log.d("hotWordBean", hotWordBean.getData().toString());
                    }
                });
    }
}