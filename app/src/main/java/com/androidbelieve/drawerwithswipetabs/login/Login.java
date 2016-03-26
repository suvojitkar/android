package com.androidbelieve.drawerwithswipetabs.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.androidbelieve.drawerwithswipetabs.MainActivity;
import com.androidbelieve.drawerwithswipetabs.R;

/**
 * Created by Nicks on 25-03-2016.
 */
public class Login extends AppCompatActivity {

    EditText etusername , etpassword;
    LocalDatabase localDatabase;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etusername = (EditText)findViewById(R.id.TFusername_login);
        etpassword = (EditText)findViewById(R.id.TFpassword_login);
        localDatabase = new LocalDatabase(this);

    }

    public void onRegisterClick(View view)
    {
        Intent intent = new Intent(Login.this , Register.class);
        startActivity(intent);
    }

    public void onLoginClick(View view)
    {
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();

        Contact contact = new Contact(username,  password);
        Log.e("uname = ", contact.username);
        authenticate(contact);

    }

    private void authenticate(Contact contact)
    {
        ServerRequests serverRequests = new ServerRequests(Login.this);


        serverRequests.fetchDataInBackground(contact, new GetUserCallback() {

            @Override
            public void done(Contact returnedContact) {
                if (returnedContact == null) {
                    //show an error message
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setMessage("Username & Password don't match!");
                    builder.setPositiveButton("OK", null);
                    builder.show();

                } else {
                    //Log user in
                    localDatabase.storeData(returnedContact);
                    localDatabase.setUserLoggedIn(true);

                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);

                    pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();

                    //Logged In, set loggedin to true boolean
                    editor.putBoolean("loggedin", true);
                    editor.commit();
                }

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
