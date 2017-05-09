package com.example.zl.zlei.bean;

import java.util.List;

/**
 * Created by zl on 2017/5/8.
 */

public class DataBean {

    /**
     * status : 0
     * msg : ok
     * result : {"channel":"头条","num":"3","list":[{"title":"中国大亨进军华尔街资管行业","time":"2017-05-08 20:12","src":"新浪财经","category":"finance","pic":"http://api.jisuapi.com/news/upload/20170508/220002_65050.jpg","content":"","url":"http://finance.sina.cn/usstock/mggd/2017-05-08/detail-ifyeycfp9372634.d.html?vt=4&pos=108","weburl":"http://finance.sina.com.cn/stock/usstock/c/2017-05-08/us-ifyeycfp9372634.shtml"},{"title":"中国黑导游在日本骗国内游客","time":"2017-05-08 18:26","src":"国际在线","category":"news","pic":"http://api.jisuapi.com/news/upload/20170508/220002_95972.jpg","content":"","url":"http://news.sina.cn/2017-05-08/detail-ifyeycte9152902.d.html?vt=4&pos=108","weburl":"http://news.sina.com.cn/o/2017-05-08/doc-ifyeycte9152902.shtml"},{"title":"65后女市委书记晋升省委常委","time":"2017-05-08 20:21","src":"中国搜索网","category":"news","pic":"http://api.jisuapi.com/news/upload/20170508/220002_35530.jpg","content":"","url":"http://news.sina.cn/gn/2017-05-08/detail-ifyeycfp9372781.d.html?vt=4&pos=108","weburl":"http://news.sina.com.cn/c/nd/2017-05-08/doc-ifyeycfp9372781.shtml"}]}
     */

    private String status;
    private String msg;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * channel : 头条
         * num : 3
         * list : [{"title":"中国大亨进军华尔街资管行业","time":"2017-05-08 20:12","src":"新浪财经","category":"finance","pic":"http://api.jisuapi.com/news/upload/20170508/220002_65050.jpg","content":"","url":"http://finance.sina.cn/usstock/mggd/2017-05-08/detail-ifyeycfp9372634.d.html?vt=4&pos=108","weburl":"http://finance.sina.com.cn/stock/usstock/c/2017-05-08/us-ifyeycfp9372634.shtml"},{"title":"中国黑导游在日本骗国内游客","time":"2017-05-08 18:26","src":"国际在线","category":"news","pic":"http://api.jisuapi.com/news/upload/20170508/220002_95972.jpg","content":"","url":"http://news.sina.cn/2017-05-08/detail-ifyeycte9152902.d.html?vt=4&pos=108","weburl":"http://news.sina.com.cn/o/2017-05-08/doc-ifyeycte9152902.shtml"},{"title":"65后女市委书记晋升省委常委","time":"2017-05-08 20:21","src":"中国搜索网","category":"news","pic":"http://api.jisuapi.com/news/upload/20170508/220002_35530.jpg","content":"","url":"http://news.sina.cn/gn/2017-05-08/detail-ifyeycfp9372781.d.html?vt=4&pos=108","weburl":"http://news.sina.com.cn/c/nd/2017-05-08/doc-ifyeycfp9372781.shtml"}]
         */

        private String channel;
        private String num;
        private List<ListBean> list;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * title : 中国大亨进军华尔街资管行业
             * time : 2017-05-08 20:12
             * src : 新浪财经
             * category : finance
             * pic : http://api.jisuapi.com/news/upload/20170508/220002_65050.jpg
             * content :
             * url : http://finance.sina.cn/usstock/mggd/2017-05-08/detail-ifyeycfp9372634.d.html?vt=4&pos=108
             * weburl : http://finance.sina.com.cn/stock/usstock/c/2017-05-08/us-ifyeycfp9372634.shtml
             */

            private String title;
            private String time;
            private String src;
            private String category;
            private String pic;
            private String content;
            private String url;
            private String weburl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getWeburl() {
                return weburl;
            }

            public void setWeburl(String weburl) {
                this.weburl = weburl;
            }
        }
    }
}
