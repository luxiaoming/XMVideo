package cn.xm.xmvideoplayer.entity;

import java.util.List;

/**
 * 作者：ximencx on 2016/6/13 16:56
 * 邮箱：454366460@qq.com
 * 获取播放地址
 */
public class VideoUrlBean {

    /**
     * code : 0000
     * msg :
     * data : {"account":{"plat":"","accountName":"","password":""},"m3u8":{"url":"http://api1.rrmj.tv/test/baidu/ac.php?vid=CMzM2NDI1Ng==&tss=1&format=hd&t=1465807953837&sign=NDZhMjFiMDJlZjQwZmFkODBmNDY4NDY4ZGZiMjI4MDc3ZTFiYjczOA%3D%3D","currentQuality":"high","qualityArr":["low","high","super"]},"episodeList":[{"sid":"22177","site":null,"text":null,"episodeNo":1,"id":22177},{"sid":"22178","site":null,"text":null,"episodeNo":2,"id":22178},{"sid":"22179","site":null,"text":null,"episodeNo":3,"id":22179},{"sid":"22180","site":null,"text":null,"episodeNo":4,"id":22180},{"sid":"22181","site":null,"text":null,"episodeNo":5,"id":22181},{"sid":"22182","site":null,"text":null,"episodeNo":6,"id":22182},{"sid":"22183","site":null,"text":null,"episodeNo":7,"id":22183},{"sid":"22184","site":null,"text":null,"episodeNo":8,"id":22184},{"sid":"22185","site":null,"text":null,"episodeNo":9,"id":22185},{"sid":"22186","site":null,"text":null,"episodeNo":10,"id":22186},{"sid":"22191","site":null,"text":"","episodeNo":11,"id":22191},{"sid":"22192","site":null,"text":"","episodeNo":12,"id":22192},{"sid":"22187","site":null,"text":null,"episodeNo":13,"id":22187},{"sid":"22188","site":null,"text":null,"episodeNo":14,"id":22188},{"sid":"22189","site":null,"text":null,"episodeNo":15,"id":22189},{"sid":"22190","site":null,"text":null,"episodeNo":16,"id":22190}]}
     */

    private String code;
    private String msg;
    /**
     * account : {"plat":"","accountName":"","password":""}
     * m3u8 : {"url":"http://api1.rrmj.tv/test/baidu/ac.php?vid=CMzM2NDI1Ng==&tss=1&format=hd&t=1465807953837&sign=NDZhMjFiMDJlZjQwZmFkODBmNDY4NDY4ZGZiMjI4MDc3ZTFiYjczOA%3D%3D","currentQuality":"high","qualityArr":["low","high","super"]}
     * episodeList : [{"sid":"22177","site":null,"text":null,"episodeNo":1,"id":22177},{"sid":"22178","site":null,"text":null,"episodeNo":2,"id":22178},{"sid":"22179","site":null,"text":null,"episodeNo":3,"id":22179},{"sid":"22180","site":null,"text":null,"episodeNo":4,"id":22180},{"sid":"22181","site":null,"text":null,"episodeNo":5,"id":22181},{"sid":"22182","site":null,"text":null,"episodeNo":6,"id":22182},{"sid":"22183","site":null,"text":null,"episodeNo":7,"id":22183},{"sid":"22184","site":null,"text":null,"episodeNo":8,"id":22184},{"sid":"22185","site":null,"text":null,"episodeNo":9,"id":22185},{"sid":"22186","site":null,"text":null,"episodeNo":10,"id":22186},{"sid":"22191","site":null,"text":"","episodeNo":11,"id":22191},{"sid":"22192","site":null,"text":"","episodeNo":12,"id":22192},{"sid":"22187","site":null,"text":null,"episodeNo":13,"id":22187},{"sid":"22188","site":null,"text":null,"episodeNo":14,"id":22188},{"sid":"22189","site":null,"text":null,"episodeNo":15,"id":22189},{"sid":"22190","site":null,"text":null,"episodeNo":16,"id":22190}]
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
        /**
         * plat :
         * accountName :
         * password :
         */

        private AccountBean account;
        /**
         * url : http://api1.rrmj.tv/test/baidu/ac.php?vid=CMzM2NDI1Ng==&tss=1&format=hd&t=1465807953837&sign=NDZhMjFiMDJlZjQwZmFkODBmNDY4NDY4ZGZiMjI4MDc3ZTFiYjczOA%3D%3D
         * currentQuality : high
         * qualityArr : ["low","high","super"]
         */

        private M3u8Bean m3u8;
        /**
         * sid : 22177
         * site : null
         * text : null
         * episodeNo : 1
         * id : 22177
         */

        private List<EpisodeListBean> episodeList;

        public AccountBean getAccount() {
            return account;
        }

        public void setAccount(AccountBean account) {
            this.account = account;
        }

        public M3u8Bean getM3u8() {
            return m3u8;
        }

        public void setM3u8(M3u8Bean m3u8) {
            this.m3u8 = m3u8;
        }

        public List<EpisodeListBean> getEpisodeList() {
            return episodeList;
        }

        public void setEpisodeList(List<EpisodeListBean> episodeList) {
            this.episodeList = episodeList;
        }

        public static class AccountBean {
            private String plat;
            private String accountName;
            private String password;

            public String getPlat() {
                return plat;
            }

            public void setPlat(String plat) {
                this.plat = plat;
            }

            public String getAccountName() {
                return accountName;
            }

            public void setAccountName(String accountName) {
                this.accountName = accountName;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }
        }

        public static class M3u8Bean {
            private String url;
            private String currentQuality;
            private List<String> qualityArr;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCurrentQuality() {
                return currentQuality;
            }

            public void setCurrentQuality(String currentQuality) {
                this.currentQuality = currentQuality;
            }

            public List<String> getQualityArr() {
                return qualityArr;
            }

            public void setQualityArr(List<String> qualityArr) {
                this.qualityArr = qualityArr;
            }
        }

        public static class EpisodeListBean {
            private String sid;
            private Object site;
            private Object text;
            private int episodeNo;
            private int id;

            public String getSid() {
                return sid;
            }

            public void setSid(String sid) {
                this.sid = sid;
            }

            public Object getSite() {
                return site;
            }

            public void setSite(Object site) {
                this.site = site;
            }

            public Object getText() {
                return text;
            }

            public void setText(Object text) {
                this.text = text;
            }

            public int getEpisodeNo() {
                return episodeNo;
            }

            public void setEpisodeNo(int episodeNo) {
                this.episodeNo = episodeNo;
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
