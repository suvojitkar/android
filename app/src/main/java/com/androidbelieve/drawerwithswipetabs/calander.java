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

         Button bcal = (Button) v.findViewById(R.id.bcal);

         bcal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Calendar cal = new GregorianCalendar();
                cal.setTime(new Date());
                cal.add(Calendar.MONTH, cal.get(Calendar.MONTH));
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE, "Key Event 1");
                intent.putExtra(CalendarContract.Events.ALL_DAY, true);
                intent.putExtra(
                        CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        cal.getTime().getTime());
                intent.putExtra(
                        CalendarContract.EXTRA_EVENT_END_TIME,
                        cal.getTime().getTime() + 600000);
                startActivity(intent);
            }
        });

        return v;
    }
}