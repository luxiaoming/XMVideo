package cn.xm.xmvideoplayer.data.api;

import cn.xm.xmvideoplayer.entity.HotWordBean;
import cn.xm.xmvideoplayer.entity.SearchBean;
import cn.xm.xmvideoplayer.entity.SeasonDetailBean;
import cn.xm.xmvideoplayer.entity.SeasonIndexBean;
import cn.xm.xmvideoplayer.entity.SeasonQueryBean;
import cn.xm.xmvideoplayer.entity.VideoUrlBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 作者：ximencx on 2016/6/13 16:14
 * 邮箱：454366460@qq.com
 * 网络接口api
 */
public interface RRVideoApi {

    /**
     * 获取英美剧首页索引
     *
     * @param clientVersion 3.0.2
     * @return SeasonIndexBean对象
     */
    @POST("season/index")
    Observable<SeasonIndexBean> getSeasonIndex(@Header("clientVersion") String clientVersion);

    /**
     * 获取分类列表
     *
     * @param cat      类型  全部为空 喜剧科幻 恐怖 剧情 魔幻 罪案 冒险 动作 悬疑
     * @param rows     12 每页行数
     * @param page     1 页数
     * @param sort     筛选 最热heat 评分score 时间为空
     * @param isFinish 状态 全部为空 false连载中 true已完结
     * @return SeasonQueryBean对象
     */
    @FormUrlEncoded
    @POST("season/query")
    Observable<SeasonQueryBean> getSeasonQuery(@Field("cat") String cat, @Field("rows") String rows, @Field("page") String page, @Field("sort") String sort, @Field("isFinish") String isFinish);

    /**
     * 获取热门关键词
     *
     * @return HotWordBean对象
     */
    @POST("video/hotWord")
    Observable<HotWordBean> getHotWord();

    /**
     * 获取搜索结果
     *
     * @param name 搜索关键词
     * @param rows 行数
     * @param page 页数
     * @return SearchBean对象
     */
    @FormUrlEncoded
    @POST("season/search")
    Observable<SearchBean> getSearch(@Field("name") String name, @Field("rows") int rows, @Field("page") int page);

    /**
     * 获取电视剧详情
     *
     * @param seasonId 电视剧id
     * @return SeasonDetailBean对象
     */
    @FormUrlEncoded
    @POST("season/detail")
    Observable<SeasonDetailBean> getSeasonDetail(@Field("seasonId") String seasonId);

    /**
     * 获取视频播放地址
     *
     * @param quality    画质 high高清
     * @param seasonId   电视剧id
     * @param episodeSid 电视剧分集id
     * @return
     */
    @FormUrlEncoded
    @POST("video/findM3u8ByEpisodeSid")
    Observable<VideoUrlBean> getVideoUrl(@Field("quality") String quality, @Field("seasonId") String seasonId, @Field("episodeSid") String episodeSid);

}
