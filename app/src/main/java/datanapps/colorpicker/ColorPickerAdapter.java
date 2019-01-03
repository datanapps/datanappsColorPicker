package datanapps.colorpicker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ColorPickerAdapter extends RecyclerView.Adapter<ColorPickerAdapter.ViewHolder> {


    private LayoutInflater colorViewInflater;
    private List<Integer> colorCodeList;
    private OnColorPickerListener onColorPickerListener;


    public interface OnColorPickerListener {
        void onColorPickerClickListener(int colorCode);
    }

    ColorPickerAdapter(@NonNull Context context) {
        this(context, setColorInList(context));
        this.colorViewInflater = LayoutInflater.from(context);
    }

    private ColorPickerAdapter(@NonNull Context context, @NonNull List<Integer> colorPickerColors) {
        this.colorViewInflater = LayoutInflater.from(context);
        this.colorCodeList = colorPickerColors;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = colorViewInflater.inflate(R.layout.layout_list_color_picker, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.view.setBackgroundColor(colorCodeList.get(position));
    }

    @Override
    public int getItemCount() {
        return colorCodeList.size();
    }

    public void setOnColorPickerListener(OnColorPickerListener onColorPickerListener) {
        this.onColorPickerListener = onColorPickerListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        private ViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.color_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onColorPickerListener != null)
                        onColorPickerListener.onColorPickerClickListener(colorCodeList.get(getAdapterPosition()));
                }
            });
        }
    }


    public static List<Integer> setColorInList(Context context) {
        ArrayList<Integer> colorPickerColors = new ArrayList<>();

        colorPickerColors.add(ContextCompat.getColor(context, R.color.grey5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.grey10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.grey15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.grey20));

        colorPickerColors.add(ContextCompat.getColor(context, R.color.red5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.red10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.red15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.red20));

        colorPickerColors.add(ContextCompat.getColor(context, R.color.orange5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.orange10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.orange15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.orange20));

        colorPickerColors.add(ContextCompat.getColor(context, R.color.yellow5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.yellow10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.yellow15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.yellow20));

        colorPickerColors.add(ContextCompat.getColor(context, R.color.lime5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.lime10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.lime15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.lime20));


        colorPickerColors.add(ContextCompat.getColor(context, R.color.green5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.green10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.green15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.green20));


        colorPickerColors.add(ContextCompat.getColor(context, R.color.aquamarine5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.aquamarine10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.aquamarine15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.aquamarine20));

        colorPickerColors.add(ContextCompat.getColor(context, R.color.cyne5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.cyne10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.cyne15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.cyne20));

        colorPickerColors.add(ContextCompat.getColor(context, R.color.skyblue5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.skyblue10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.skyblue15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.skyblue20));

        colorPickerColors.add(ContextCompat.getColor(context, R.color.blue5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.blue10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.blue15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.blue20));


        colorPickerColors.add(ContextCompat.getColor(context, R.color.purple5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.purple10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.purple15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.purple20));


        colorPickerColors.add(ContextCompat.getColor(context, R.color.orchid5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.orchid10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.orchid15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.orchid20));


        colorPickerColors.add(ContextCompat.getColor(context, R.color.pink5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.pink10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.pink15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.pink20));

        colorPickerColors.add(ContextCompat.getColor(context, R.color.violet5));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.violet10));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.violet15));
        colorPickerColors.add(ContextCompat.getColor(context, R.color.violet20));


        return colorPickerColors;
    }
}
