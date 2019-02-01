package datanapps.colorpicker.instagramwithmorecolor;

import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import datanapps.colorpicker.R;

public class InstagramWithMoreColorPickerActivity extends AppCompatActivity {


    private ImageView imgPicker2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_with_more_picker);

         imgPicker2 = findViewById(R.id.img_picker_2);



        setSmoothPickerRecycleView();
    }

    private void setSmoothPickerRecycleView() {

        InstagramPickerAdapter adapter = new InstagramPickerAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_instagram_color_picker);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setOnColorPickerListener(new InstagramPickerAdapter.OnColorPickerListener() {
            @Override
            public void onColorPickerClickListener(int colorCode) {


                LayerDrawable bgDrawable = (LayerDrawable) imgPicker2.getBackground();
                final GradientDrawable shape = (GradientDrawable)   bgDrawable.findDrawableByLayerId(R.id.shape_id);
                shape.setColor(colorCode);
            }
        });

    }







}
