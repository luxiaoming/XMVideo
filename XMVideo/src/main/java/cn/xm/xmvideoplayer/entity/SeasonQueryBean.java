package cn.xm.xmvideoplayer.entity;

import java.util.List;

/**
 * 作者：ximencx on 2016/6/13 16:30
 * 邮箱：454366460@qq.com
 * 分类查询索引
 */
public class SeasonQueryBean {

    /**
     * code : 0000
     * msg :
     * data : {"total":1567,"results":[{"url":"http://img.rrmj.tv/video/20160509/b_1462773571611.jpg","title":"行尸走肉 第六季 ","upInfo":16,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151019/b_1445245529315.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160509/b_1462773571611.jpg","id":503},{"url":"http://img.rrmj.tv/video/20160509/b_1462776834348.jpg","title":"闪电侠第二季","upInfo":23,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151009/b_1444392315235.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160509/b_1462776834348.jpg","id":465},{"url":"http://img.rrmj.tv/video/20160504/b_1462357077939.jpg","title":"神盾局特工第三季","upInfo":22,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151009/b_1444392000381.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160504/b_1462357077939.jpg","id":464},{"url":"http://img.rrmj.tv/video/20160509/b_1462777619270.jpg","title":"吸血鬼日记第七季","upInfo":22,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151016/b_1445007273500.png","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160509/b_1462777619270.jpg","id":522},{"url":"http://img.rrmj.tv/video/20160509/b_1462776027275.jpg","title":"破产姐妹第五季","upInfo":22,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151114/b_1447476652263.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160509/b_1462776027275.jpg","id":577},{"url":"http://img.rrmj.tv/video/20160418/b_1460957477680.jpg","title":"生活大爆炸 第九季","upInfo":24,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151021/b_1445398219118.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160418/b_1460957477680.jpg","id":531},{"url":"http://img.rrmj.tv/video/20160425/b_1461578087942.jpg","title":"国务卿女士 第二季","upInfo":23,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151013/b_1444733789979.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160425/b_1461578087942.jpg","id":512},{"url":"http://img.rrmj.tv/season/20160512/b_1463041379096.jpg","title":"绿箭侠 第四季 ","upInfo":23,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151012/b_1444635408191.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/season/20160512/b_1463041379096.jpg","id":493},{"url":"http://img.rrmj.tv/season/20160531/b_1464674120078.jpg","title":"始祖家族 第三季","upInfo":22,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151012/b_1444618405313.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/season/20160531/b_1464674120078.jpg","id":491},{"url":"http://img.rrmj.tv/season/20160512/b_1463017417839.jpg","title":"僵尸国度 第二季","upInfo":15,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151010/b_1444458722467.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/season/20160512/b_1463017417839.jpg","id":477},{"url":"http://img.rrmj.tv/season/20160512/b_1463035217484.jpg","title":"明日传奇 第一季","upInfo":16,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20160122/b_1453477005412.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/season/20160512/b_1463035217484.jpg","id":1109},{"url":"http://img.rrmj.tv/video/20160420/b_1461130472888.png","title":"人人预告","upInfo":56,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20160108/b_1452235935748.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160420/b_1461130472888.png","id":720}],"currentPage":1}
     */

    private String code;
    private String msg;
    /**
     * total : 1567
     * results : [{"url":"http://img.rrmj.tv/video/20160509/b_1462773571611.jpg","title":"行尸走肉 第六季 ","upInfo":16,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151019/b_1445245529315.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160509/b_1462773571611.jpg","id":503},{"url":"http://img.rrmj.tv/video/20160509/b_1462776834348.jpg","title":"闪电侠第二季","upInfo":23,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151009/b_1444392315235.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160509/b_1462776834348.jpg","id":465},{"url":"http://img.rrmj.tv/video/20160504/b_1462357077939.jpg","title":"神盾局特工第三季","upInfo":22,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151009/b_1444392000381.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160504/b_1462357077939.jpg","id":464},{"url":"http://img.rrmj.tv/video/20160509/b_1462777619270.jpg","title":"吸血鬼日记第七季","upInfo":22,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151016/b_1445007273500.png","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160509/b_1462777619270.jpg","id":522},{"url":"http://img.rrmj.tv/video/20160509/b_1462776027275.jpg","title":"破产姐妹第五季","upInfo":22,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151114/b_1447476652263.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160509/b_1462776027275.jpg","id":577},{"url":"http://img.rrmj.tv/video/20160418/b_1460957477680.jpg","title":"生活大爆炸 第九季","upInfo":24,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151021/b_1445398219118.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160418/b_1460957477680.jpg","id":531},{"url":"http://img.rrmj.tv/video/20160425/b_1461578087942.jpg","title":"国务卿女士 第二季","upInfo":23,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151013/b_1444733789979.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160425/b_1461578087942.jpg","id":512},{"url":"http://img.rrmj.tv/season/20160512/b_1463041379096.jpg","title":"绿箭侠 第四季 ","upInfo":23,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151012/b_1444635408191.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/season/20160512/b_1463041379096.jpg","id":493},{"url":"http://img.rrmj.tv/season/20160531/b_1464674120078.jpg","title":"始祖家族 第三季","upInfo":22,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151012/b_1444618405313.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/season/20160531/b_1464674120078.jpg","id":491},{"url":"http://img.rrmj.tv/season/20160512/b_1463017417839.jpg","title":"僵尸国度 第二季","upInfo":15,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20151010/b_1444458722467.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/season/20160512/b_1463017417839.jpg","id":477},{"url":"http://img.rrmj.tv/season/20160512/b_1463035217484.jpg","title":"明日传奇 第一季","upInfo":16,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20160122/b_1453477005412.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/season/20160512/b_1463035217484.jpg","id":1109},{"url":"http://img.rrmj.tv/video/20160420/b_1461130472888.png","title":"人人预告","upInfo":56,"shortBrief":"","verticalUrl":"http://img.rrmj.tv/video/20160108/b_1452235935748.jpg","mark":"none","horizontalUrl":"http://img.rrmj.tv/video/20160420/b_1461130472888.png","id":720}]
     * currentPage : 1
     */

    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int total;
        private int currentPage;
        /**
         * url : http://img.rrmj.tv/video/20160509/b_1462773571611.jpg
         * title : 行尸走肉 第六季
         * upInfo : 16
         * shortBrief :
         * verticalUrl : http://img.rrmj.tv/video/20151019/b_1445245529315.jpg
         * mark : none
         * horizontalUrl : http://img.rrmj.tv/video/20160509/b_1462773571611.jpg
         * id : 503
         */

        private List<ResultsBean> results;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            private String url;
            private String title;
            private int upInfo;
            private String shortBrief;
            private String verticalUrl;
            private String mark;
            private String horizontalUrl;
            private int id;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpInfo() {
                return upInfo;
            }

            public void setUpInfo(int upInfo) {
                this.upInfo = upInfo;
            }

            public String getShortBrief() {
                return shortBrief;
            }

            public void setShortBrief(String shortBrief) {
                this.shortBrief = shortBrief;
            }

            public String getVerticalUrl() {
                return verticalUrl;
            }

            public void setVerticalUrl(String verticalUrl) {
                this.verticalUrl = verticalUrl;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public String getHorizontalUrl() {
                return horizontalUrl;
            }

            public void setHorizontalUrl(String horizontalUrl) {
                this.horizontalUrl = horizontalUrl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
