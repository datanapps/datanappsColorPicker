package datanapps.colorpicker.normalcolorpicker;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import datanapps.colorpicker.R;

public class ColorPickerDialogFragment extends BottomSheetDialogFragment{


    OnDialogeColorPickerListener onColorPickerListener;
    public static ColorPickerDialogFragment newInstance() {
        return new ColorPickerDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialoge_color_fragments, container,
                false);
        setColorPickerRecycleView(view);
        // get the views and attach the listener

        view.findViewById(R.id.tv_app_name).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dismiss();
            }
        });
        return view;

    }


    private void setColorPickerRecycleView(View view){

        final TextView tvTextColor = view.findViewById(R.id.tv_app_name);

        ColorPickerAdapter adapter = new ColorPickerAdapter(getContext());
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_color_picker);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setOnColorPickerListener(new ColorPickerAdapter.OnColorPickerListener() {
            @Override
            public void onColorPickerClickListener(int colorCode) {
                tvTextColor.setTextColor(isColorDark(colorCode)?Color.WHITE:Color.BLACK);
                LayerDrawable bgDrawable = (LayerDrawable) tvTextColor.getBackground();
                final GradientDrawable shape = (GradientDrawable)bgDrawable.findDrawableByLayerId(R.id.tv_done_shape);
                shape.setColor(colorCode);

                if(onColorPickerListener!=null){
                    onColorPickerListener.onColorPickerClickListener(colorCode);
                }
            }
        });
    }


    public boolean isColorDark(int color){
        double darkness = 1-(0.299*Color.red(color) + 0.587* Color.green(color) + 0.114*Color.blue(color))/255;
        if(darkness<0.8){
            return false; // It's a light color
        }else{
            return true; // It's a dark color
        }
    }

    public void setOnColorPickerListener(OnDialogeColorPickerListener onColorPickerListener) {
        this.onColorPickerListener = onColorPickerListener;
    }

    public interface OnDialogeColorPickerListener {
        void onColorPickerClickListener(int colorCode);
    }
}