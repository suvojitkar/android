package com.androidbelieve.drawerwithswipetabs.model;

/**
 * Created by Anshul on 24-03-2016.
 */
public class Track {
    private String product, conf, del, trans, date;

    public Track() {
    }

    public Track(String product, String conf, String del, String trans, String date) {
        this.product = product;
        this.conf = conf;
        this.del = del;
        this.trans = trans;
        this.date = date;
    }

    public String getConfirmation() {
        return conf;
    }

    public void setConfirmation(String conf) {
        this.conf = conf;
    }

    public String getDelivery() {
        return del;
    }

    public void setDelivery(String del) {
        this.del = del;
    }

    public String getTransportation() {
        return trans;
    }

    public void setTransportation(String trans) {
        this.trans = trans;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

