package com.androidbelieve.drawerwithswipetabs.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidbelieve.drawerwithswipetabs.MainActivity;
import com.androidbelieve.drawerwithswipetabs.R;
import com.androidbelieve.drawerwithswipetabs.app.AppController;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class otp extends AppCompatActivity  {

    public static final String REGISTER_URL = "http://mehuljain160.esy.es/otp.php";
    public static final String KEY_USERNAME = "otp";

    private EditText editTextOTP;
    private Button buttonRegister;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        editTextOTP = (EditText) findViewById(R.id.eotp);
        buttonRegister = (Button) findViewById(R.id.rotp);
        pDialog = new ProgressDialog(this);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Showing progress dialog before making http request

                pDialog.show();
                pDialog.setMessage("Loading...");
                registerUser();
            }
        });

    }

    private void registerUser()
    {
        final String username = editTextOTP.getText().toString().trim();

        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(movieReq);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        hidePDialog();
                        Log.v("Response",response);
                        Toast.makeText(getBaseContext(), response, Toast.LENGTH_LONG).show();
                            Intent i = new Intent(otp.this,Login.class);
                        startActivity(i);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        hidePDialog();
                        Toast.makeText(getBaseContext(),error.toString(), Toast.LENGTH_LONG).show();
                        editTextOTP.setText("");
                    }
                })
        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME,username);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
