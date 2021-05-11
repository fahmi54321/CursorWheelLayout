package com.android.a69cursorwheellayout.Adapter;

import android.content.Context;
import android.media.Image;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.android.a69cursorwheellayout.Model.ImageData;
import com.android.a69cursorwheellayout.Model.MenuItemData;
import com.android.a69cursorwheellayout.R;

import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class WheelImageAdapter extends CursorWheelLayout.CycleWheelAdapter {

    private Context context;
    private List<ImageData> menuItemData;
    private LayoutInflater inflater;
    private int gravity;

    public WheelImageAdapter(Context context, List<ImageData> menuItemData) {
        this.context = context;
        this.menuItemData = menuItemData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return menuItemData.size();
    }

    @Override
    public View getView(View parent, int position) {
        ImageData itemData = getItem(position);
        View root = inflater.inflate(R.layout.wheel_image_layout,null,false);
        ImageView imageView = (ImageView) root.findViewById(R.id.wheel_menu_item_iv);
        imageView.setImageResource(itemData.imageResource);
        return root;
    }

    @Override
    public ImageData getItem(int position) {
        return menuItemData.get(position);
    }
}
