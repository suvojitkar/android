package com.androidbelieve.drawerwithswipetabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.androidbelieve.drawerwithswipetabs.login.Login;

/**
 * Created by Ratan on 7/29/2015.
 */
public class Myaccount extends Fragment {

    Button logout;
    SharedPreferences pref;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_myaccount,null);

        logout = (Button) v.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pref = getActivity().getApplicationContext().getSharedPreferences("MyPref", getActivity().MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                //Logging Out, set boolean loggedin to false
                editor.putBoolean("loggedin", false);
                editor.commit();

                Toast.makeText(getActivity(),"Logged Out Successfully",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getContext(), Login.class);
                startActivity(i);
            }
        });

        return v;
    }
}