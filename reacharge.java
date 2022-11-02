package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import android.os.Bundle;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.ArrayList;
import java.util.List;
public class reacharge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reacharge);
        Spinner spinner;
        ImageSlider imageSlider=findViewById(R.id.slider);
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://assets.airtel.in/teams/simplycms/web/images/banner-offring-new.png",""));
        slideModels.add(new SlideModel("https://cdn.grabon.in/gograbon/images/web-images/uploads/1618571198265/mobile-recharge-offers.jpg",""));
        slideModels.add(new SlideModel("https://www.flashsaletricks.com/wp-content/uploads/2017/07/Jio_399_plan_Recharge_Offer.jpg",""));
        slideModels.add(new SlideModel("https://www.jio.com/maha-cashback_jiocom-desk-1440x450.png",""));
        slideModels.add(new SlideModel("https://www.jio.com/newyearoffer_jio_tab_768x800px-inner.jpg",""));
        imageSlider.setImageList(slideModels,true);
    }
}