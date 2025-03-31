package com.example.slideimageswithcircleindicator3_viewpager2;

import android.os.Bundle;
import android.os.Handler;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private List<Images> imagesList1;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize views
        viewPager2 = findViewById(R.id.viewpage2);
        circleIndicator3 = findViewById(R.id.circle_indicator3);

        // Initialize image list and adapter
        imagesList1 = getListImages();
        ImagesViewPager2Adapter adapter1 = new ImagesViewPager2Adapter(imagesList1);
        viewPager2.setAdapter(adapter1);
        circleIndicator3.setViewPager(viewPager2);

        // Initialize Handler and Runnable for auto-scrolling
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (viewPager2.getCurrentItem() == imagesList1.size() - 1) {
                    viewPager2.setCurrentItem(0);
                } else {
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                }
                handler.postDelayed(this, 3000);
            }
        };

        // Register page change callback to handle manual swipes
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }
        });

        // Apply page transformer (only one can be active at a time)
        // Option 1: Use ZoomOutPageTransformer
        viewPager2.setPageTransformer(new ZoomOutPageTransformer());

        // Option 2: Use DepthPageTransformer (comment out the above line and uncomment this one)
        // viewPager2.setPageTransformer(new DepthPageTransformer());

        // Start auto-scrolling
        handler.postDelayed(runnable, 3000);
    }

    private List<Images> getListImages() {
        List<Images> list = new ArrayList<>();
        list.add(new Images(R.drawable.quangcao));
        list.add(new Images(R.drawable.coffee));
        list.add(new Images(R.drawable.companypizza));
        list.add(new Images(R.drawable.java));
        return list;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop the handler to prevent memory leaks
        handler.removeCallbacks(runnable);
    }
}