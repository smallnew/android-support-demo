package com.example.administrator.recyletext;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by smallnew on 2015/12/2.
 * 调色板demo，Palette根据给的位图给出推荐的app配色方案
 * Palette demo,recommend colors according to given bitmap,in other word,bitmap is palette
 */
public class PaletteTestActivity extends AppCompatActivity {
    private int[] ress = new int[]{R.mipmap.image14, R.mipmap.image13, R.mipmap.image12, R.mipmap.image11};
    private int selectedIndex = 0;
    private int selectedRes = R.mipmap.image14;
    private Button mBtnMuted1;
    private Button mBtnMuted2;
    private Button mBtnMuted3;
    private Button mBtnVibrant1;
    private Button mBtnVibrant2;
    private Button mBtnVibrant3;

    private Button mBtnChange;

    private ImageView mIvPic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ThemeUtil.setTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette_test);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mIvPic = (ImageView) findViewById(R.id.iv_palette);

        mBtnMuted1 = (Button) findViewById(R.id.btn_muted1);
        mBtnMuted2 = (Button) findViewById(R.id.btn_muted2);
        mBtnMuted3 = (Button) findViewById(R.id.btn_muted3);
        mBtnVibrant1 = (Button) findViewById(R.id.btn_vibrant1);
        mBtnVibrant2 = (Button) findViewById(R.id.btn_vibrant2);
        mBtnVibrant3 = (Button) findViewById(R.id.btn_vibrant3);

        refreshPalette();

        mBtnChange = (Button) findViewById(R.id.btn_change_pic);

        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedIndex++;
                if (selectedIndex == 4) selectedIndex = 0;
                selectedRes = ress[selectedIndex];
                mIvPic.setImageResource(selectedRes);
                refreshPalette();
            }
        });

    }

    private void refreshPalette() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), selectedRes);
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {//根据图像获取颜色
            @Override
            public void onGenerated(Palette palette) {
                int colorMuted1 = palette.getLightMutedColor(Color.GRAY);
                int colorMuted2 = palette.getMutedColor(Color.GRAY);
                int colorMuted3 = palette.getDarkMutedColor(Color.GRAY);

                int colorVibrant1 = palette.getLightVibrantColor(Color.GRAY);
                int colorVibrant2 = palette.getVibrantColor(Color.GRAY);
                int colorVibrant3 = palette.getDarkVibrantColor(Color.GRAY);
                mBtnMuted1.setBackgroundColor(colorMuted1);
                mBtnMuted2.setBackgroundColor(colorMuted2);
                mBtnMuted3.setBackgroundColor(colorMuted3);
                mBtnVibrant1.setBackgroundColor(colorVibrant1);
                mBtnVibrant2.setBackgroundColor(colorVibrant2);
                mBtnVibrant3.setBackgroundColor(colorVibrant3);
            }
        });

    }

}
