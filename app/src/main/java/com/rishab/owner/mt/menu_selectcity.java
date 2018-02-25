package com.rishab.owner.mt;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by OWNER on 13-12-2015.
 */
public class menu_selectcity extends Fragment{
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        rootview=inflater.inflate(R.layout.menu_selectcity,container,false);
        return rootview;
    }
}
