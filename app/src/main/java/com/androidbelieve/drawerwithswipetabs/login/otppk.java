package com.androidbelieve.drawerwithswipetabs.login;

/**
 * Created by Nicks on 24-03-2016.
 */
public class otppk {

    String name , email , username , password,otpp;

    public otppk(String name , String email , String username , String password)
    {
        this.name = name;
        this.email = email ;
        this.username = username;
        this.password = password;
    }

    public otppk(String username)
    {

        this.username = username;
        this.password = password;
    }


    public otppk(String name, String email, String username, String password, String otpp)
    {
        this.otpp = otpp;
    }
}
