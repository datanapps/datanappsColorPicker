package datanapps.colorpicker.normalcolorpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import datanapps.colorpicker.R;

public class SimpleColorPickerActivity extends AppCompatActivity {


    private TextView tvBgColor;
    private TextView tvTextColor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBgColor = findViewById(R.id.tv_select_color);
        tvTextColor = findViewById(R.id.tv_app_name);

        setColorPickerRecycleView();

        findViewById(R.id.btn_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialogFragment fragment =  ColorPickerDialogFragment.newInstance();
                fragment.setOnColorPickerListener(new ColorPickerDialogFragment.OnDialogeColorPickerListener() {
                    @Override
                    public void onColorPickerClickListener(int colorCode) {
                        tvTextColor.setTextColor(colorCode);
                        tvBgColor.setBackgroundColor(colorCode);
                    }
                });

                fragment.show(getSupportFragmentManager(), "colorPickerDialogFragment");
            }
        });
    }


    private void setColorPickerRecycleView(){

        ColorPickerAdapter adapter = new ColorPickerAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_color_picker);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setOnColorPickerListener(new ColorPickerAdapter.OnColorPickerListener() {
            @Override
            public void onColorPickerClickListener(int colorCode) {
                tvTextColor.setTextColor(colorCode);
                tvBgColor.setBackgroundColor(colorCode);
            }
        });
    }




}
