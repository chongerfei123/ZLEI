package com.example.zl.zlei.bean;

import java.util.List;

/**
 * Created by zl on 2017/7/12.
 */

public class JokeTextBean {

    /**
     * status : 0
     * msg : ok
     * result : {"total":"49610","pagenum":"1","pagesize":"3","list":[{"content":"      夏天的晚上只要不下雨我常会去市里天桥去摆摊，卖些女性小饰品。老婆很不理解，认为每晚赚几十块钱还不够开车到市里来回油钱，而我总是笑笑。我内心知道，当女人蹲下来挑小饰品时也是我最快乐的时候。有些女人穿裙子，有些女人领口很大\u2026\u2026这些我会告诉她吗？","addtime":"2017-07-12 03:20:10","url":"http://m.kaixinhui.com/detail-54419.html"},{"content":"一渔夫去海边打渔，这时，打上来一条鱿鱼。鱿鱼满含眼泪:\u201c求求你放了我吧\u201d渔夫说:\u201c看你那么苦苦哀求的份上，那么，我考考你吧，答对了，就放你走\u201d鱿鱼激动道:\u201c你考吧考吧\u201d渔夫就这样把鱿鱼烤了\u2026","addtime":"2017-07-12 03:20:10","url":"http://m.kaixinhui.com/detail-54418.html"},{"content":"一个抽烟的人打开他的烟盒，请坐在他右边的人抽烟，右边的人说：\u201c谢谢，我不抽烟。\u201d　　他又请坐在左边的人抽烟，左边的人也说：\u201c我不抽烟，谢谢！\u201d　　他的夫人提醒道：\u201c你怎么不请坐在对面的人抽烟呢？\u201d　　\u201c因为他会抽烟！\u201d","addtime":"2017-07-12 03:20:10","url":"http://m.kaixinhui.com/detail-54417.html"}]}
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
         * total : 49610
         * pagenum : 1
         * pagesize : 3
         * list : [{"content":"      夏天的晚上只要不下雨我常会去市里天桥去摆摊，卖些女性小饰品。老婆很不理解，认为每晚赚几十块钱还不够开车到市里来回油钱，而我总是笑笑。我内心知道，当女人蹲下来挑小饰品时也是我最快乐的时候。有些女人穿裙子，有些女人领口很大\u2026\u2026这些我会告诉她吗？","addtime":"2017-07-12 03:20:10","url":"http://m.kaixinhui.com/detail-54419.html"},{"content":"一渔夫去海边打渔，这时，打上来一条鱿鱼。鱿鱼满含眼泪:\u201c求求你放了我吧\u201d渔夫说:\u201c看你那么苦苦哀求的份上，那么，我考考你吧，答对了，就放你走\u201d鱿鱼激动道:\u201c你考吧考吧\u201d渔夫就这样把鱿鱼烤了\u2026","addtime":"2017-07-12 03:20:10","url":"http://m.kaixinhui.com/detail-54418.html"},{"content":"一个抽烟的人打开他的烟盒，请坐在他右边的人抽烟，右边的人说：\u201c谢谢，我不抽烟。\u201d　　他又请坐在左边的人抽烟，左边的人也说：\u201c我不抽烟，谢谢！\u201d　　他的夫人提醒道：\u201c你怎么不请坐在对面的人抽烟呢？\u201d　　\u201c因为他会抽烟！\u201d","addtime":"2017-07-12 03:20:10","url":"http://m.kaixinhui.com/detail-54417.html"}]
         */

        private String total;
        private String pagenum;
        private String pagesize;
        private List<ListBean> list;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPagenum() {
            return pagenum;
        }

        public void setPagenum(String pagenum) {
            this.pagenum = pagenum;
        }

        public String getPagesize() {
            return pagesize;
        }

        public void setPagesize(String pagesize) {
            this.pagesize = pagesize;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * content :       夏天的晚上只要不下雨我常会去市里天桥去摆摊，卖些女性小饰品。老婆很不理解，认为每晚赚几十块钱还不够开车到市里来回油钱，而我总是笑笑。我内心知道，当女人蹲下来挑小饰品时也是我最快乐的时候。有些女人穿裙子，有些女人领口很大……这些我会告诉她吗？
             * addtime : 2017-07-12 03:20:10
             * url : http://m.kaixinhui.com/detail-54419.html
             */

            private String content;
            private String addtime;
            private String url;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
