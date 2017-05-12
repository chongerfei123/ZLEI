package com.example.zl.zlei.bean;

import java.util.List;

/**
 * Created by zl on 2017/5/12.
 */

public class SearchDataBean {

    /**
     * status : 0
     * msg : ok
     * result : {"keyword":"宋茜","num":"13","list":[{"title":"宋茜每次机场街拍都能上热搜，这次吸睛的不只是衣服，还有她的腰","time":"2017-05-12 10:00:00","src":"剧光灯","category":"","pic":["http://api.jisuapi.com/news/upload/20170512/134441_87633.jpg","http://api.jisuapi.com/news/upload/20170512/134441_39330.jpg","http://api.jisuapi.com/news/upload/20170512/134442_50052.jpg","http://api.jisuapi.com/news/upload/20170512/134442_65752.jpg","http://api.jisuapi.com/news/upload/20170512/134442_37548.jpg","http://api.jisuapi.com/news/upload/20170512/134442_62488.jpg","http://api.jisuapi.com/news/upload/20170512/134452_24712.jpg","http://api.jisuapi.com/news/upload/20170512/134453_71551.jpg"],"url":"http://p1.qhimg.com/t019b75dcf649374be5.jpg?size=415x622","weburl":"http://www.toutiao.com/i6419062385188798978/","content":""},{"title":"宋茜身穿Valentino服饰在香港开店出席活动","time":"2017-05-12 09:49:00","src":"Xfashion馨风尚","category":"","pic":["http://api.jisuapi.com/news/upload/20170512/134454_61824.jpg","http://api.jisuapi.com/news/upload/20170512/134454_94689.jpg","http://api.jisuapi.com/news/upload/20170512/134454_28119.jpg","http://api.jisuapi.com/news/upload/20170512/134454_28472.jpg","http://api.jisuapi.com/news/upload/20170512/134455_30280.jpg","http://api.jisuapi.com/news/upload/20170512/134455_78569.jpg","http://api.jisuapi.com/news/upload/20170512/134455_82223.jpg","http://api.jisuapi.com/news/upload/20170512/134455_12350.jpg","http://api.jisuapi.com/news/upload/20170512/134455_55986.jpg"],"url":"http://p5.qhimg.com/t01a34e4bf64fbffa7b.jpg?size=640x959","weburl":"http://www.toutiao.com/i6419059488719897090/","content":""},{"title":"宋茜和景甜仅差1岁，同样穿短裤秀长腿身材却差别大，是化妆品吗","time":"2017-05-11 22:24:00","src":"娱乐小新人","category":"","pic":["http://api.jisuapi.com/news/upload/20170512/134500_72614.jpg","http://api.jisuapi.com/news/upload/20170512/134500_29930.jpg","http://api.jisuapi.com/news/upload/20170512/134500_16217.jpg","http://api.jisuapi.com/news/upload/20170512/134500_52836.jpg","http://api.jisuapi.com/news/upload/20170512/134501_82975.jpg","http://api.jisuapi.com/news/upload/20170512/134501_44158.jpg","http://api.jisuapi.com/news/upload/20170512/134501_26526.jpg","http://api.jisuapi.com/news/upload/20170512/134501_67117.jpg"],"url":"http://p0.qhimg.com/t0162d09bd93f4bf1c3.jpg?size=356x524","weburl":"http://www.toutiao.com/i6418883132740600321/","content":""}]}
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
         * keyword : 宋茜
         * num : 13
         * list : [{"title":"宋茜每次机场街拍都能上热搜，这次吸睛的不只是衣服，还有她的腰","time":"2017-05-12 10:00:00","src":"剧光灯","category":"","pic":["http://api.jisuapi.com/news/upload/20170512/134441_87633.jpg","http://api.jisuapi.com/news/upload/20170512/134441_39330.jpg","http://api.jisuapi.com/news/upload/20170512/134442_50052.jpg","http://api.jisuapi.com/news/upload/20170512/134442_65752.jpg","http://api.jisuapi.com/news/upload/20170512/134442_37548.jpg","http://api.jisuapi.com/news/upload/20170512/134442_62488.jpg","http://api.jisuapi.com/news/upload/20170512/134452_24712.jpg","http://api.jisuapi.com/news/upload/20170512/134453_71551.jpg"],"url":"http://p1.qhimg.com/t019b75dcf649374be5.jpg?size=415x622","weburl":"http://www.toutiao.com/i6419062385188798978/","content":""},{"title":"宋茜身穿Valentino服饰在香港开店出席活动","time":"2017-05-12 09:49:00","src":"Xfashion馨风尚","category":"","pic":["http://api.jisuapi.com/news/upload/20170512/134454_61824.jpg","http://api.jisuapi.com/news/upload/20170512/134454_94689.jpg","http://api.jisuapi.com/news/upload/20170512/134454_28119.jpg","http://api.jisuapi.com/news/upload/20170512/134454_28472.jpg","http://api.jisuapi.com/news/upload/20170512/134455_30280.jpg","http://api.jisuapi.com/news/upload/20170512/134455_78569.jpg","http://api.jisuapi.com/news/upload/20170512/134455_82223.jpg","http://api.jisuapi.com/news/upload/20170512/134455_12350.jpg","http://api.jisuapi.com/news/upload/20170512/134455_55986.jpg"],"url":"http://p5.qhimg.com/t01a34e4bf64fbffa7b.jpg?size=640x959","weburl":"http://www.toutiao.com/i6419059488719897090/","content":""},{"title":"宋茜和景甜仅差1岁，同样穿短裤秀长腿身材却差别大，是化妆品吗","time":"2017-05-11 22:24:00","src":"娱乐小新人","category":"","pic":["http://api.jisuapi.com/news/upload/20170512/134500_72614.jpg","http://api.jisuapi.com/news/upload/20170512/134500_29930.jpg","http://api.jisuapi.com/news/upload/20170512/134500_16217.jpg","http://api.jisuapi.com/news/upload/20170512/134500_52836.jpg","http://api.jisuapi.com/news/upload/20170512/134501_82975.jpg","http://api.jisuapi.com/news/upload/20170512/134501_44158.jpg","http://api.jisuapi.com/news/upload/20170512/134501_26526.jpg","http://api.jisuapi.com/news/upload/20170512/134501_67117.jpg"],"url":"http://p0.qhimg.com/t0162d09bd93f4bf1c3.jpg?size=356x524","weburl":"http://www.toutiao.com/i6418883132740600321/","content":""}]
         */

        private String keyword;
        private String num;
        private List<ListBean> list;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
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
             * title : 宋茜每次机场街拍都能上热搜，这次吸睛的不只是衣服，还有她的腰
             * time : 2017-05-12 10:00:00
             * src : 剧光灯
             * category :
             * pic : ["http://api.jisuapi.com/news/upload/20170512/134441_87633.jpg","http://api.jisuapi.com/news/upload/20170512/134441_39330.jpg","http://api.jisuapi.com/news/upload/20170512/134442_50052.jpg","http://api.jisuapi.com/news/upload/20170512/134442_65752.jpg","http://api.jisuapi.com/news/upload/20170512/134442_37548.jpg","http://api.jisuapi.com/news/upload/20170512/134442_62488.jpg","http://api.jisuapi.com/news/upload/20170512/134452_24712.jpg","http://api.jisuapi.com/news/upload/20170512/134453_71551.jpg"]
             * url : http://p1.qhimg.com/t019b75dcf649374be5.jpg?size=415x622
             * weburl : http://www.toutiao.com/i6419062385188798978/
             * content :
             */

            private String title;
            private String time;
            private String src;
            private String category;
            private String url;
            private String weburl;
            private String content;
            private List<String> pic;


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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public List<String> getPic() {
                return pic;
            }

            public void setPic(List<String> pic) {
                this.pic = pic;
            }
        }
    }
}
