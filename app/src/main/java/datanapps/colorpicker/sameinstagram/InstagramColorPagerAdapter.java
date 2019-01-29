package datanapps.colorpicker.sameinstagram;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import datanapps.colorpicker.R;

public class InstagramColorPagerAdapter extends FragmentPagerAdapter {

    private  InstagramColorPicker onColorPickerListener;

    int[] colorList;


    public InstagramColorPagerAdapter(Context context, FragmentManager fm, InstagramColorPicker onColorPickerListener) {
        super(fm);
        this.onColorPickerListener = onColorPickerListener;
        colorList = context.getResources().getIntArray(R.array.color_instagram);
    }

    @Override
    public Fragment getItem(int index) {
        ColorFragment fragment = ColorFragment.getInstance(index);
        fragment.setOnColorPickerListener(onColorPickerListener);
        return fragment;

    }

    @Override
    public int getCount() {
        return colorList.length/9;
    }




}