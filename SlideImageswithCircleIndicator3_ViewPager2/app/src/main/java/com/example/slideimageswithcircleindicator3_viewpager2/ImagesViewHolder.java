package com.example.slideimageswithcircleindicator3_viewpager2;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImagesViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;

    public ImagesViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imgView);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
