package com.androidbelieve.drawerwithswipetabs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Cheque_leaf extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cheque_leaf,null);

        TextView textView = (TextView)v.findViewById(R.id.textView);
        Typeface myCustomFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/androidnation.ttf");
        textView.setTypeface(myCustomFont);

        return v;
    }
}
