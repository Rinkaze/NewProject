package com.jiyun.bean;

import java.util.List;

/**
 * Created by 灵风 on 2019/4/17.
 */

public class HotBean {

    /**
     * recent : [{"thumbnail":"https://pic4.zhimg.com/v2-8566d3cca46a81ec8e7e1ef1e8ef4ea7.jpg","title":"瞎扯 · 如何正确地吐槽","news_id":9710222,"url":"http://news-at.zhihu.com/api/2/news/9710222"},{"thumbnail":"https://pic3.zhimg.com/v2-316f0c9dda2ad2d105f54b81a7678cb2.jpg","title":"瞎扯 · 如何正确地吐槽","news_id":9710228,"url":"http://news-at.zhihu.com/api/2/news/9710228"},{"thumbnail":"https://pic3.zhimg.com/v2-48280d6d028fcca9fff19e296d204ece.jpg","title":"瞎扯 · 如何正确地吐槽","news_id":9710274,"url":"http://news-at.zhihu.com/api/2/news/9710274"},{"thumbnail":"https://pic2.zhimg.com/v2-77cb5ef964fd5d32936d01c84639cf31.jpg","title":"一个巨大的汽车行业潜规则，就这么不经意间捅了出来","news_id":9710258,"url":"http://news-at.zhihu.com/api/2/news/9710258"},{"thumbnail":"https://pic4.zhimg.com/v2-d1748b3f059dca51368042d995abda03.jpg","title":"小事 · 那些值得你去奋斗一生的事","news_id":9709999,"url":"http://news-at.zhihu.com/api/2/news/9709999"},{"thumbnail":"https://pic3.zhimg.com/v2-d65aea1c7746282370929e536a0aba96.jpg","title":"小事 · 你有童年阴影吗？","news_id":9709844,"url":"http://news-at.zhihu.com/api/2/news/9709844"},{"thumbnail":"https://pic3.zhimg.com/v2-147b6cc36ebe1653cec5f021ad05acee.jpg","title":"来，一起欣赏下马云关于 996 的那篇「高分作文」","news_id":9710264,"url":"http://news-at.zhihu.com/api/2/news/9710264"},{"thumbnail":"https://pic3.zhimg.com/v2-fbbcbf5188345f303677f0394aff78be.jpg","title":"小事 · 为什么你无法把孩子培养成「精英」","news_id":9710259,"url":"http://news-at.zhihu.com/api/2/news/9710259"},{"thumbnail":"https://pic2.zhimg.com/v2-8ddd6727080a8fc41ff9af77ac63524d.jpg","title":"美国医生比中国医生强吗？","news_id":9709736,"url":"http://news-at.zhihu.com/api/2/news/9709736"},{"thumbnail":"https://pic4.zhimg.com/v2-d87fff35c0b2df5133ccbd11a55256cf.jpg","title":"「权游」最终季第 1 集：最好最好的重逢，久违了","news_id":9710248,"url":"http://news-at.zhihu.com/api/2/news/9710248"},{"thumbnail":"https://pic3.zhimg.com/v2-166961b2066fc0e91dbc559cbdbf5f26.jpg","title":"「快速充电」的原理是什么，目前的快充技术存在哪些亮点和缺陷？","news_id":9710154,"url":"http://news-at.zhihu.com/api/2/news/9710154"},{"thumbnail":"https://pic1.zhimg.com/v2-9a924cf60c0f490cb4b39c87718e179c.jpg","title":"为什么现在球员的绰号越来越\u2026\u2026没逼格？","news_id":9710201,"url":"http://news-at.zhihu.com/api/2/news/9710201"},{"thumbnail":"https://pic3.zhimg.com/v2-3cd88bc0d9d888ffd947b01b38b6544a.jpg","title":"三星 Galaxy Fold：它是一台手机，但屏幕告诉你它不是","news_id":9710289,"url":"http://news-at.zhihu.com/api/2/news/9710289"},{"thumbnail":"https://pic1.zhimg.com/v2-4ed990f73c2250c59b05cbd39e3ec898.jpg","title":"在完全断电的情况下，用水泡电脑主板再完全晾干，会发生什么？","news_id":9710217,"url":"http://news-at.zhihu.com/api/2/news/9710217"},{"thumbnail":"https://pic1.zhimg.com/v2-5725c7921fd5108d08d2d5d98f94fb14.jpg","title":"孩子才 2 岁，要不要带出去看世界？","news_id":9710238,"url":"http://news-at.zhihu.com/api/2/news/9710238"},{"thumbnail":"https://pic2.zhimg.com/v2-a2649cebf8762dec99c8f21da7eaaefd.jpg","title":"NBA 球员是不是世界上打篮球最强的四百个人？","news_id":9710229,"url":"http://news-at.zhihu.com/api/2/news/9710229"},{"thumbnail":"https://pic3.zhimg.com/v2-927b72fe1ea8562b14544bc222069586.jpg","title":"被正面表达的诉求，才有被解决的可能","news_id":9710298,"url":"http://news-at.zhihu.com/api/2/news/9710298"},{"thumbnail":"https://pic2.zhimg.com/v2-9cdc4b2a57325d83f171a5675485e655.jpg","title":"用游戏「实地」图解：巴黎圣母院为什么会着火？","news_id":9710280,"url":"http://news-at.zhihu.com/api/2/news/9710280"},{"thumbnail":"https://pic2.zhimg.com/v2-02a27dd408896294bec205f57966d6c5.jpg","title":"为什么生物的感知器官都集中在头部？","news_id":9710245,"url":"http://news-at.zhihu.com/api/2/news/9710245"},{"thumbnail":"https://pic1.zhimg.com/v2-9d22c120d2206f4c31f9525cab5027f8.jpg","title":"「超级视力」来了，经过改造的小鼠可裸眼看见红外线","news_id":9710284,"url":"http://news-at.zhihu.com/api/2/news/9710284"}]
     */
    private List<RecentEntity> recent;

    public void setRecent(List<RecentEntity> recent) {
        this.recent = recent;
    }

    public List<RecentEntity> getRecent() {
        return recent;
    }

    public class RecentEntity {
        /**
         * thumbnail : https://pic4.zhimg.com/v2-8566d3cca46a81ec8e7e1ef1e8ef4ea7.jpg
         * title : 瞎扯 · 如何正确地吐槽
         * news_id : 9710222
         * url : http://news-at.zhihu.com/api/2/news/9710222
         */
        private String thumbnail;
        private String title;
        private int news_id;
        private String url;

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public int getNews_id() {
            return news_id;
        }

        public String getUrl() {
            return url;
        }
    }
}
