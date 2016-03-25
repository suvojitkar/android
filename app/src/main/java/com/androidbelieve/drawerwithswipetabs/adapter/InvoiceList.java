package com.androidbelieve.drawerwithswipetabs.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidbelieve.drawerwithswipetabs.Invoice;
import com.androidbelieve.drawerwithswipetabs.R;
import com.androidbelieve.drawerwithswipetabs.model.Invoice_Model;

import java.util.List;

/**
 * Created by Anshul on 25-03-2016.
 */
public class InvoiceList extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Invoice_Model> movieItems;

    public InvoiceList(Activity activity, List<Invoice_Model> movieItems) {
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
            convertView = inflater.inflate(R.layout.invoice_list_row, null);

        TextView custID = (TextView) convertView.findViewById(R.id.cid);
        TextView billDate = (TextView) convertView.findViewById(R.id.bdate);
        TextView billDoc = (TextView) convertView.findViewById(R.id.bdoc);
        TextView paymentMethod = (TextView) convertView.findViewById(R.id.pmethod);
        TextView productQty = (TextView) convertView.findViewById(R.id.pqty);

        // getting movie data for the row
        Invoice_Model m = movieItems.get(position);

        // customer ID
        custID.setText(m.getCustId());

        // Bill Date
        billDate.setText(m.getBillDate());

        // Bill Document
        billDoc.setText(m.getBillDoc());

        // Payment Method
        paymentMethod.setText(m.getPaymentMethod());

        // Prod Qty
        productQty.setText(m.getProdQty());

        return convertView;
    }
}