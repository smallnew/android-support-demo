package com.example.administrator.recyletext;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smallnew on 2015/11/27.
 */
public class TestNewMainActivity extends AppCompatActivity {

    //Tab菜单，主界面上面的tab切换菜单
    private TabLayout mTabLayout;
    //v4中的ViewPager控件
    private ViewPager mViewPager;
    //将ToolBar与TabLayout结合放入AppBarLayout
    private Toolbar mToolbar;
    //DrawerLayout控件
    private DrawerLayout mDrawerLayout;
    //侧边菜单
    private NavigationView mNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtil.setTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) this.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) this.findViewById(R.id.view_pager);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mNav = (NavigationView) findViewById(R.id.nav);


        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setTitle("title");
        mToolbar.setSubtitle("subtitle");


        List<String> titles = new ArrayList<>();
        titles.add("Linear");
        titles.add("Horizontal");
        titles.add("StaggeredGrid");
        titles.add("Grid");

        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(3)));

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyleFragment1());
        fragments.add(new RecyleFragment2());
        fragments.add(new RecyleFragment3());
        fragments.add(new RecyleFragment4());


        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(adapter);
        //important
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(adapter);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.action_settings, R.string.action_settings);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_appbar:
                        startActivity(new Intent(TestNewMainActivity.this, AppBarTestActivity.class));
                        break;
                    case R.id.action_percent:
                        startActivity(new Intent(TestNewMainActivity.this, PercentLayoutActivity.class));
                        break;
                    case R.id.action_textinput:
                        startActivity(new Intent(TestNewMainActivity.this, NewTextInputActivity.class));
                        break;
                    case R.id.action_palette:
                        startActivity(new Intent(TestNewMainActivity.this, PaletteTestActivity.class));
                        break;
                    case R.id.action_theme:
                        ThemeUtil.loadTheme(TestNewMainActivity.this, true);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
