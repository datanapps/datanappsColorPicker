package datanapps.colorpicker.sameinstagram;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import datanapps.colorpicker.R;
import datanapps.colorpicker.instagramwithmorecolor.InstagramPickerAdapter;

public class InstagramColorPickerActivity extends AppCompatActivity {


    private ImageView imgPicker1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_picker);

        imgPicker1 = findViewById(R.id.img_picker_1);

        setColorPickerRecycleView();


    }



    private void setColorPickerRecycleView(){

        ViewPager viewPager =  findViewById(R.id.instagram_viewpager);
        InstagramColorPagerAdapter mAdapter = new InstagramColorPagerAdapter(this, getSupportFragmentManager(), new InstagramColorPicker() {
            @Override
            public void onColorPickerClickListener(int colorCode, int tintColor) {
                LayerDrawable bgDrawable = (LayerDrawable) imgPicker1.getBackground();
                final GradientDrawable shape = (GradientDrawable)   bgDrawable.findDrawableByLayerId(R.id.shape_id);
                shape.setColor(colorCode);
                ImageViewCompat.setImageTintList(imgPicker1, ColorStateList.valueOf(tintColor));


            }
        });
        viewPager.setAdapter(mAdapter);
    }




}
