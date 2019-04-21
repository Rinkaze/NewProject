package com.jiyun.day03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jiyun.base.BaseActivity;
import com.jiyun.fragment.AboutFragment;
import com.jiyun.fragment.GankFragment;
import com.jiyun.fragment.GoldFragment;
import com.jiyun.fragment.LikeFragment;
import com.jiyun.fragment.SettingsFragment;
import com.jiyun.fragment.VtexFragment;
import com.jiyun.fragment.WeChatFragment;
import com.jiyun.fragment.ZhihuFragment;
import com.jiyun.presenter.MainPresenter;
import com.jiyun.view.MainView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

    @BindView(R.id.tb_title)
    TextView mTbTitle;
    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    @BindView(R.id.nv)
    NavigationView mNv;
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;
    MaterialSearchView mSearchView;
    private FragmentManager manager;
    private ArrayList<Fragment> fragments;
    private int lastFragmentPosition = 0;

    final int TYPE_ZHIHU = 0;
    final int TYPE_WECHAT = 1;
    final int TYPE_GANK = 2;
    final int TYPE_GOLD = 3;
    final int TYPE_VTEX = 4;
    final int TYPE_LIKE = 5;
    final int TYPE_SETTING = 6;
    final int TYPE_ABOUT = 7;
    private MenuItem searchItem;
    private WeChatFragment weChatFragment;

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mSearchView = findViewById(R.id.search_view);

        manager = getSupportFragmentManager();

        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, 0, 0);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNv.setNavigationItemSelectedListener(null);

        initFragment();
        addZhihuFragment();
    }

    private void addZhihuFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, fragments.get(0));
        transaction.commit();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ZhihuFragment());
        weChatFragment = new WeChatFragment();
        fragments.add(weChatFragment);
        fragments.add(new GankFragment());
        fragments.add(new GoldFragment());
        fragments.add(new VtexFragment());
        fragments.add(new LikeFragment());
        fragments.add(new SettingsFragment());
        fragments.add(new AboutFragment());
    }

    @Override
    protected void initListener() {
        super.initListener();
        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() != R.id.info_title && item.getItemId() != R.id.option_title && !item.isChecked()) {
                    item.setChecked(true);
                    mTbTitle.setText(item.getTitle());
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                    switch (item.getItemId()) {
                        default:
                            break;
                        case R.id.zhihu:
                            switchFragment(TYPE_ZHIHU);
                            searchItem.setVisible(false);
                            break;
                        case R.id.wechat:
                            switchFragment(TYPE_WECHAT);
                            searchItem.setVisible(true);
                            break;
                        case R.id.gank:
                            switchFragment(TYPE_GANK);
                            searchItem.setVisible(true);
                            break;
                        case R.id.gold:
                            switchFragment(TYPE_GOLD);
                            searchItem.setVisible(false);
                            break;
                        case R.id.vtex:
                            switchFragment(TYPE_VTEX);
                            searchItem.setVisible(false);
                            break;
                        case R.id.like:
                            switchFragment(TYPE_LIKE);
                            searchItem.setVisible(false);
                            break;
                        case R.id.settings:
                            switchFragment(TYPE_SETTING);
                            searchItem.setVisible(false);
                            break;
                        case R.id.about:
                            switchFragment(TYPE_ABOUT);
                            searchItem.setVisible(false);
                            break;
                    }
                }
                return false;
            }
        });

        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                if (weChatFragment.isVisible()){
                    weChatFragment.getData(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        mSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
    }

    private void switchFragment(int type) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fragments.get(type);
        if (!fragment.isAdded()) {
            transaction.add(R.id.fragment_container, fragment);
        }
        transaction.show(fragment);
        transaction.hide(fragments.get(lastFragmentPosition));
        transaction.commit();
        lastFragmentPosition = type;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        searchItem = menu.findItem(R.id.action_search);
        mSearchView.setMenuItem(searchItem);
        searchItem.setVisible(false);
        return true;
    }

}
