package com.manage.demoapp.organizationmanage.ui;


import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.manage.demoapp.R;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Create by peter
 * Date 2018-12-28  19:30
 * Description:
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {
    List<LocalMedia> list;
    private WeakReference<Activity> weakReference;
    private LayoutInflater inflater;
    public static final int MAX = 5;
    private int noDataDrawId;
    private boolean isEdited;
    /**
     * 点击添加图片跳转
     */
    private onAddPicClickListener mOnAddPicClickListener;

    public PictureAdapter(List<LocalMedia> list, Activity activity, @DrawableRes int noDataDrawId,onAddPicClickListener mOnAddPicClickListener,boolean isEdited) {
        this.list = list;
        this.weakReference = new WeakReference<>(activity);
        this.inflater = LayoutInflater.from(activity);
        this.mOnAddPicClickListener = mOnAddPicClickListener;
        this.noDataDrawId = noDataDrawId;
        this.isEdited = isEdited;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.gv_filter_image,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (!isEdited){//不需要编辑
            holder.ll_del.setVisibility(View.INVISIBLE);
        }
        int newPos;
        if (MAX > list.size()) {
            newPos = position - 1;
        } else {
            newPos = position;
        }
        if (newPos == -1) {//小于MAX
            if (list.size() == 0 && isEdited){
                holder.mImg.setImageResource(noDataDrawId);
            }
            if(isEdited){
                //点击添加图片
                holder.mImg.setOnClickListener(v -> mOnAddPicClickListener.onAddPicClick());
                holder.ll_del.setVisibility(View.INVISIBLE);
            }

        } else {//图片已够
            if (isEdited){
                holder.ll_del.setVisibility(View.VISIBLE);
                holder.ll_del.setOnClickListener(v -> {
                    //移除图片
                    list.remove(newPos);
                    notifyDataSetChanged();
                });
            }
            LocalMedia media = list.get(newPos);
            String path;
            if (media.isCut() && !media.isCompressed()) {
                // 裁剪过
                path = media.getCutPath();
            } else if (media.isCompressed() || (media.isCut() && media.isCompressed())) {
                // 压缩过,或者裁剪同时压缩过,以最终压缩过图片为准
                path = media.getCompressPath();
            } else {
                // 原图
                path = media.getPath();
            }
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.color.white)
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(holder.itemView.getContext())
                    .load(path)
                    .apply(options)
                    .into(holder.mImg);
            //itemView 的点击事件
            holder.itemView.setOnClickListener(v -> {
                // 预览图片
                PictureSelector.create(weakReference.get()).themeStyle(R.style.picture_default_style).openExternalPreview(newPos, list);
            });
        }


    }

    @Override
    public int getItemCount() {
        //少于MAX时要加一张添加按钮的图
        if (list.size() >= MAX) {
            return MAX;
        } else {
            return list.size() + 1;
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImg;
        LinearLayout ll_del;

        public ViewHolder(View view) {
            super(view);
            mImg = view.findViewById(R.id.fiv);
            ll_del = view.findViewById(R.id.ll_del);
        }
    }

    public interface onAddPicClickListener {
        void onAddPicClick();
    }
}
