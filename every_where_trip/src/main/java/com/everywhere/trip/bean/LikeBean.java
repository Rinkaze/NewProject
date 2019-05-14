package com.everywhere.trip.bean;

import java.util.List;

/**
 * Created by 灵风 on 2019/5/7.
 */

public class LikeBean {

    /**
     * result : {"collectedRoutes":[{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"慢赏利古里亚海岸小城","id":222,"cityID":68,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1531309018023_0edabb9464f7adaca42178c7c2f28cc8.jpg","title":"热那亚海滨三镇","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"东京下町商店街双连击","id":221,"cityID":1,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1531097924092_0e8bab2df8ae0c018acb96bc941c5768.jpg","title":"武藏小山+户越银座","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"港口小城 北国夏日情","id":220,"cityID":7,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1529650779548_29519af91c043da5a75c2341565b7197.jpg","title":"函馆","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"玩转日本战国三杰之乡","id":219,"cityID":67,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1528974594053_bcc9acac546aa3852f5beb1f248b480c.jpg","title":"名古屋","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"老上海，新时尚","id":218,"cityID":65,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1527736977862_09030fbf6d38d6225540f30572750b05.jpg","title":"上海・武康路","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"最文艺时尚的逛吃","id":217,"cityID":66,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1529373536385_b5faee00d3d81c4d2f919cb418924b23.jpg","title":"首尔(圣水洞&江南区)","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"5天地热探险自驾游","id":216,"cityID":64,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1540982638615_c7bd2fad4079a48261ab4dd0e0c7d1e9.jpg","title":"新西兰 北岛","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"阳光海岸&艺术古城","id":215,"cityID":61,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1526627540007_1e0ae713b10802291e3d69d920e11a51.jpg","title":"马拉加","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"走一回姑苏繁华图","id":214,"cityID":63,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1525418415881_d0239f0bc75e95e82fb5563be1ddfb7e.jpg","title":"苏州 姑苏区","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"山海环抱的礼物","id":213,"cityID":59,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1525671670424_00f7349a56441575a09ffb76c8963608.jpg","title":"大连","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"藏于澳门的米其林滋味","id":212,"cityID":62,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1524877885361_8470f56104ce3adcd06a3d76538221bc.jpg","title":"寻味Macao","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"自驾徜徉特色小镇风情","id":211,"cityID":61,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1524743933008_21171bcde5b54f9a2b8f31b56166e64d.jpg","title":"西班牙南部小镇巡礼","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"柔情似水江南古城","id":210,"cityID":58,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1524309574766_ed20563a88873f1674d1ac8abcc427c5.jpg","title":"杭州 西湖+西溪","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"探寻莫斯科的历史文化精髓","id":209,"cityID":46,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523618947824_4b301684903fe9fc6623df712be83a99.jpg","title":"莫斯科博物馆巡礼","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"聆听大海的心跳","id":208,"cityID":54,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523445048228_79dfbc52b60dc9bce12b43ac193c233e.jpg","title":"普吉岛","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"最接地气的东方之珠","id":207,"cityID":57,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522818215175_38087efc2af1c6e42203bf2daf9e9a05.jpg","title":"香港古早味","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"越夜越北京的骑行之旅","id":206,"cityID":37,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523179548180_df90ffaeabeefd4c1c8bdceed943c8c9.png","title":"夜行龙脉","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"你不知道的曼哈顿美食之旅","id":205,"cityID":55,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523237331817_e7c134f5c721f603ff02321f3a4bece3.jpg","title":"纽约故事","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"舌尖上的\u201c泰北玫瑰\u201d","id":204,"cityID":54,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522380380748_6145161c36f9e41ba37225d1e01a2de6.jpg","title":"清迈美食","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"草原豪情+大碗肉之美食旅行","id":203,"cityID":56,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522378424372_8850dc33ce601213cabec57fad785ec4.jpg","title":"乌兰布统草原美食自驾","isPurchased":true}],"limit":20,"count":36,"page":1}
     * code : 0
     * desc : 处理成功
     */
    private ResultEntity result;
    private int code;
    private String desc;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ResultEntity getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public class ResultEntity {
        /**
         * collectedRoutes : [{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"慢赏利古里亚海岸小城","id":222,"cityID":68,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1531309018023_0edabb9464f7adaca42178c7c2f28cc8.jpg","title":"热那亚海滨三镇","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"东京下町商店街双连击","id":221,"cityID":1,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1531097924092_0e8bab2df8ae0c018acb96bc941c5768.jpg","title":"武藏小山+户越银座","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"港口小城 北国夏日情","id":220,"cityID":7,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1529650779548_29519af91c043da5a75c2341565b7197.jpg","title":"函馆","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"玩转日本战国三杰之乡","id":219,"cityID":67,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1528974594053_bcc9acac546aa3852f5beb1f248b480c.jpg","title":"名古屋","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"老上海，新时尚","id":218,"cityID":65,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1527736977862_09030fbf6d38d6225540f30572750b05.jpg","title":"上海・武康路","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"最文艺时尚的逛吃","id":217,"cityID":66,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1529373536385_b5faee00d3d81c4d2f919cb418924b23.jpg","title":"首尔(圣水洞&江南区)","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"5天地热探险自驾游","id":216,"cityID":64,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1540982638615_c7bd2fad4079a48261ab4dd0e0c7d1e9.jpg","title":"新西兰 北岛","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"阳光海岸&艺术古城","id":215,"cityID":61,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1526627540007_1e0ae713b10802291e3d69d920e11a51.jpg","title":"马拉加","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"走一回姑苏繁华图","id":214,"cityID":63,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1525418415881_d0239f0bc75e95e82fb5563be1ddfb7e.jpg","title":"苏州 姑苏区","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"山海环抱的礼物","id":213,"cityID":59,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1525671670424_00f7349a56441575a09ffb76c8963608.jpg","title":"大连","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"藏于澳门的米其林滋味","id":212,"cityID":62,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1524877885361_8470f56104ce3adcd06a3d76538221bc.jpg","title":"寻味Macao","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"自驾徜徉特色小镇风情","id":211,"cityID":61,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1524743933008_21171bcde5b54f9a2b8f31b56166e64d.jpg","title":"西班牙南部小镇巡礼","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"柔情似水江南古城","id":210,"cityID":58,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1524309574766_ed20563a88873f1674d1ac8abcc427c5.jpg","title":"杭州 西湖+西溪","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"探寻莫斯科的历史文化精髓","id":209,"cityID":46,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523618947824_4b301684903fe9fc6623df712be83a99.jpg","title":"莫斯科博物馆巡礼","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"聆听大海的心跳","id":208,"cityID":54,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523445048228_79dfbc52b60dc9bce12b43ac193c233e.jpg","title":"普吉岛","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"最接地气的东方之珠","id":207,"cityID":57,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522818215175_38087efc2af1c6e42203bf2daf9e9a05.jpg","title":"香港古早味","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"越夜越北京的骑行之旅","id":206,"cityID":37,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523179548180_df90ffaeabeefd4c1c8bdceed943c8c9.png","title":"夜行龙脉","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"你不知道的曼哈顿美食之旅","id":205,"cityID":55,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523237331817_e7c134f5c721f603ff02321f3a4bece3.jpg","title":"纽约故事","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"舌尖上的\u201c泰北玫瑰\u201d","id":204,"cityID":54,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522380380748_6145161c36f9e41ba37225d1e01a2de6.jpg","title":"清迈美食","isPurchased":true},{"createdAt":"2017-11-07","priceInCents":190,"price":"1.90","intro":"草原豪情+大碗肉之美食旅行","id":203,"cityID":56,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522378424372_8850dc33ce601213cabec57fad785ec4.jpg","title":"乌兰布统草原美食自驾","isPurchased":true}]
         * limit : 20
         * count : 36
         * page : 1
         */
        private List<CollectedRoutesEntity> collectedRoutes;
        private int limit;
        private int count;
        private int page;

        public void setCollectedRoutes(List<CollectedRoutesEntity> collectedRoutes) {
            this.collectedRoutes = collectedRoutes;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public List<CollectedRoutesEntity> getCollectedRoutes() {
            return collectedRoutes;
        }

        public int getLimit() {
            return limit;
        }

        public int getCount() {
            return count;
        }

        public int getPage() {
            return page;
        }

        public class CollectedRoutesEntity {
            /**
             * createdAt : 2017-11-07
             * priceInCents : 190
             * price : 1.90
             * intro : 慢赏利古里亚海岸小城
             * id : 222
             * cityID : 68
             * cardURL : http://cdn.banmi.com/banmiapp/rahdna/1531309018023_0edabb9464f7adaca42178c7c2f28cc8.jpg
             * title : 热那亚海滨三镇
             * isPurchased : true
             */
            private String createdAt;
            private int priceInCents;
            private String price;
            private String intro;
            private int id;
            private int cityID;
            private String cardURL;
            private String title;
            private boolean isPurchased;

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public void setPriceInCents(int priceInCents) {
                this.priceInCents = priceInCents;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setCityID(int cityID) {
                this.cityID = cityID;
            }

            public void setCardURL(String cardURL) {
                this.cardURL = cardURL;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setIsPurchased(boolean isPurchased) {
                this.isPurchased = isPurchased;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public int getPriceInCents() {
                return priceInCents;
            }

            public String getPrice() {
                return price;
            }

            public String getIntro() {
                return intro;
            }

            public int getId() {
                return id;
            }

            public int getCityID() {
                return cityID;
            }

            public String getCardURL() {
                return cardURL;
            }

            public String getTitle() {
                return title;
            }

            public boolean isIsPurchased() {
                return isPurchased;
            }
        }
    }
}
