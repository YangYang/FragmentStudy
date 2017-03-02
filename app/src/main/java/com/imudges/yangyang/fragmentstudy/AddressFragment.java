package com.imudges.yangyang.fragmentstudy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangyang on 2017/3/2.
 */
public class AddressFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab03,container,false);
    }
}
