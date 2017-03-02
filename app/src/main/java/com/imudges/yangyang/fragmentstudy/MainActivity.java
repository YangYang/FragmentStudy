package com.imudges.yangyang.fragmentstudy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private Fragment mainFragment;
    private Fragment friendFragment;
    private Fragment addressFragment;
    private Fragment settingFragment;

    private ImageButton imBtnMain;
    private ImageButton imBtnFriend;
    private ImageButton imBtnAddress;
    private ImageButton imBtnSetting;

    private LinearLayout mainLinearLayout;
    private LinearLayout friendLinearLayout;
    private LinearLayout addressLinearLayout;
    private LinearLayout settingLinearLayout;

    private void initView() {
        imBtnMain = (ImageButton) findViewById(R.id.img_btn_main_page);
        imBtnFriend = (ImageButton) findViewById(R.id.img_btn_friend_page);
        imBtnAddress = (ImageButton) findViewById(R.id.img_btn_connect_page);
        imBtnSetting = (ImageButton) findViewById(R.id.img_btn_setting_page);

        mainLinearLayout = (LinearLayout) findViewById(R.id.linear_layout_main);
        friendLinearLayout = (LinearLayout) findViewById(R.id.linear_layout_friend);
        addressLinearLayout = (LinearLayout) findViewById(R.id.linear_layout_connect);
        settingLinearLayout = (LinearLayout) findViewById(R.id.linear_layout_setting);

        mainFragment = new MainFragment();
        friendFragment = new FriendFragment();
        addressFragment = new AddressFragment();
        settingFragment = new SettingFragment();
    }

    private void initEvents() {
        mainLinearLayout.setOnClickListener(this);
        friendLinearLayout.setOnClickListener(this);
        addressLinearLayout.setOnClickListener(this);
        settingLinearLayout.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
        setSelected(0);
        imBtnMain.setImageResource(R.drawable.tab_weixin_pressed);
    }

    private void setSelected(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //隐藏所有的Fragement
        hideFragment(fragmentTransaction);
        switch (position) {
            case 0:
                if (mainFragment == null) {
                    Toast.makeText(MainActivity.this, "有问题啦", Toast.LENGTH_SHORT).show();

                } else if (!mainFragment.isAdded()) {
                    fragmentTransaction.add(R.id.id_content, mainFragment);
                }
                fragmentTransaction.show(mainFragment).commit();
                break;
            case 1:
                if (friendFragment == null) {
                    Toast.makeText(MainActivity.this, "有问题啦", Toast.LENGTH_SHORT).show();
                } else if (!friendFragment.isAdded()) {
                    fragmentTransaction.add(R.id.id_content, friendFragment);
                }
                fragmentTransaction.show(friendFragment).commit();
                break;
            case 2:
                if (addressFragment == null) {
                    Toast.makeText(MainActivity.this, "有问题啦", Toast.LENGTH_SHORT).show();

                } else if (!addressFragment.isAdded()) {
                    fragmentTransaction.add(R.id.id_content, addressFragment);
                }
                fragmentTransaction.show(addressFragment).commit();
                break;
            case 3:
                if (settingFragment == null) {
                    Toast.makeText(MainActivity.this, "有问题啦", Toast.LENGTH_SHORT).show();
                } else if (!settingFragment.isAdded()) {
                    fragmentTransaction.add(R.id.id_content, settingFragment);
                }
                fragmentTransaction.show(settingFragment).commit();
                break;
            default:
                break;
        }

    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (mainFragment != null) {
            fragmentTransaction.hide(mainFragment);
        }
        if (friendFragment != null) {
            fragmentTransaction.hide(friendFragment);
        }
        if (addressFragment != null) {
            fragmentTransaction.hide(addressFragment);
        }
        if (settingFragment != null) {
            fragmentTransaction.hide(settingFragment);
        }
    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()) {
            case R.id.linear_layout_main:
                imBtnMain.setImageResource(R.drawable.tab_weixin_pressed);
                setSelected(0);
                break;
            case R.id.linear_layout_friend:
                imBtnFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                setSelected(1);
                break;
            case R.id.linear_layout_connect:
                imBtnAddress.setImageResource(R.drawable.tab_address_pressed);
                setSelected(2);
                break;
            case R.id.linear_layout_setting:
                imBtnSetting.setImageResource(R.drawable.tab_settings_pressed);
                setSelected(3);
                break;
            default:
                break;
        }
    }

    private void resetImg() {
        imBtnMain.setImageResource(R.drawable.tab_weixin_normal);
        imBtnFriend.setImageResource(R.drawable.tab_find_frd_normal);
        imBtnAddress.setImageResource(R.drawable.tab_address_normal);
        imBtnSetting.setImageResource(R.drawable.tab_settings_normal);
    }

}
