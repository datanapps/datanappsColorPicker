package datanapps.colorpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import datanapps.colorpicker.instagramwithmorecolor.InstagramWithMoreColorPickerActivity;
import datanapps.colorpicker.sameinstagram.InstagramColorPickerActivity;
import datanapps.colorpicker.normalcolorpicker.SimpleColorPickerActivity;



/*
* This is main color picker selection screen  
*
* */
public class ColorSelectionActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_selection);

        findViewById(R.id.btn_normal_color_picker).setOnClickListener(this);

        findViewById(R.id.btn_normal_color_like_instagram).setOnClickListener(this);

        findViewById(R.id.btn_normal_color_instagram).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_normal_color_picker :
                startActivity(new Intent(ColorSelectionActivity.this, SimpleColorPickerActivity.class));
                break;
            case R.id.btn_normal_color_instagram :
                startActivity(new Intent(ColorSelectionActivity.this, InstagramColorPickerActivity.class));
                break;

            case R.id.btn_normal_color_like_instagram :
                startActivity(new Intent(ColorSelectionActivity.this, InstagramWithMoreColorPickerActivity.class));
                break;

        }
    }



}
