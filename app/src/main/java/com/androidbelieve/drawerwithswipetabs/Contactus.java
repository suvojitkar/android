package com.androidbelieve.drawerwithswipetabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Contactus extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_contactus,container,false);

        ImageButton   call = (ImageButton)v.findViewById(R.id.helpcall);
        ImageButton mail = (ImageButton)v.findViewById(R.id.helpmail);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+91 22 39830000"));
                startActivity(i);
            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "levercare.customer@unilever.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "REQUEST FOR HELP");
                startActivity(intent);
            }
        });

        return v;
    }
}
