package com.androidbelieve.drawerwithswipetabs.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by priya on 7/16/2015.
 */
public class ServerRequestll {
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 15000;
    public static final String SERVER_ADDRESS = "http://mehuljain160.esy.es/";

    public ServerRequestll(Context context)
    {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait..");

    }



    public void fetchDataInBackground(otppk otppk , GetUserCallbackll callback)
    {
        progressDialog.show();
        new FetchDataAsyncTask(otppk, callback).execute();


    }

    public class StoreDataAsyncTask extends AsyncTask<Void , Void , Void>
    {
        otppk otppk;
        GetUserCallbackll callback;

        public StoreDataAsyncTask(otppk otppk , GetUserCallbackll callback)
        {
            this.otppk = otppk;
            this.callback = callback;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ArrayList<NameValuePair> data_to_send = new ArrayList<>();
            data_to_send.add(new BasicNameValuePair("Name" , otppk.name));
            data_to_send.add(new BasicNameValuePair("Email" , otppk.email));
            data_to_send.add(new BasicNameValuePair("Username" , otppk.username));
            data_to_send.add(new BasicNameValuePair("Password" , otppk.password));

            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams , CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams , CONNECTION_TIMEOUT);

            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS + "otp.php");

            try {
                post.setEntity(new UrlEncodedFormEntity(data_to_send));
                client.execute(post);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.dismiss();
            callback.done(null);

            super.onPostExecute(aVoid);
        }
    }

    public class FetchDataAsyncTask extends AsyncTask<Void , Void , otppk>
    {
        otppk otppk;
        GetUserCallbackll callback;

        public FetchDataAsyncTask(otppk otppk , GetUserCallbackll callback)
        {
            this.otppk = otppk;
            this.callback = callback;
        }


        @Override
        protected otppk doInBackground(Void... voids) {
            ArrayList<NameValuePair> data_to_send = new ArrayList<>();

            data_to_send.add(new BasicNameValuePair("Otp" , otppk.otpp));

            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams , CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams , CONNECTION_TIMEOUT);

            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS + "otp.php");

            otppk retunedotppk = null;
            try {
                post.setEntity(new UrlEncodedFormEntity(data_to_send));
                HttpResponse httpResponse = client.execute(post);

                HttpEntity entity = httpResponse.getEntity();
                String result = EntityUtils.toString(entity);


                JSONObject jsonObject = new JSONObject(result);
                retunedotppk = null;

                if(jsonObject.length() == 0)
                {
                    retunedotppk = null;

                }
                else
                {



                    retunedotppk = new otppk(otppk.otpp);

                }

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            return retunedotppk;
        }
        @Override
        protected void onPostExecute(otppk returnedotppk) {
            progressDialog.dismiss();
            callback.done(returnedotppk);
            super.onPostExecute(returnedotppk);
        }

    }
}
