package com.androidbelieve.drawerwithswipetabs.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidbelieve.drawerwithswipetabs.R;
import com.androidbelieve.drawerwithswipetabs.model.Promo_Model;

import java.util.List;

/**
 * Created by Anshul on 25-03-2016.
 */
public class PromoList extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Promo_Model> movieItems;
//    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public PromoList(Activity activity, List<Promo_Model> movieItems) {
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
            convertView = inflater.inflate(R.layout.promo_row, null);

        TextView product = (TextView) convertView.findViewById(R.id.product);
        TextView brand = (TextView) convertView.findViewById(R.id.brand);
        TextView region = (TextView) convertView.findViewById(R.id.region);

        // getting movie data for the row
        Promo_Model m = movieItems.get(position);

        // product
        product.setText(m.getPromoProduct());

        // brand
        brand.setText(m.getBrand());

        // region
        region.setText(m.getRegion());

        return convertView;
    }
}
