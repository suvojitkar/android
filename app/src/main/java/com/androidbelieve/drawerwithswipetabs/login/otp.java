package com.androidbelieve.drawerwithswipetabs.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.androidbelieve.drawerwithswipetabs.MainActivity;
import com.androidbelieve.drawerwithswipetabs.R;


public class otp extends AppCompatActivity  {
    LocalDatabase localDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        final com.androidbelieve.drawerwithswipetabs.login.CodeInput otpsent = (com.androidbelieve.drawerwithswipetabs.login.CodeInput) findViewById(R.id.otpview);
         Button otpsend = (Button) findViewById(R.id.btnotp);

        localDatabase = new LocalDatabase(this);
        otpsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String otpp = otpsent.getCode().toString();
                otppk otppk = new otppk(otpp);

                authenticate(otppk);
            }
        });


    }

    private void authenticate(final otppk otppk) {
        ServerRequestll serverRequestll = new ServerRequestll(otp.this);


        serverRequestll.fetchDataInBackground(otppk, new GetUserCallbackll() {

            @Override
            public void done(otppk returnedotpkk) {
                if (returnedotpkk == null) {

                    //show an error message
                    Intent intent = new Intent(otp.this, Login.class);
                    startActivity(intent);


                } else {
                    //Log user in
                    localDatabase.storeData(returnedotpkk);
                    localDatabase.setUserLoggedIn(true);

                    Intent intent = new Intent(otp.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }


}
