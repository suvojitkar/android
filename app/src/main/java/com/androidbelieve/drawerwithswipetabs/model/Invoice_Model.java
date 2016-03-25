package com.androidbelieve.drawerwithswipetabs.model;

/**
 * Created by Anshul on 25-03-2016.
 */
public class Invoice_Model {

    private String cid, bdate, bdoc, pmethod, pqty;

    public Invoice_Model() {
    }

    public Invoice_Model(String cid, String bdate, String bdoc, String pmethod, String pqty) {

        this.cid = cid;
        this.bdate = bdate;
        this.bdoc = bdoc;
        this.pmethod = pmethod;
        this.pqty = pqty;
    }

    public String getCustId() {
        return cid;
    }

    public void setCustId(String cid) {
        this.cid = cid;
    }

    public String getBillDate() {
        return bdate;
    }

    public void setBillDate(String bdate) {
        this.bdate = bdate;
    }

    public String getBillDoc() {
        return bdoc;
    }

    public void setBillDoc(String bdoc) {
        this.bdoc = bdoc;
    }

    public String getPaymentMethod() {
        return pmethod;
    }

    public void setPaymentMethod(String pmethod) {
        this.pmethod= pmethod;
    }

    public String getProdQty() {
        return pqty;
    }

    public void setProdQty(String pqty) {
        this.pqty = pqty;
    }

}
