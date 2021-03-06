package com.geniusgithub.lookaround.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ImageLoader {

//    private static int THUMBNAIL_SIZE = 120;


    public static void loadThumail(Context context, String url, ImageView iv) {    //使用Glide加载缩略图，仅缓存转换后的图片,不使用占位图
        loadThumail(context, url, iv, null);
    }

    public static void loadThumail(Context context, String url, ImageView iv, Drawable defaultDrawable) {    //使用Glide加载缩略图，仅缓存转换后的图片,使用占位图
        Glide.with(context).load(url).crossFade().placeholder(defaultDrawable).diskCacheStrategy(DiskCacheStrategy.RESULT).into(iv);
    }

    public static void loadSource(Context context, String url, ImageView iv) {    //使用Glide加载原图片,不使用占位图
        loadSource(context, url, iv, null);
    }

    public static void loadSource(Context context, String url, ImageView iv, Drawable defaultDrawable) {    //使用Glide加载原图片,使用占位图
        Glide.with(context).load(url).crossFade().placeholder(defaultDrawable).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
    }

    public static void clearTask(Context context){
            Glide.with(context).onDestroy();
    }

    public static void pauseRequests(Context context){
        Glide.with(context).pauseRequests();
    }

    public static void resumeRequests(Context context){
        Glide.with(context).resumeRequests();
    }

}
