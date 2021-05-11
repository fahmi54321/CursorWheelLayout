package com.android.a69cursorwheellayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.android.a69cursorwheellayout.Adapter.WheelImageAdapter;
import com.android.a69cursorwheellayout.Adapter.WheelTextAdapter;
import com.android.a69cursorwheellayout.Model.ImageData;
import com.android.a69cursorwheellayout.Model.MenuItemData;

import java.util.ArrayList;
import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class MainActivity extends AppCompatActivity {

    CursorWheelLayout wheel_text,wheel_image;
    List<MenuItemData> listText;
    List<ImageData> listImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wheel_text = (CursorWheelLayout) findViewById(R.id.wheel_text);
        wheel_image = (CursorWheelLayout) findViewById(R.id.wheel_image);

        loadData();
        wheel_text.setOnMenuItemClickListener(new CursorWheelLayout.OnMenuItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                Toast.makeText(MainActivity.this, ""+listText.get(pos).title, Toast.LENGTH_SHORT).show();
            }
        });

        wheel_image.setOnMenuItemClickListener(new CursorWheelLayout.OnMenuItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                Toast.makeText(MainActivity.this, ""+listImage.get(pos).imageDescription, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadData() {
        listText = new ArrayList<>();
        for (int i=0;i<9;i++){
            listText.add(new MenuItemData(""+1));
        }
        listText.add(new MenuItemData("OFF"));
        WheelTextAdapter adapter = new WheelTextAdapter(getBaseContext(),listText);
        wheel_text.setAdapter(adapter);

        listImage = new ArrayList<>();
        listImage.add(new ImageData(R.drawable.card2,"Card"));
        listImage.add(new ImageData(R.drawable.logo_google_cloud,"Google Cloud"));
        listImage.add(new ImageData(R.drawable.microsoft,"Microsoft"));
        listImage.add(new ImageData(R.drawable.twitter,"Twitter"));
        listImage.add(new ImageData(R.drawable.youtube,"Youtube"));
        WheelImageAdapter imgAdapter = new WheelImageAdapter(getBaseContext(),listImage);
        wheel_image.setAdapter(imgAdapter);
    }
}