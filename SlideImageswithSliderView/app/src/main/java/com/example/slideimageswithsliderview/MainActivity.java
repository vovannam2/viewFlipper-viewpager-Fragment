package com.example.slideimageswithsliderview;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Trong phương thức onCreate() hoặc nơi khởi tạo view
        SliderView sliderView = findViewById(R.id.imageSlider);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.kotlin);
        arrayList.add(R.drawable.mongodb);
        arrayList.add(R.drawable.nodejs); // Sửa lại từ shoppe1 thành shoppe3 nếu cần
        arrayList.add(R.drawable.php);

        SliderAdapter sliderAdapter = new SliderAdapter(getApplicationContext(), arrayList); // Sửa SliderAdapter thành sliderAdapter (chữ thường)
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(getResources().getColor(R.color.red));
        sliderView.setIndicatorUnselectedColor(Color.GRAY); // Sửa SRAY thành GRAY
        sliderView.startAutoCycle();
        sliderView.setScrollTimeInSec(5);
    }
}





