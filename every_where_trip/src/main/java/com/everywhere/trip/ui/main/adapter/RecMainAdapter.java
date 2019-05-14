package com.everywhere.trip.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.everywhere.trip.R;
import com.everywhere.trip.bean.MainDataBean;
import com.everywhere.trip.util.GlideUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 灵风 on 2019/5/5.
 */

public class RecMainAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<MainDataBean.ResultEntity.BannersEntity> banners;
    private List<MainDataBean.ResultEntity.RoutesEntity> routes;
    final int BANNER_STYLE = 0;
    final int ITEM_STYLE = 1;
    final int BUNDLE_STYLE = 2;

    public RecMainAdapter(Context context) {
        this.context = context;
        banners = new ArrayList<>();
        routes = new ArrayList<>();
    }

    public void setBanners(List<MainDataBean.ResultEntity.BannersEntity> banners) {
        this.banners = banners;
        notifyDataSetChanged();
    }

    public void setRoutes(List<MainDataBean.ResultEntity.RoutesEntity> routes) {
        this.routes = routes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BANNER_STYLE) {
            return new BannerHolder(View.inflate(context, R.layout.item_banner, null));
        } else if (viewType == ITEM_STYLE){
            return new ItemHolder(View.inflate(context, R.layout.item_routes, null));
        }else {
            return new BundleHolder(View.inflate(context, R.layout.item_bundle, null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == BANNER_STYLE) {
            BannerHolder bannerHolder = (BannerHolder) holder;
            bannerHolder.banner.setImages(banners)
                    .setDelayTime(3000)
                    .setBannerStyle(BannerConfig.NOT_INDICATOR)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            MainDataBean.ResultEntity.BannersEntity path1 = (MainDataBean.ResultEntity.BannersEntity) path;
                            Glide.with(context).load(path1.getImageURL()).into(imageView);
                        }
                    })
                    .start();
        } else if (getItemViewType(position) == ITEM_STYLE) {
            int index = position;
            if (banners.size() > 0) {
                index -= 1;
            }
            ItemHolder itemHolder = (ItemHolder) holder;
            MainDataBean.ResultEntity.RoutesEntity entity = routes.get(index);

            itemHolder.purchasedTimes.setText(entity.getPurchasedTimes() + "人购买");
            itemHolder.intro.setText(entity.getIntro());
            if (entity.isIsPurchased()) {
                itemHolder.btnPay.setBackgroundColor(context.getResources().getColor(R.color.c_cecece));
                itemHolder.btnPay.setText("已购买");
            }
            itemHolder.city.setText(entity.getCity());
            itemHolder.title.setText(entity.getTitle());
            RequestOptions options = new RequestOptions()
                    .placeholder(R.mipmap.zhanweitu_home_kapian)
                    .error(R.mipmap.zhanweitu_home_kapian);
            Glide.with(context)
                    .load(entity.getCardURL())
                    .apply(options)
                    .into(itemHolder.bigImg);
            final int finalIndex = index;
            itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null){
                        onItemClickListener.onClick(v, finalIndex);
                    }
                }
            });
        }else {
            int index = position;
            if (banners.size() > 0) {
                index -= 1;
            }
            final MainDataBean.ResultEntity.RoutesEntity entity = routes.get(index);
            BundleHolder bundleHolder = (BundleHolder) holder;
            GlideUtil.loadUrlImage(R.mipmap.zhanweitu_home_kapian,R.mipmap.zhanweitu_home_kapian,
                    entity.getCardURL(),bundleHolder.bigImg,context);
            bundleHolder.bigImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onBundleClickListener != null){
                        onBundleClickListener.onClick(entity.getContentURL(),entity.getTitle());
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if (banners.size() > 0) {
            return routes.size() + 1;
        } else {
            return routes.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && banners.size() > 0) {
            return BANNER_STYLE;
        } else {
            int index = position;
            if (banners.size() > 0) {
                index -= 1;
            }
            if (!TextUtils.isEmpty(routes.get(index).getType()) && routes.get(index).getType().equals("bundle")) {
                return BUNDLE_STYLE;
            } else {
                return ITEM_STYLE;
            }
        }
    }

    class BannerHolder extends RecyclerView.ViewHolder {

        Banner banner;

        public BannerHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        ImageView bigImg;
        TextView title;
        TextView city;
        Button btnPay;
        TextView intro;
        TextView purchasedTimes;

        public ItemHolder(View itemView) {
            super(itemView);
            bigImg = itemView.findViewById(R.id.bg_img);
            title = itemView.findViewById(R.id.title);
            city = itemView.findViewById(R.id.city);
            btnPay = itemView.findViewById(R.id.btn_pay);
            intro = itemView.findViewById(R.id.intro);
            purchasedTimes = itemView.findViewById(R.id.purchasedTimes);
        }
    }

    class BundleHolder extends RecyclerView.ViewHolder {

        ImageView bigImg;

        public BundleHolder(View itemView) {
            super(itemView);
            bigImg = itemView.findViewById(R.id.bg_img);
        }
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(View view,int position);
    }

    private OnBundleClickListener onBundleClickListener;

    public void setOnBundleClickListener(OnBundleClickListener onBundleClickListener) {
        this.onBundleClickListener = onBundleClickListener;
    }

    public interface OnBundleClickListener{
        void onClick(String url,String title);
    }
}
