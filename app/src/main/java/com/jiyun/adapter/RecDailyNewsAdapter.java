package com.jiyun.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.bean.DailyNewsBean;
import com.jiyun.day03.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 灵风 on 2019/4/17.
 */

public class RecDailyNewsAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<DailyNewsBean.StoriesEntity> stories;
    private ArrayList<DailyNewsBean.Top_storiesEntity> topStories;
    private final int BANNER_TYPE = 1;
    private final int TIME_TYPE = 2;
    private final int NEWS_TYPE = 3;
    private String time = "今日热点";

    public RecDailyNewsAdapter(Context context,
                               ArrayList<DailyNewsBean.StoriesEntity> stories,
                               ArrayList<DailyNewsBean.Top_storiesEntity> topStories) {

        this.context = context;
        this.stories = stories;
        this.topStories = topStories;
    }

    public void setStories(ArrayList<DailyNewsBean.StoriesEntity> stories) {
        this.stories = stories;
        notifyDataSetChanged();
    }

    public void setTopStories(ArrayList<DailyNewsBean.Top_storiesEntity> topStories) {
        this.topStories = topStories;
        notifyDataSetChanged();
    }

    public void setTime(String time) {
        this.time = time;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BANNER_TYPE){
            return new BannerHolder(View.inflate(context,R.layout.banner_item,null));
        } else if (viewType == TIME_TYPE) {
            return new TimeHolder(View.inflate(context,R.layout.time_item,null));
        } else {
            return new NewsHolder(View.inflate(context,R.layout.dailynews_item,null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER_TYPE){
            BannerHolder bannerHolder = (BannerHolder) holder;
            ArrayList<String> titles = new ArrayList<>();
            for (DailyNewsBean.Top_storiesEntity topStory : topStories) {
                titles.add(topStory.getTitle());
            }
            bannerHolder.banner.setImages(topStories)
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            DailyNewsBean.Top_storiesEntity path1 = (DailyNewsBean.Top_storiesEntity) path;
                            Glide.with(context).load(path1.getImage()).into(imageView);
                        }
                    })
                    .setBannerTitles(titles)
                    .setDelayTime(3000)
                    .start();
        } else if (getItemViewType(position) == TIME_TYPE) {
            TimeHolder timeHolder = (TimeHolder) holder;
            timeHolder.tvTime.setText(time);
        } else {
            NewsHolder newsHolder = (NewsHolder) holder;
            int index = position - 1;
            if (topStories.size()>0){
                index -= 1;
            }
            DailyNewsBean.StoriesEntity entity = stories.get(index);
            Glide.with(context)
                    .load(entity.getImages().get(0))
                    .into(newsHolder.img);
            newsHolder.title.setText(entity.getTitle());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (topStories.size()>0){
            if (position == 0){
                return BANNER_TYPE;
            }else if (position == 1){
                return TIME_TYPE;
            }else {
                return NEWS_TYPE;
            }
        }else {
            if (position == 0){
                return TIME_TYPE;
            }else {
                return NEWS_TYPE;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (topStories.size()>0){
            return 1+1+stories.size();
        }else {
            return 1+stories.size();
        }
    }

    class BannerHolder extends RecyclerView.ViewHolder {

        Banner banner;

        public BannerHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    class TimeHolder extends RecyclerView.ViewHolder {

        TextView tvTime;

        public TimeHolder(View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tv_time);
        }
    }

    class NewsHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;

        public NewsHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
}
