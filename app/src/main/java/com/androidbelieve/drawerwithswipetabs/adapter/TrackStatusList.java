package com.androidbelieve.drawerwithswipetabs.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.androidbelieve.drawerwithswipetabs.R;
import com.androidbelieve.drawerwithswipetabs.app.AppController;
import com.androidbelieve.drawerwithswipetabs.model.Movie;
import com.androidbelieve.drawerwithswipetabs.model.Track;

import java.util.List;

/**
 * Created by Anshul on 24-03-2016.
 */
public class TrackStatusList extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Track> movieItems;
//    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public TrackStatusList(Activity activity, List<Track> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.track_list_row, null);

//        if (imageLoader == null)
//            imageLoader = AppController.getInstance().getImageLoader();
//        NetworkImageView thumbNail = (NetworkImageView) convertView
//                .findViewById(R.id.thumbnail);

        TextView confirmationstatus = (TextView) convertView.findViewById(R.id.cstatus);
        TextView deliverystatus = (TextView) convertView.findViewById(R.id.dstatus);
        TextView transportationstatus = (TextView) convertView.findViewById(R.id.tstatus);
        TextView product = (TextView) convertView.findViewById(R.id.product);
        TextView date = (TextView) convertView.findViewById(R.id.date);

        // getting movie data for the row
        Track m = movieItems.get(position);

        // thumbnail image
//        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        // confirmation
        confirmationstatus.setText(m.getConfirmation());

        // delivery
        deliverystatus.setText(m.getDelivery());

        // transportation
        transportationstatus.setText(m.getTransportation());

        // product
        product.setText(m.getProduct());

        // date
        date.setText(m.getDate());

        return convertView;
    }
}

