package datanapps.colorpicker.sameinstagram;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import datanapps.colorpicker.R;

public class ColorFragment extends Fragment {


    public static ColorFragment getInstance(int position){
        ColorFragment colorFragment = new ColorFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        colorFragment.setArguments(bundle);
        return colorFragment;
    }
    int position;

    int VIEW_ID [] = {
            R.id.color_view_1,
            R.id.color_view_2,
            R.id.color_view_3,
            R.id.color_view_4,
            R.id.color_view_5,
            R.id.color_view_6,
            R.id.color_view_7,
            R.id.color_view_8,
            R.id.color_view_9,


    } ;
    private  InstagramColorPicker onColorPickerListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        position = getArguments().getInt("position");

        View rootView = inflater.inflate(R.layout.fragment_instagram_picker, container, false);
        updateView(rootView);
        return rootView;
    }



    public void setOnColorPickerListener(InstagramColorPicker onColorPickerListener) {
        this.onColorPickerListener = onColorPickerListener;
    }


    private void updateView(View rootView){
         int[] colorList =  getResources().getIntArray(R.array.color_instagram);
        for ( int i=0; i< VIEW_ID.length; i++){
            final int colorCode = colorList[position*9+i];
            final int tintColorCode = getTintColorCode(position*9+i);
            View view  = rootView.findViewById(VIEW_ID[i]);
            LayerDrawable bgDrawable = (LayerDrawable) view.getBackground();
            final GradientDrawable shape = (GradientDrawable)   bgDrawable.findDrawableByLayerId(R.id.shape_id);
            shape.setColor(colorCode);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onColorPickerListener!=null){

                        onColorPickerListener.onColorPickerClickListener(colorCode, tintColorCode);
                    }
                }
            });
        }

    }

    private int getTintColorCode(int position){
        if(position==0|| position==25  || position==26){
            return Color.BLACK;
        }
        return Color.WHITE;
    }



}