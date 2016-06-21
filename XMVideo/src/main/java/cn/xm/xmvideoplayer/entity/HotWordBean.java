package cn.xm.xmvideoplayer.entity;

import java.util.List;

/**
 * 作者：ximencx on 2016/6/13 16:42
 * 邮箱：454366460@qq.com
 * 热门搜索词
 */
public class HotWordBean {

    /**
     * code : 0000
     * msg :
     * data : {"wordList":["权力的游戏","欲奴","行尸走肉","生活大爆炸","吸血鬼日记","越狱","破产姐妹","神盾局特工","疑犯追踪","犯罪心理"]}
     */

    private String code;
    private String msg;
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
        private List<String> wordList;

        public List<String> getWordList() {
            return wordList;
        }

        public void setWordList(List<String> wordList) {
            this.wordList = wordList;
        }
    }
}

