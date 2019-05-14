package com.everywhere.trip.bean;

import java.util.List;

/**
 * Created by 灵风 on 2019/5/8.
 */

public class MainDataInfo {

    /**
     * result : {"route":{"priceInCents":190,"city":"日本·四国地区","description":"你好！我是Charlie，是一个超级日范，每年至少会在日本生活仨月。日本什么好玩、什么好吃、哪里最值得去，问我就没错！\n\n日本有一句俗话：想看山，有「富士」，要泡温泉到「别府」，看海就请到「濑户内」。在日本这个岛国，濑户内海能被列为海的代表，足见其魅力，而这里除了天然的海景，最让人心驰神往的，还要数充满了艺术气息的各个岛屿。这次我就要带你到其中两座具有代表性的艺术之岛，来一场清新舒缓的人文之旅。\n\n这次旅程，我们要改变通常的交通方式，乘坐渡轮或汽船往来于海岛。在濑户内海这片与世隔绝的文艺净域之上，绝不走马观花，放弃打卡血拼；不看繁华，不寻名胜。而是去和安藤忠雄、草间弥生、莫奈等伟大的名字相遇，呼吸带着艺术的空气，把时间挥霍在对美的探求之中。","cityID":52,"title":"濑户内海艺术双岛","shareImageWechat":"http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg","isPurchased":true,"purchasedTimes":1974,"banmiID":49,"sequence":-898,"shareContent":"直岛·丰岛美术馆巡礼","videoURL":"","shareTitle":"濑户内内海艺术巡礼","price":"1.9","intro":"直岛·丰岛美术馆巡礼","shareURL":"http://banmi.com/app2017/route3.html?id=196&referer=7835","id":196,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg","isCollected":true},"reviews":[{"createdAt":"2月前","images":[],"userPhoto":"http://media.banmi.com/photos/1451977372348_ecafb592064dc3a57adb4f0d9de6a03c","userName":"柳吱吱","reviewID":2830,"content":"冲着心脏音博物馆去的，很早之前就看过介绍，真得值得"},{"createdAt":"2月前","images":[],"userPhoto":"http://media.banmi.com/photos/1450029418632_fa2a08c26814273ff188de5d783b7f65","userName":"绿色的煎茶盒子","reviewID":2821,"content":"今年要去艺术祭，好期待，跟着线路走透透，耶！"},{"createdAt":"4月前","images":[],"userPhoto":"http://media.banmi.com/photos/1449799173935_641bec90206a1126c31f3509a216be1d","userName":"Hannah","reviewID":2724,"content":"攻略里说的古民居一带非常值得一逛，虽然岛上那些网红的艺术馆也是不能错过，但逛这里更能融入到当地人的生活里的感觉，不像是在逛景点，喜欢这种感觉~"}],"banmi":{"occupation":"互联网公司高管 多元文化爱好者","name":"CharlieChee","photo":"http://cdn.banmi.com/banmiapp/rahdna/1521227637951_18ec1e9841d98c62b39b5e132ddafe6a.jpg","location":"北京","id":49,"introduction":"你好！我是Charlie，是一个超级日范，每年至少会在日本生活仨月，日本哪里好玩，什么好吃，问我就没错！\n我很喜欢记录我在旅行中的点点滴滴，更喜欢收集不同地方的故事，每次和朋友们分享那些我在旅途中的见闻，还有那些他们听都没听过的故事，都能刷新他们的三观~\n我希望能够把我更多的见闻分享给你，一起看看世界多大多美好！","photo4":"http://cdn.banmi.com/banmiapp/rahdna/1521227637951_18ec1e9841d98c62b39b5e132ddafe6a.jpg"},"reviewsCount":29,"carousel":["http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg"]}
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
         * route : {"priceInCents":190,"city":"日本·四国地区","description":"你好！我是Charlie，是一个超级日范，每年至少会在日本生活仨月。日本什么好玩、什么好吃、哪里最值得去，问我就没错！\n\n日本有一句俗话：想看山，有「富士」，要泡温泉到「别府」，看海就请到「濑户内」。在日本这个岛国，濑户内海能被列为海的代表，足见其魅力，而这里除了天然的海景，最让人心驰神往的，还要数充满了艺术气息的各个岛屿。这次我就要带你到其中两座具有代表性的艺术之岛，来一场清新舒缓的人文之旅。\n\n这次旅程，我们要改变通常的交通方式，乘坐渡轮或汽船往来于海岛。在濑户内海这片与世隔绝的文艺净域之上，绝不走马观花，放弃打卡血拼；不看繁华，不寻名胜。而是去和安藤忠雄、草间弥生、莫奈等伟大的名字相遇，呼吸带着艺术的空气，把时间挥霍在对美的探求之中。","cityID":52,"title":"濑户内海艺术双岛","shareImageWechat":"http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg","isPurchased":true,"purchasedTimes":1974,"banmiID":49,"sequence":-898,"shareContent":"直岛·丰岛美术馆巡礼","videoURL":"","shareTitle":"濑户内内海艺术巡礼","price":"1.9","intro":"直岛·丰岛美术馆巡礼","shareURL":"http://banmi.com/app2017/route3.html?id=196&referer=7835","id":196,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg","isCollected":true}
         * reviews : [{"createdAt":"2月前","images":[],"userPhoto":"http://media.banmi.com/photos/1451977372348_ecafb592064dc3a57adb4f0d9de6a03c","userName":"柳吱吱","reviewID":2830,"content":"冲着心脏音博物馆去的，很早之前就看过介绍，真得值得"},{"createdAt":"2月前","images":[],"userPhoto":"http://media.banmi.com/photos/1450029418632_fa2a08c26814273ff188de5d783b7f65","userName":"绿色的煎茶盒子","reviewID":2821,"content":"今年要去艺术祭，好期待，跟着线路走透透，耶！"},{"createdAt":"4月前","images":[],"userPhoto":"http://media.banmi.com/photos/1449799173935_641bec90206a1126c31f3509a216be1d","userName":"Hannah","reviewID":2724,"content":"攻略里说的古民居一带非常值得一逛，虽然岛上那些网红的艺术馆也是不能错过，但逛这里更能融入到当地人的生活里的感觉，不像是在逛景点，喜欢这种感觉~"}]
         * banmi : {"occupation":"互联网公司高管 多元文化爱好者","name":"CharlieChee","photo":"http://cdn.banmi.com/banmiapp/rahdna/1521227637951_18ec1e9841d98c62b39b5e132ddafe6a.jpg","location":"北京","id":49,"introduction":"你好！我是Charlie，是一个超级日范，每年至少会在日本生活仨月，日本哪里好玩，什么好吃，问我就没错！\n我很喜欢记录我在旅行中的点点滴滴，更喜欢收集不同地方的故事，每次和朋友们分享那些我在旅途中的见闻，还有那些他们听都没听过的故事，都能刷新他们的三观~\n我希望能够把我更多的见闻分享给你，一起看看世界多大多美好！","photo4":"http://cdn.banmi.com/banmiapp/rahdna/1521227637951_18ec1e9841d98c62b39b5e132ddafe6a.jpg"}
         * reviewsCount : 29
         * carousel : ["http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg"]
         */
        private RouteEntity route;
        private List<ReviewsEntity> reviews;
        private BanmiEntity banmi;
        private int reviewsCount;
        private List<String> carousel;

        public void setRoute(RouteEntity route) {
            this.route = route;
        }

        public void setReviews(List<ReviewsEntity> reviews) {
            this.reviews = reviews;
        }

        public void setBanmi(BanmiEntity banmi) {
            this.banmi = banmi;
        }

        public void setReviewsCount(int reviewsCount) {
            this.reviewsCount = reviewsCount;
        }

        public void setCarousel(List<String> carousel) {
            this.carousel = carousel;
        }

        public RouteEntity getRoute() {
            return route;
        }

        public List<ReviewsEntity> getReviews() {
            return reviews;
        }

        public BanmiEntity getBanmi() {
            return banmi;
        }

        public int getReviewsCount() {
            return reviewsCount;
        }

        public List<String> getCarousel() {
            return carousel;
        }

        public class RouteEntity {
            /**
             * priceInCents : 190
             * city : 日本·四国地区
             * description : 你好！我是Charlie，是一个超级日范，每年至少会在日本生活仨月。日本什么好玩、什么好吃、哪里最值得去，问我就没错！

             日本有一句俗话：想看山，有「富士」，要泡温泉到「别府」，看海就请到「濑户内」。在日本这个岛国，濑户内海能被列为海的代表，足见其魅力，而这里除了天然的海景，最让人心驰神往的，还要数充满了艺术气息的各个岛屿。这次我就要带你到其中两座具有代表性的艺术之岛，来一场清新舒缓的人文之旅。

             这次旅程，我们要改变通常的交通方式，乘坐渡轮或汽船往来于海岛。在濑户内海这片与世隔绝的文艺净域之上，绝不走马观花，放弃打卡血拼；不看繁华，不寻名胜。而是去和安藤忠雄、草间弥生、莫奈等伟大的名字相遇，呼吸带着艺术的空气，把时间挥霍在对美的探求之中。
             * cityID : 52
             * title : 濑户内海艺术双岛
             * shareImageWechat : http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg
             * isPurchased : true
             * purchasedTimes : 1974
             * banmiID : 49
             * sequence : -898
             * shareContent : 直岛·丰岛美术馆巡礼
             * videoURL :
             * shareTitle : 濑户内内海艺术巡礼
             * price : 1.9
             * intro : 直岛·丰岛美术馆巡礼
             * shareURL : http://banmi.com/app2017/route3.html?id=196&referer=7835
             * id : 196
             * cardURL : http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg
             * isCollected : true
             */
            private int priceInCents;
            private String city;
            private String description;
            private int cityID;
            private String title;
            private String shareImageWechat;
            private boolean isPurchased;
            private int purchasedTimes;
            private int banmiID;
            private int sequence;
            private String shareContent;
            private String videoURL;
            private String shareTitle;
            private String price;
            private String intro;
            private String shareURL;
            private int id;
            private String cardURL;
            private boolean isCollected;

            public void setPriceInCents(int priceInCents) {
                this.priceInCents = priceInCents;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setCityID(int cityID) {
                this.cityID = cityID;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setShareImageWechat(String shareImageWechat) {
                this.shareImageWechat = shareImageWechat;
            }

            public void setIsPurchased(boolean isPurchased) {
                this.isPurchased = isPurchased;
            }

            public void setPurchasedTimes(int purchasedTimes) {
                this.purchasedTimes = purchasedTimes;
            }

            public void setBanmiID(int banmiID) {
                this.banmiID = banmiID;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public void setShareContent(String shareContent) {
                this.shareContent = shareContent;
            }

            public void setVideoURL(String videoURL) {
                this.videoURL = videoURL;
            }

            public void setShareTitle(String shareTitle) {
                this.shareTitle = shareTitle;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public void setShareURL(String shareURL) {
                this.shareURL = shareURL;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setCardURL(String cardURL) {
                this.cardURL = cardURL;
            }

            public void setIsCollected(boolean isCollected) {
                this.isCollected = isCollected;
            }

            public int getPriceInCents() {
                return priceInCents;
            }

            public String getCity() {
                return city;
            }

            public String getDescription() {
                return description;
            }

            public int getCityID() {
                return cityID;
            }

            public String getTitle() {
                return title;
            }

            public String getShareImageWechat() {
                return shareImageWechat;
            }

            public boolean isIsPurchased() {
                return isPurchased;
            }

            public int getPurchasedTimes() {
                return purchasedTimes;
            }

            public int getBanmiID() {
                return banmiID;
            }

            public int getSequence() {
                return sequence;
            }

            public String getShareContent() {
                return shareContent;
            }

            public String getVideoURL() {
                return videoURL;
            }

            public String getShareTitle() {
                return shareTitle;
            }

            public String getPrice() {
                return price;
            }

            public String getIntro() {
                return intro;
            }

            public String getShareURL() {
                return shareURL;
            }

            public int getId() {
                return id;
            }

            public String getCardURL() {
                return cardURL;
            }

            public boolean isIsCollected() {
                return isCollected;
            }
        }

        public class ReviewsEntity {
            /**
             * createdAt : 2月前
             * images : []
             * userPhoto : http://media.banmi.com/photos/1451977372348_ecafb592064dc3a57adb4f0d9de6a03c
             * userName : 柳吱吱
             * reviewID : 2830
             * content : 冲着心脏音博物馆去的，很早之前就看过介绍，真得值得
             */
            private String createdAt;
            private List<String> images;
            private String userPhoto;
            private String userName;
            private int reviewID;
            private String content;

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            public void setUserPhoto(String userPhoto) {
                this.userPhoto = userPhoto;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public void setReviewID(int reviewID) {
                this.reviewID = reviewID;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public List<String> getImages() {
                return images;
            }

            public String getUserPhoto() {
                return userPhoto;
            }

            public String getUserName() {
                return userName;
            }

            public int getReviewID() {
                return reviewID;
            }

            public String getContent() {
                return content;
            }
        }

        public class BanmiEntity {
            /**
             * occupation : 互联网公司高管 多元文化爱好者
             * name : CharlieChee
             * photo : http://cdn.banmi.com/banmiapp/rahdna/1521227637951_18ec1e9841d98c62b39b5e132ddafe6a.jpg
             * location : 北京
             * id : 49
             * introduction : 你好！我是Charlie，是一个超级日范，每年至少会在日本生活仨月，日本哪里好玩，什么好吃，问我就没错！
             我很喜欢记录我在旅行中的点点滴滴，更喜欢收集不同地方的故事，每次和朋友们分享那些我在旅途中的见闻，还有那些他们听都没听过的故事，都能刷新他们的三观~
             我希望能够把我更多的见闻分享给你，一起看看世界多大多美好！
             * photo4 : http://cdn.banmi.com/banmiapp/rahdna/1521227637951_18ec1e9841d98c62b39b5e132ddafe6a.jpg
             */
            private String occupation;
            private String name;
            private String photo;
            private String location;
            private int id;
            private String introduction;
            private String photo4;

            public void setOccupation(String occupation) {
                this.occupation = occupation;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public void setPhoto4(String photo4) {
                this.photo4 = photo4;
            }

            public String getOccupation() {
                return occupation;
            }

            public String getName() {
                return name;
            }

            public String getPhoto() {
                return photo;
            }

            public String getLocation() {
                return location;
            }

            public int getId() {
                return id;
            }

            public String getIntroduction() {
                return introduction;
            }

            public String getPhoto4() {
                return photo4;
            }
        }
    }
}
