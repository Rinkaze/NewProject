package com.jiyun.bean;

import java.util.List;

/**
 * Created by 灵风 on 2019/4/17.
 */

public class SelectionsBean {

    /**
     * data : [{"thumbnail":"http://pic3.zhimg.com/91125c9aebcab1c84f58ce4f8779551e.jpg","name":"深夜惊奇","description":"看别人的经历，理解自己的生活","id":1},{"thumbnail":"https://pic3.zhimg.com/v2-48280d6d028fcca9fff19e296d204ece.jpg","name":"瞎扯","description":"随便扯扯，也能很有深度","id":2},{"thumbnail":"https://pic1.zhimg.com/v2-0b42f1a115f7d544e6eeea37b7772d04.jpg","name":"这里是广告","description":"","id":19},{"thumbnail":"https://pic4.zhimg.com/v2-d87fff35c0b2df5133ccbd11a55256cf.jpg","name":"放映机","description":"","id":28},{"thumbnail":"https://pic3.zhimg.com/v2-5f5f73f2b233c0699b7b9f13fb0ab52e.jpg","name":"大误","description":"","id":29},{"thumbnail":"https://pic2.zhimg.com/v2-da3d784dc7afe6746c07d4780da13531.jpg","name":"《职人介绍所》","description":"一个介绍职人的，所","id":33},{"thumbnail":"http://pic4.zhimg.com/7d15ff0bba64605edb4d300d31b2b8df.jpg","name":"读读日报 24 小时热门","description":"","id":34},{"thumbnail":"https://pic3.zhimg.com/v2-fbbcbf5188345f303677f0394aff78be.jpg","name":"小事","description":"生活无小事","id":35},{"thumbnail":"http://pic4.zhimg.com/66b875ef0c3a38041870a4e22c6684db.jpg","name":"选个好专业","description":"","id":36},{"thumbnail":"http://pic2.zhimg.com/7aa79413d88829ebc62056fefd0fd449.jpg","name":"上个好大学","description":"","id":37},{"thumbnail":"http://pic1.zhimg.com/e9a2431179660eb2af93cc621dfca164.jpg","name":"知乎好问题","description":"","id":38},{"thumbnail":"http://pic1.zhimg.com/921dd6c5d2477a0fc39fac3049e6f6ac.jpg","name":"16 年 9 月苹果秋季发布会","description":"","id":41},{"thumbnail":"http://pic2.zhimg.com/833a8ceb41b360e25043cecc843f6575.jpg","name":"发现中国","description":"","id":43},{"thumbnail":"http://pic3.zhimg.com/1b9cea03d2f682c5c876f63b39b4797e.jpg","name":"2016 诺贝尔奖巡礼","description":"","id":44},{"thumbnail":"http://pic1.zhimg.com/bb3013cd702700e7fe8bfbad04781960.jpg","name":"双十一","description":"","id":45},{"thumbnail":"http://pic2.zhimg.com/6d11425ea56ea566c9bb3ebc0b948865.jpg","name":"即使独自生活","description":"","id":46},{"thumbnail":"http://pic1.zhimg.com/522632f1bc771bf91743af4574b6aa94.jpg","name":"2016 美国大选","description":"","id":47},{"thumbnail":"http://pic3.zhimg.com/3c33b341cca41a1498901cf6a3e6c84e.jpg","name":"分享经济浪潮","description":"","id":48},{"thumbnail":"http://pic1.zhimg.com/dd5d2d591ece0ed7fb9ef6751ee012f0.jpg","name":"自由职业之路","description":"","id":50},{"thumbnail":"http://pic3.zhimg.com/485cde7a18d65b296551e1a5d386be8a.jpg","name":"运动在冬季","description":"","id":52},{"thumbnail":"http://pic3.zhimg.com/581c48cc17b5bf7f58fef1d5556c4062.jpg","name":"出国去过冬","description":"","id":53},{"thumbnail":"http://pic1.zhimg.com/1a76843a978f28d71f171d67099b9c04.jpg","name":"健康真相 · HIV / 艾滋病","description":"","id":54},{"thumbnail":"http://pic1.zhimg.com/b5a94200f8393f88fcb61c455388dbe8.jpg","name":"2016 年度盘点","description":"","id":55},{"thumbnail":"http://pic1.zhimg.com/a663eff39792670f6935aa7c543b939c.jpg","name":"商业银行职业进阶之路","description":"","id":56},{"thumbnail":"http://pic1.zhimg.com/7c0e8ca06cf3ff1737f12f2cc79458ec.jpg","name":"NBA 赛场内外","description":"","id":57},{"thumbnail":"http://pic4.zhimg.com/514b57e473b596c9370a49697d493b3b.jpg","name":"我爱看美剧","description":"","id":58},{"thumbnail":"http://pic1.zhimg.com/8fdcf00d2761537d16ae42853f8d445c.jpg","name":"职业倦怠与跳槽须知","description":"","id":59},{"thumbnail":"http://pic2.zhimg.com/2f3808c8c9460d6d54b0f76adeec6761.jpg","name":"睡个好觉吧","description":"","id":60},{"thumbnail":"http://pic2.zhimg.com/3766f83f0421117877f5f68ba2f7f1b5.jpg","name":"拍一部电影","description":"","id":61},{"thumbnail":"http://pic2.zhimg.com/c80dc1d75700edafd9ba9d0dc1413c79.jpg","name":"人工智能 · 自动驾驶","description":"","id":62},{"thumbnail":"http://pic2.zhimg.com/3fb6d5e107f8dd46683a92499b6c618d.jpg","name":"基础护肤","description":"","id":63},{"thumbnail":"http://pic2.zhimg.com/4fac6e7a6611e29cf0acee6b201d32e5.jpg","name":"川菜不只麻辣","description":"","id":65},{"thumbnail":"http://pic3.zhimg.com/f92543bf7a95aa1564af213882a25132.jpg","name":"我遇到了网络侵权","description":"","id":67},{"thumbnail":"https://pic1.zhimg.com/v2-a13e5675056d6b604164ecbc03f827a8.jpg","name":"从零开始的儿童性教育","description":"","id":68},{"thumbnail":"https://pic2.zhimg.com/v2-ee8a63b520e46862e547171fc97265b5.jpg","name":"刘看山","description":"","id":69},{"thumbnail":"https://pic1.zhimg.com/v2-43c6f2cff22e6b2afeae20e11e7232b4.jpg","name":"日常经济学 · 博弈人生","description":"","id":70},{"thumbnail":"https://pic1.zhimg.com/v2-38552992004f74598eed6e70f1c1334c.jpg","name":"人工智能 · 机器感知","description":"","id":71},{"thumbnail":"https://pic2.zhimg.com/v2-6cd229bcad798552f8e49a4e4e121f55.jpg","name":"金融科技浪潮","description":"","id":72},{"thumbnail":"https://pic2.zhimg.com/v2-dc3663ba2fce78532094758a2f43fd2d.jpg","name":"十五分钟","description":"","id":73},{"thumbnail":"https://pic3.zhimg.com/v2-e9215749ec9303d01fd2add8f17f8122.jpg","name":"广告 · 天猫理想生活专栏","description":"","id":74},{"thumbnail":"https://pic2.zhimg.com/v2-d31d31fced6e7473de93b989df8eab71.jpg","name":"人机对弈终章","description":"","id":75},{"thumbnail":"https://pic1.zhimg.com/v2-be88e4a926e2d1da87886f5818704ee4.jpg","name":"职场头两年","description":"职场新人必备生存指南","id":76},{"thumbnail":"https://pic1.zhimg.com/v2-fda8777deb5d8aa97fe79ae0de5792c8.jpg","name":"日常经济学 · 我为什么这么穷","description":"","id":77},{"thumbnail":"https://pic1.zhimg.com/v2-28489a9ba7502794d84e8eec257d29f8.jpg","name":"每周一吸","description":"","id":78},{"thumbnail":"https://pic3.zhimg.com/v2-bc8e09a58987836ad042ce1b44c9551e.jpg","name":"节日特辑","description":"","id":79},{"thumbnail":"https://pic4.zhimg.com/v2-501dd4e67100cb240b7357f84c4b252f.jpg","name":"辉煌中国","description":"","id":81},{"thumbnail":"https://pic4.zhimg.com/v2-4640cd805bc86082ebacde5865de1c17.jpg","name":"假期去哪儿","description":"","id":82},{"thumbnail":"https://pic2.zhimg.com/v2-739a779b092cc1fc7d0d6060c9a4edb9.jpg","name":"放假好好吃","description":"","id":83},{"thumbnail":"https://pic1.zhimg.com/v2-fb9c7d8902bdcf037a9e90e4edf674e8.jpg","name":"宅在家里玩游戏","description":"","id":84},{"thumbnail":"https://pic3.zhimg.com/v2-50de10fa83788aa602ee0b5c27781cfe.jpg","name":"就练 15 分钟","description":"","id":85},{"thumbnail":"https://pic1.zhimg.com/v2-45d1b8f6a698f8a5ea803a960dd2c464.jpg","name":"人生的名义","description":"","id":86},{"thumbnail":"https://pic3.zhimg.com/v2-8c4e0a2513aa39d169848b3da443844e.jpg","name":"2017 诺奖巡礼","description":"","id":87},{"thumbnail":"https://pic4.zhimg.com/v2-ccb1a8eab2b262ad9a41fd8a47c2f0cf.jpg","name":"自己做的，了不起","description":"","id":88},{"thumbnail":"https://pic1.zhimg.com/v2-ee8f45196e1acbe6e5f3a9833ac8fb04.jpg","name":"双十一种草指南","description":"","id":89},{"thumbnail":"https://pic2.zhimg.com/v2-6811e08dec530c4d8792a73396832a45.jpg","name":"本周热门精选","description":"","id":90},{"thumbnail":"https://pic2.zhimg.com/v2-b9c10bf34b3d8cb7b0b156d0aef0de01.jpg","name":"圣诞来了","description":"","id":91},{"thumbnail":"https://pic2.zhimg.com/v2-6ca790823cce19d299e16b29df0e9d75.jpg","name":"2017 年度盘点","description":"","id":92},{"thumbnail":"https://pic4.zhimg.com/v2-3547f118a0ed44157247781b8473fe2f.jpg","name":"《旅行青蛙》","description":"","id":93},{"thumbnail":"https://pic3.zhimg.com/v2-66b0c47b3d1b27c1eb5ff937b27e6d22.jpg","name":"比特币 & 区块链","description":"","id":94},{"thumbnail":"https://pic2.zhimg.com/v2-6b68c6ceb90ff365e65e3fb88531708d.jpg","name":"腾讯等四巨头入股万达","description":"","id":95},{"thumbnail":"https://pic3.zhimg.com/v2-212d174f3b201a98f2b513d49d0a3c6e.jpg","name":"直播答题游戏","description":"","id":96},{"thumbnail":"https://pic1.zhimg.com/v2-f1e07deae30e13f8f98d6c01ad6834e8.jpg","name":"阿里是不是「大而不能倒」？","description":"","id":97},{"thumbnail":"https://pic2.zhimg.com/v2-c38dfcfe5ba3a61b1499412465fb5aa1.jpg","name":"女儿早恋，被父亲打至骨折","description":"","id":98},{"thumbnail":"https://pic3.zhimg.com/v2-387b30b6f6656b3f86fa5e6a0f7303de.jpg","name":"奥斯卡","description":"","id":99},{"thumbnail":"https://pic3.zhimg.com/v2-e6d654df7f11deffd0cc0248fef93c66.jpg","name":"城市青年避坑手册","description":"","id":100},{"thumbnail":"https://pic1.zhimg.com/v2-35ad61d30f6a8f8c9a058ace847eeb30.jpg","name":"315 消费者权益日","description":"","id":101},{"thumbnail":"https://pic3.zhimg.com/v2-b092de5d6657ab87914febf1b62447e2.jpg","name":"阿里收购饿了么","description":"","id":102},{"thumbnail":"https://pic3.zhimg.com/v2-7ca2179de0a681af79201cec70ecf926.jpg","name":"城市青年生活故事","description":"","id":103},{"thumbnail":"https://pic1.zhimg.com/v2-25cceb6d04b11cbe5e2da42551811e20.jpg","name":"汶川地震十周年纪念","description":"","id":104},{"thumbnail":"https://pic1.zhimg.com/v2-072286ebb1f49446e38f3e2a0933e930.jpg","name":"工作在国外","description":"","id":105},{"thumbnail":"https://pic4.zhimg.com/v2-986c6c82ff45427b85942da344853913.jpg","name":"那年我高考","description":"","id":106},{"thumbnail":"https://pic1.zhimg.com/v2-851ed43f6b2d0070d2a84c8d91412d60.jpg","name":"2018 世界杯","description":"","id":107},{"thumbnail":"https://pic1.zhimg.com/v2-bc399d4094d22b7357fabdc1c6b99c60.jpg","name":"报个好志愿","description":"","id":108},{"thumbnail":"https://pic4.zhimg.com/v2-29f7770064fd99281a2133a78c7e135b.jpg","name":"商业有意思","description":"商业的冰山一角，在这里无限放大","id":109},{"thumbnail":"https://pic4.zhimg.com/v2-1dbab70b737966b04a80f159b5e88afb.jpg","name":"Apple 特别活动 2018","description":"2018 年苹果发布会全解析","id":110},{"thumbnail":"https://pic3.zhimg.com/v2-8f0f0a14409d5d2fea6b938be36bf2d2.jpg","name":"夜宵不断档","description":"","id":111},{"thumbnail":"https://pic1.zhimg.com/v2-c60a50dc50c91fc8c3b05077558399f8.jpg","name":"游戏不断电","description":"","id":112},{"thumbnail":"https://pic4.zhimg.com/v2-09597578d0654eb13b96709d5508fd63.jpg","name":"互联网洞见者 2018","description":"","id":113},{"thumbnail":"https://pic1.zhimg.com/v2-d30532db2d6f80d1c8cf99b638eb4ff8.jpg","name":"双十一 2018","description":"2018 年双十一专题","id":114},{"thumbnail":"https://pic2.zhimg.com/v2-c0903776eea46ef6d3ccaf33e1bc1029.jpg","name":"2018 年度盘点","description":"2018 年，风口浓雾弥漫，浪潮暗涌起伏。","id":115}]
     */
    private List<DataEntity> data;

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public class DataEntity {
        /**
         * thumbnail : http://pic3.zhimg.com/91125c9aebcab1c84f58ce4f8779551e.jpg
         * name : 深夜惊奇
         * description : 看别人的经历，理解自己的生活
         * id : 1
         */
        private String thumbnail;
        private String name;
        private String description;
        private int id;

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getId() {
            return id;
        }
    }
}
