package com.androidbelieve.drawerwithswipetabs.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidbelieve.drawerwithswipetabs.MainActivity;
import com.androidbelieve.drawerwithswipetabs.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by priya on 7/16/2015.
 */
public class Register extends Activity {
    EditText etname ,etemail , etusername , etpassword, etconfirm_password;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        etusername = (EditText)findViewById(R.id.TFusername_register);
        etpassword = (EditText)findViewById(R.id.TFpassword_register);
        etname = (EditText)findViewById(R.id.TFname_register);
        etemail = (EditText)findViewById(R.id.TFemail_register);
        etconfirm_password = (EditText)findViewById(R.id.TFconfirm_password_register);

    }

    public void onLoginClick(View view)
    {
        Intent intent = new Intent(Register.this , Login.class);
        startActivity(intent);
    }

    public void onRegisterClick(View view){
        final String name = etname.getText().toString();
        final String email = etemail.getText().toString();
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();
        String confirm_password = etconfirm_password.getText().toString();
        final String emaill = etemail.getText().toString();
        if(!isValidEmail(emaill)){
            etemail.setError("Invalid Email");
        }


        if(password.equals(confirm_password) && isValidEmail(emaill))
        {
            Contact contact = new Contact(name ,email , username,password);
            ServerRequests serverRequests = new ServerRequests(this);

            serverRequests.storeDataInBackground(contact , new GetUserCallback() {
                @Override
                public void done(Contact returnedContact) {
                    Intent intent = new Intent(Register.this , otp.class);
                    startActivity(intent);

                    pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();

                    //Logged In, set loggedin to true boolean
                    editor.putString("Name", name);
                    editor.putString("Email", email);
                    editor.commit();

                }
            });
        }
        else{
            Toast.makeText(this , "Passwords don't match! Enter again!" , Toast.LENGTH_LONG).show();
        }

    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
