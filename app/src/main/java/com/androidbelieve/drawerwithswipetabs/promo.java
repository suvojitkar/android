package com.androidbelieve.drawerwithswipetabs;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.androidbelieve.drawerwithswipetabs.adapter.InvoiceList;
import com.androidbelieve.drawerwithswipetabs.adapter.PromoList;
import com.androidbelieve.drawerwithswipetabs.app.AppController;
import com.androidbelieve.drawerwithswipetabs.model.Invoice_Model;
import com.androidbelieve.drawerwithswipetabs.model.Promo_Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class promo extends Fragment {

    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Movies json url
    private static final String url = "http://mehuljain160.esy.es/promotion.php";
    private ProgressDialog pDialog;
    private List<Promo_Model> movieList = new ArrayList<Promo_Model>();
    private ListView listView;
    private PromoList adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_promo,container,false);


        listView = (ListView)v.findViewById(R.id.list);
        adapter = new PromoList(getActivity(), movieList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // Creating volley request obj
        JsonArrayRequest movieReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        Parse(response);

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();
                Toast.makeText(getActivity(), "Unable to fetch data.\nUsing Cached Data", Toast.LENGTH_SHORT).show();
                useCached();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(movieReq);

        return v;
    }

    public void useCached(){
        //Volley Cache
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);

        try {
//            pDialog.hide();
            String data = new String(entry.data, "UTF-8");
            JSONArray a = new JSONArray(data);

            Parse(a);

            // notifying list adapter about data changes
            // so that it renders the list view with updated data
            adapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }

        AppController.getInstance().getRequestQueue().getCache().invalidate(url, true);
    }

    public void Parse (JSONArray response){
        // Parsing json
        for (int i = 0; i < response.length(); i++) {
            try {

                JSONObject obj = response.getJSONObject(i);
                Promo_Model movie = new Promo_Model();
                movie.setPromoProduct(obj.getString("Product"));
                movie.setBrand(obj.getString("Brand"));
                movie.setRegion(obj.getString("REGION"));

                // adding movie to movies array
                movieList.add(movie);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }

    }
}
