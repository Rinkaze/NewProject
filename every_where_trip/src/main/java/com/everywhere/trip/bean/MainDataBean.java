package com.everywhere.trip.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 灵风 on 2019/5/5.
 */

public class MainDataBean {

    /**
     * result : {"routes":[{"city":"日本·四国地区","isNewRoute":0,"priceInCents":190,"cityID":52,"title":"濑户内海艺术双岛","type":"route","isPurchased":false,"purchasedTimes":1974,"sequence":-898,"videoURL":"","price":"1.9","intro":"直岛·丰岛美术馆巡礼","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg","id":196,"isCollected":false},{"contentURL":"http://cdn.banmi.com/banmiapp/html/1522659154327.html","location":1,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522654270428_8f11bbbd503ff42905aea3a58e78e807.png","title":"艺术之旅","type":"bundle"},{"city":"泰国","isNewRoute":0,"priceInCents":190,"cityID":54,"title":"清迈美食","type":"route","isPurchased":false,"purchasedTimes":1683,"sequence":-880,"videoURL":"","price":"1.9","intro":"舌尖上的\u201c泰北玫瑰\u201d","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522380380748_6145161c36f9e41ba37225d1e01a2de6.jpg","id":204,"isCollected":false},{"city":"台北","isNewRoute":1,"priceInCents":190,"cityID":50,"title":"电影中的台湾","type":"route","isPurchased":false,"purchasedTimes":1135,"sequence":-879,"videoURL":"","price":"1.9","intro":"跟着镜头寻找宝岛小确幸","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg","id":201,"isCollected":false},{"city":"北京","isNewRoute":1,"priceInCents":190,"cityID":37,"title":"雍和宫〜北新桥","type":"route","isPurchased":false,"purchasedTimes":2161,"sequence":-877,"videoURL":"","price":"1.9","intro":"爱上历史深处的文艺小巷","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522286621202_7b91111fb2dffe11b646759be235f7e7.jpg","id":202,"isCollected":false},{"city":"香港","isNewRoute":1,"priceInCents":190,"cityID":57,"title":"香港古早味","type":"route","isPurchased":false,"purchasedTimes":1646,"sequence":-877,"videoURL":"","price":"1.9","intro":"最接地气的东方之珠","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522818215175_38087efc2af1c6e42203bf2daf9e9a05.jpg","id":207,"isCollected":false},{"city":"日本·东京周边","isNewRoute":0,"priceInCents":190,"cityID":15,"title":"镰仓","type":"route","isPurchased":false,"purchasedTimes":2672,"sequence":-876,"videoURL":"","price":"1.9","intro":"8小时海街小城治愈之旅","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510559916208_a791f18de091581aa0ac437887686f52.jpg","id":12,"isCollected":false},{"city":"福建","isNewRoute":0,"priceInCents":190,"cityID":53,"title":"厦门·鼓浪屿","type":"route","isPurchased":false,"purchasedTimes":1301,"sequence":-870,"videoURL":"","price":"1.9","intro":"文艺情怀厦之味","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521714816208_c314aeb52357c354eb51ad82e129864c.jpg","id":199,"isCollected":false},{"city":"泰国","isNewRoute":1,"priceInCents":190,"cityID":54,"title":"普吉岛","type":"route","isPurchased":false,"purchasedTimes":1833,"sequence":-858,"videoURL":"","price":"1.9","intro":"聆听大海的心跳","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523445048228_79dfbc52b60dc9bce12b43ac193c233e.jpg","id":208,"isCollected":false},{"city":"新西兰","isNewRoute":1,"priceInCents":190,"cityID":64,"title":"新西兰 北岛","type":"route","isPurchased":false,"purchasedTimes":1723,"sequence":-857,"videoURL":"","price":"1.9","intro":"5天地热探险自驾游","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1540982638615_c7bd2fad4079a48261ab4dd0e0c7d1e9.jpg","id":216,"isCollected":false},{"city":"大连","isNewRoute":1,"priceInCents":190,"cityID":59,"title":"大连","type":"route","isPurchased":false,"purchasedTimes":1784,"sequence":-850,"videoURL":"","price":"1.9","intro":"山海环抱的礼物","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1525671670424_00f7349a56441575a09ffb76c8963608.jpg","id":213,"isCollected":false},{"city":"北京","isNewRoute":0,"priceInCents":190,"cityID":37,"title":"故宫","type":"route","isPurchased":false,"purchasedTimes":1674,"sequence":-849,"videoURL":"","price":"1.9","intro":"6小时故宫前朝中轴线","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1514537918440_94454fecd967547430c35ef76a9a62fb.jpg","id":151,"isCollected":false},{"contentURL":"http://cdn.banmi.com/banmiapp/html/1521542677041.html","location":11,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521542676849_2e57cca0e9fc7faeefce11894845e0c9.jpg","title":"吃遍中国天南海北","type":"bundle"},{"city":"摩洛哥","isNewRoute":0,"priceInCents":190,"cityID":38,"title":"摩洛哥","type":"route","isPurchased":false,"purchasedTimes":746,"sequence":-848,"videoURL":"","price":"1.9","intro":"世界万千美好的缩小版","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1514359366757_8dc8a17d28a278b5b63464ccb63bc2cb.png","id":150,"isCollected":false},{"city":"美国","isNewRoute":1,"priceInCents":190,"cityID":55,"title":"纽约故事","type":"route","isPurchased":false,"purchasedTimes":1873,"sequence":-845,"videoURL":"","price":"1.9","intro":"你不知道的曼哈顿美食之旅","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523237331817_e7c134f5c721f603ff02321f3a4bece3.jpg","id":205,"isCollected":false},{"city":"内蒙古","isNewRoute":1,"priceInCents":190,"cityID":56,"title":"乌兰布统草原美食自驾","type":"route","isPurchased":false,"purchasedTimes":1800,"sequence":-840,"videoURL":"","price":"1.9","intro":"草原豪情+大碗肉之美食旅行","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522378424372_8850dc33ce601213cabec57fad785ec4.jpg","id":203,"isCollected":false},{"city":"日本·大阪","isNewRoute":0,"priceInCents":190,"cityID":2,"title":"日本关西樱花祭","type":"route","isPurchased":false,"purchasedTimes":2801,"sequence":-839,"videoURL":"","price":"1.9","intro":"大阪·京都赏樱之旅","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1518095305572_09b354668a11b25b45c3975501e8b288.jpg","id":195,"isCollected":false},{"city":"日本·北海道","isNewRoute":0,"priceInCents":190,"cityID":7,"title":"札幌","type":"route","isPurchased":false,"purchasedTimes":1451,"sequence":-836,"videoURL":"","price":"1.9","intro":"一日尽享札幌最精华","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1514876302750_387b23058877d8cbac365798d6ee8687.jpg","id":152,"isCollected":false},{"city":"日本·北海道","isNewRoute":0,"priceInCents":190,"cityID":7,"title":"小樽","type":"route","isPurchased":false,"purchasedTimes":1313,"sequence":-822,"videoURL":"","price":"1.9","intro":"8小时《情书》拍摄地朝圣","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510556540699_bb98884ed2730c84af74fc9489fb3005.jpg","id":135,"isCollected":false},{"city":"苏州","isNewRoute":1,"priceInCents":190,"cityID":63,"title":"苏州 姑苏区","type":"route","isPurchased":false,"purchasedTimes":1784,"sequence":-814,"videoURL":"","price":"1.9","intro":"走一回姑苏繁华图","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1525418415881_d0239f0bc75e95e82fb5563be1ddfb7e.jpg","id":214,"isCollected":false},{"city":"俄罗斯","isNewRoute":1,"priceInCents":190,"cityID":46,"title":"莫斯科博物馆巡礼","type":"route","isPurchased":false,"purchasedTimes":2185,"sequence":-793,"videoURL":"","price":"1.9","intro":"探寻莫斯科的历史文化精髓","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523618947824_4b301684903fe9fc6623df712be83a99.jpg","id":209,"isCollected":false},{"city":"澳大利亚·珀斯周边","isNewRoute":0,"priceInCents":190,"cityID":51,"title":"环西澳自驾","type":"route","isPurchased":false,"purchasedTimes":1683,"sequence":-770,"videoURL":"","price":"1.9","intro":"沿印度洋海岸线探索奇澳之旅","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521105648687_4d84cb8e74f4dc80a9282bef22cd3c57.jpg","id":198,"isCollected":false}],"count":80,"limit":20,"page":1,"banners":[{"mode":"route","imageURL":"http://cdn.banmi.com/banmiapp/rahdna/1520822980027_b29370e5fb8888d86b9e863fbbf1a4cb.jpg","target":"183"},{"mode":"route","imageURL":"http://cdn.banmi.com/banmiapp/rahdna/1520822999320_0f2c15d8376db70e1a128cb5c10250b4.jpg","target":"195"},{"mode":"route","imageURL":"http://cdn.banmi.com/banmiapp/rahdna/1515997435798_c6bc56737a11dde34918c31d883867b9.png","target":"162"},{"mode":"route","imageURL":"http://cdn.banmi.com/banmiapp/rahdna/1515250333266_9b99d6600bae930c8c8d8d374b000505.jpg","target":"144"},{"mode":"web","imageURL":"http://cdn.banmi.com/banmiapp/rahdna/1515139028296_e70f07d41c6bca39ba5e8d6452342b2f.png","target":"http://banmi.com/app2017/kol.html?f=app"}]}
     * code : 0
     * desc :
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
         * routes : [{"city":"日本·四国地区","isNewRoute":0,"priceInCents":190,"cityID":52,"title":"濑户内海艺术双岛","type":"route","isPurchased":false,"purchasedTimes":1974,"sequence":-898,"videoURL":"","price":"1.9","intro":"直岛·丰岛美术馆巡礼","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg","id":196,"isCollected":false},{"contentURL":"http://cdn.banmi.com/banmiapp/html/1522659154327.html","location":1,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522654270428_8f11bbbd503ff42905aea3a58e78e807.png","title":"艺术之旅","type":"bundle"},{"city":"泰国","isNewRoute":0,"priceInCents":190,"cityID":54,"title":"清迈美食","type":"route","isPurchased":false,"purchasedTimes":1683,"sequence":-880,"videoURL":"","price":"1.9","intro":"舌尖上的\u201c泰北玫瑰\u201d","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522380380748_6145161c36f9e41ba37225d1e01a2de6.jpg","id":204,"isCollected":false},{"city":"台北","isNewRoute":1,"priceInCents":190,"cityID":50,"title":"电影中的台湾","type":"route","isPurchased":false,"purchasedTimes":1135,"sequence":-879,"videoURL":"","price":"1.9","intro":"跟着镜头寻找宝岛小确幸","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg","id":201,"isCollected":false},{"city":"北京","isNewRoute":1,"priceInCents":190,"cityID":37,"title":"雍和宫〜北新桥","type":"route","isPurchased":false,"purchasedTimes":2161,"sequence":-877,"videoURL":"","price":"1.9","intro":"爱上历史深处的文艺小巷","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522286621202_7b91111fb2dffe11b646759be235f7e7.jpg","id":202,"isCollected":false},{"city":"香港","isNewRoute":1,"priceInCents":190,"cityID":57,"title":"香港古早味","type":"route","isPurchased":false,"purchasedTimes":1646,"sequence":-877,"videoURL":"","price":"1.9","intro":"最接地气的东方之珠","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522818215175_38087efc2af1c6e42203bf2daf9e9a05.jpg","id":207,"isCollected":false},{"city":"日本·东京周边","isNewRoute":0,"priceInCents":190,"cityID":15,"title":"镰仓","type":"route","isPurchased":false,"purchasedTimes":2672,"sequence":-876,"videoURL":"","price":"1.9","intro":"8小时海街小城治愈之旅","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510559916208_a791f18de091581aa0ac437887686f52.jpg","id":12,"isCollected":false},{"city":"福建","isNewRoute":0,"priceInCents":190,"cityID":53,"title":"厦门·鼓浪屿","type":"route","isPurchased":false,"purchasedTimes":1301,"sequence":-870,"videoURL":"","price":"1.9","intro":"文艺情怀厦之味","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521714816208_c314aeb52357c354eb51ad82e129864c.jpg","id":199,"isCollected":false},{"city":"泰国","isNewRoute":1,"priceInCents":190,"cityID":54,"title":"普吉岛","type":"route","isPurchased":false,"purchasedTimes":1833,"sequence":-858,"videoURL":"","price":"1.9","intro":"聆听大海的心跳","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523445048228_79dfbc52b60dc9bce12b43ac193c233e.jpg","id":208,"isCollected":false},{"city":"新西兰","isNewRoute":1,"priceInCents":190,"cityID":64,"title":"新西兰 北岛","type":"route","isPurchased":false,"purchasedTimes":1723,"sequence":-857,"videoURL":"","price":"1.9","intro":"5天地热探险自驾游","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1540982638615_c7bd2fad4079a48261ab4dd0e0c7d1e9.jpg","id":216,"isCollected":false},{"city":"大连","isNewRoute":1,"priceInCents":190,"cityID":59,"title":"大连","type":"route","isPurchased":false,"purchasedTimes":1784,"sequence":-850,"videoURL":"","price":"1.9","intro":"山海环抱的礼物","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1525671670424_00f7349a56441575a09ffb76c8963608.jpg","id":213,"isCollected":false},{"city":"北京","isNewRoute":0,"priceInCents":190,"cityID":37,"title":"故宫","type":"route","isPurchased":false,"purchasedTimes":1674,"sequence":-849,"videoURL":"","price":"1.9","intro":"6小时故宫前朝中轴线","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1514537918440_94454fecd967547430c35ef76a9a62fb.jpg","id":151,"isCollected":false},{"contentURL":"http://cdn.banmi.com/banmiapp/html/1521542677041.html","location":11,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521542676849_2e57cca0e9fc7faeefce11894845e0c9.jpg","title":"吃遍中国天南海北","type":"bundle"},{"city":"摩洛哥","isNewRoute":0,"priceInCents":190,"cityID":38,"title":"摩洛哥","type":"route","isPurchased":false,"purchasedTimes":746,"sequence":-848,"videoURL":"","price":"1.9","intro":"世界万千美好的缩小版","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1514359366757_8dc8a17d28a278b5b63464ccb63bc2cb.png","id":150,"isCollected":false},{"city":"美国","isNewRoute":1,"priceInCents":190,"cityID":55,"title":"纽约故事","type":"route","isPurchased":false,"purchasedTimes":1873,"sequence":-845,"videoURL":"","price":"1.9","intro":"你不知道的曼哈顿美食之旅","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523237331817_e7c134f5c721f603ff02321f3a4bece3.jpg","id":205,"isCollected":false},{"city":"内蒙古","isNewRoute":1,"priceInCents":190,"cityID":56,"title":"乌兰布统草原美食自驾","type":"route","isPurchased":false,"purchasedTimes":1800,"sequence":-840,"videoURL":"","price":"1.9","intro":"草原豪情+大碗肉之美食旅行","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1522378424372_8850dc33ce601213cabec57fad785ec4.jpg","id":203,"isCollected":false},{"city":"日本·大阪","isNewRoute":0,"priceInCents":190,"cityID":2,"title":"日本关西樱花祭","type":"route","isPurchased":false,"purchasedTimes":2801,"sequence":-839,"videoURL":"","price":"1.9","intro":"大阪·京都赏樱之旅","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1518095305572_09b354668a11b25b45c3975501e8b288.jpg","id":195,"isCollected":false},{"city":"日本·北海道","isNewRoute":0,"priceInCents":190,"cityID":7,"title":"札幌","type":"route","isPurchased":false,"purchasedTimes":1451,"sequence":-836,"videoURL":"","price":"1.9","intro":"一日尽享札幌最精华","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1514876302750_387b23058877d8cbac365798d6ee8687.jpg","id":152,"isCollected":false},{"city":"日本·北海道","isNewRoute":0,"priceInCents":190,"cityID":7,"title":"小樽","type":"route","isPurchased":false,"purchasedTimes":1313,"sequence":-822,"videoURL":"","price":"1.9","intro":"8小时《情书》拍摄地朝圣","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510556540699_bb98884ed2730c84af74fc9489fb3005.jpg","id":135,"isCollected":false},{"city":"苏州","isNewRoute":1,"priceInCents":190,"cityID":63,"title":"苏州 姑苏区","type":"route","isPurchased":false,"purchasedTimes":1784,"sequence":-814,"videoURL":"","price":"1.9","intro":"走一回姑苏繁华图","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1525418415881_d0239f0bc75e95e82fb5563be1ddfb7e.jpg","id":214,"isCollected":false},{"city":"俄罗斯","isNewRoute":1,"priceInCents":190,"cityID":46,"title":"莫斯科博物馆巡礼","type":"route","isPurchased":false,"purchasedTimes":2185,"sequence":-793,"videoURL":"","price":"1.9","intro":"探寻莫斯科的历史文化精髓","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1523618947824_4b301684903fe9fc6623df712be83a99.jpg","id":209,"isCollected":false},{"city":"澳大利亚·珀斯周边","isNewRoute":0,"priceInCents":190,"cityID":51,"title":"环西澳自驾","type":"route","isPurchased":false,"purchasedTimes":1683,"sequence":-770,"videoURL":"","price":"1.9","intro":"沿印度洋海岸线探索奇澳之旅","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521105648687_4d84cb8e74f4dc80a9282bef22cd3c57.jpg","id":198,"isCollected":false}]
         * count : 80
         * limit : 20
         * page : 1
         * banners : [{"mode":"route","imageURL":"http://cdn.banmi.com/banmiapp/rahdna/1520822980027_b29370e5fb8888d86b9e863fbbf1a4cb.jpg","target":"183"},{"mode":"route","imageURL":"http://cdn.banmi.com/banmiapp/rahdna/1520822999320_0f2c15d8376db70e1a128cb5c10250b4.jpg","target":"195"},{"mode":"route","imageURL":"http://cdn.banmi.com/banmiapp/rahdna/1515997435798_c6bc56737a11dde34918c31d883867b9.png","target":"162"},{"mode":"route","imageURL":"http://cdn.banmi.com/banmiapp/rahdna/1515250333266_9b99d6600bae930c8c8d8d374b000505.jpg","target":"144"},{"mode":"web","imageURL":"http://cdn.banmi.com/banmiapp/rahdna/1515139028296_e70f07d41c6bca39ba5e8d6452342b2f.png","target":"http://banmi.com/app2017/kol.html?f=app"}]
         */
        private List<RoutesEntity> routes;
        private int count;
        private int limit;
        private int page;
        private List<BannersEntity> banners;

        public void setRoutes(List<RoutesEntity> routes) {
            this.routes = routes;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public void setBanners(List<BannersEntity> banners) {
            this.banners = banners;
        }

        public List<RoutesEntity> getRoutes() {
            return routes;
        }

        public int getCount() {
            return count;
        }

        public int getLimit() {
            return limit;
        }

        public int getPage() {
            return page;
        }

        public List<BannersEntity> getBanners() {
            return banners;
        }

        public class RoutesEntity implements Serializable{
            /**
             * city : 日本·四国地区
             * isNewRoute : 0
             * priceInCents : 190
             * cityID : 52
             * title : 濑户内海艺术双岛
             * type : route
             * isPurchased : false
             * purchasedTimes : 1974
             * sequence : -898
             * videoURL :
             * price : 1.9
             * intro : 直岛·丰岛美术馆巡礼
             * cardURL : http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg
             * id : 196
             * isCollected : false
             */
            private String city;
            private int isNewRoute;
            private int priceInCents;
            private int cityID;
            private String title;
            private String type;
            private boolean isPurchased;
            private int purchasedTimes;
            private int sequence;
            private String videoURL;
            private String price;
            private String intro;
            private String cardURL;
            private int id;
            private boolean isCollected;
            private String contentURL;

            public void setContentURL(String contentURL) {
                this.contentURL = contentURL;
            }

            public String getContentURL() {
                return contentURL;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public void setIsNewRoute(int isNewRoute) {
                this.isNewRoute = isNewRoute;
            }

            public void setPriceInCents(int priceInCents) {
                this.priceInCents = priceInCents;
            }

            public void setCityID(int cityID) {
                this.cityID = cityID;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setIsPurchased(boolean isPurchased) {
                this.isPurchased = isPurchased;
            }

            public void setPurchasedTimes(int purchasedTimes) {
                this.purchasedTimes = purchasedTimes;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public void setVideoURL(String videoURL) {
                this.videoURL = videoURL;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public void setCardURL(String cardURL) {
                this.cardURL = cardURL;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIsCollected(boolean isCollected) {
                this.isCollected = isCollected;
            }

            public String getCity() {
                return city;
            }

            public int getIsNewRoute() {
                return isNewRoute;
            }

            public int getPriceInCents() {
                return priceInCents;
            }

            public int getCityID() {
                return cityID;
            }

            public String getTitle() {
                return title;
            }

            public String getType() {
                return type;
            }

            public boolean isIsPurchased() {
                return isPurchased;
            }

            public int getPurchasedTimes() {
                return purchasedTimes;
            }

            public int getSequence() {
                return sequence;
            }

            public String getVideoURL() {
                return videoURL;
            }

            public String getPrice() {
                return price;
            }

            public String getIntro() {
                return intro;
            }

            public String getCardURL() {
                return cardURL;
            }

            public int getId() {
                return id;
            }

            public boolean isIsCollected() {
                return isCollected;
            }
        }

        public class BannersEntity {
            /**
             * mode : route
             * imageURL : http://cdn.banmi.com/banmiapp/rahdna/1520822980027_b29370e5fb8888d86b9e863fbbf1a4cb.jpg
             * target : 183
             */
            private String mode;
            private String imageURL;
            private String target;

            public void setMode(String mode) {
                this.mode = mode;
            }

            public void setImageURL(String imageURL) {
                this.imageURL = imageURL;
            }

            public void setTarget(String target) {
                this.target = target;
            }

            public String getMode() {
                return mode;
            }

            public String getImageURL() {
                return imageURL;
            }

            public String getTarget() {
                return target;
            }
        }
    }
}
