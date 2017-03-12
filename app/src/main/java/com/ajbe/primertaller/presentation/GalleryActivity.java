package com.ajbe.primertaller.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ajbe.primertaller.R;
import com.veinhorn.scrollgalleryview.MediaInfo;
import com.veinhorn.scrollgalleryview.ScrollGalleryView;
import com.veinhorn.scrollgalleryview.loader.DefaultImageLoader;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initVariables();
    }

    private void initVariables() {
        ScrollGalleryView scrollGalleryView = (ScrollGalleryView) findViewById(R.id.scroll_gallery_view);
        scrollGalleryView
                .setThumbnailSize(100)
                .setZoom(true)
                .setFragmentManager(getSupportFragmentManager())
                .addMedia(MediaInfo.mediaLoader(new DefaultImageLoader(R.drawable.pic_one)))
                .addMedia(MediaInfo.mediaLoader(new DefaultImageLoader(R.drawable.pic_two)))
                .addMedia(MediaInfo.mediaLoader(new DefaultImageLoader(R.drawable.pic_three)))
                .addMedia(MediaInfo.mediaLoader(new DefaultImageLoader(R.drawable.pic_four)))
                .addMedia(MediaInfo.mediaLoader(new DefaultImageLoader(R.drawable.pic_five)))
                .addMedia(MediaInfo.mediaLoader(new DefaultImageLoader(R.drawable.pic_six)))
                .addMedia(MediaInfo.mediaLoader(new DefaultImageLoader(R.drawable.pic_seven)))
                .addMedia(MediaInfo.mediaLoader(new DefaultImageLoader(R.drawable.pic_eight)))
                .addMedia(MediaInfo.mediaLoader(new DefaultImageLoader(R.drawable.pic_nine)))
                .addMedia(MediaInfo.mediaLoader(new DefaultImageLoader(R.drawable.pic_ten)));
    }

}
