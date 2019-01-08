package datanapps.colorpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import datanapps.colorpicker.instagramcolorpicker.InstagramColorPickerActivity;
import datanapps.colorpicker.normalcolorpicker.ColorPickerAdapter;
import datanapps.colorpicker.normalcolorpicker.ColorPickerDialogFragment;
import datanapps.colorpicker.normalcolorpicker.SimpleColorPickerActivity;

public class ColorSelectionActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_selection);

        findViewById(R.id.btn_normal_color_picker).setOnClickListener(this);
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

        }
    }



}
