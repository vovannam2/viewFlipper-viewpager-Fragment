package com.example.slideimageswithcircleindicator_viewpager;

import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private List<Images> imagesList;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpage);
        circleIndicator = findViewById(R.id.circle_indicator);

        imagesList = getListImages();
        ImagesViewPageAdapter adapter = new ImagesViewPageAdapter(imagesList);
        viewPager.setAdapter(adapter);

        // Liên kết viewpager và indicator
        circleIndicator.setViewPager(viewPager);

        // Khởi tạo handler và runnable
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (viewPager.getCurrentItem() == imagesList.size() - 1) {
                    viewPager.setCurrentItem(0);
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
                handler.postDelayed(this, 3000); // Chuyển ảnh sau 3 giây
            }
        };

        // Gọi runnable để bắt đầu tự động chuyển trang sau 3 giây
        handler.postDelayed(runnable, 3000);

        // Lắng nghe sự kiện khi ViewPager chuyển trang
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Không cần xử lý ở đây
            }

            @Override
            public void onPageSelected(int position) {
                // Khi trang được chọn, reset lại thời gian chạy auto-slide
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Không cần xử lý ở đây
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    private List<Images> getListImages() {
        List<Images> list = new ArrayList<>();
        list.add(new Images(R.drawable.quangcao));
        list.add(new Images(R.drawable.coffee));
        list.add(new Images(R.drawable.companypizza));
        list.add(new Images(R.drawable.java));
        return list;
    }
}
