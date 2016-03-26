package com.androidbelieve.drawerwithswipetabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class retailchain extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_retailchain,null);

        Button one = (Button) v.findViewById(R.id.r1);
        Button two = (Button) v.findViewById(R.id.r2);
        Button three = (Button) v.findViewById(R.id.r3);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Retailer_Chain.class);
                i.putExtra("pressed","one");
                getActivity().startActivity(i);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Retailer_Chain.class);
                i.putExtra("pressed","two");
                getActivity().startActivity(i);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Retailer_Chain.class);
                i.putExtra("pressed","three");
                getActivity().startActivity(i);
            }
        });

        return v;
    }


}
