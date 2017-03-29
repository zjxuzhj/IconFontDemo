package com.zhj.iconfontdemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final CheckBox cb_icon = (CheckBox) findViewById(R.id.cb_icon);
        int themeColor = getResources().getColor(R.color.colorAccent);
        int blackColor = getResources().getColor(R.color.black);
        int sizeDp = 20;
        final Drawable drawable = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_ticket).color(themeColor).sizeDp(sizeDp);
        final Drawable drawableDis = new IconicsDrawable(this).icon(FontAwesome.Icon.faw_angle_right).color(blackColor).sizeDp(sizeDp * 2);
        cb_icon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    cb_icon.setCompoundDrawables(null, drawable, null, null);
                else {
                    cb_icon.setCompoundDrawables(null, drawableDis, null, null);
                }
            }
        });
        cb_icon.setChecked(true);
    }
}
