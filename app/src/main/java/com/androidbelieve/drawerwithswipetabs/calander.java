package com.androidbelieve.drawerwithswipetabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class calander extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_calander,null);
        Button one = (Button) v.findViewById(R.id.e1);
        Button two = (Button) v.findViewById(R.id.e2);
        Button three = (Button) v.findViewById(R.id.e3);

        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, cal.get(Calendar.MONTH));

         one.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {

                 Intent intent = new Intent(Intent.ACTION_INSERT);
                 intent.setData(CalendarContract.Events.CONTENT_URI);
                 intent.putExtra(CalendarContract.Events.ALL_DAY, true);
                 intent.putExtra(CalendarContract.Events.HAS_ALARM, true);
                 intent.putExtra(CalendarContract.Events.CALENDAR_COLOR, "red");
                 intent.putExtra(CalendarContract.Events.TITLE, "Key Event 1");
                 startActivity(intent);
             }
         });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.ALL_DAY, true);
                intent.putExtra(CalendarContract.Events.HAS_ALARM, true);
                intent.putExtra(CalendarContract.Events.CALENDAR_COLOR, "red");
                intent.putExtra(CalendarContract.Events.TITLE, "Key Event 2");
                startActivity(intent);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.ALL_DAY, true);
                intent.putExtra(CalendarContract.Events.HAS_ALARM, true);
                intent.putExtra(CalendarContract.Events.CALENDAR_COLOR, "red");
                intent.putExtra(CalendarContract.Events.TITLE, "Key Event 3");
                startActivity(intent);
            }
        });

        return v;
    }
}