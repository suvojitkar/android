package com.androidbelieve.drawerwithswipetabs.model;

/**
 * Created by Anshul on 25-03-2016.
 */
public class Promo_Model {

    private String product,brand,region;

        public Promo_Model() {
        }

        public Promo_Model(String product, String brand, String region) {

            this.product = product;
            this.brand = brand;
            this.region = region;
        }

        public String getPromoProduct() {
            return product;
        }

        public void setPromoProduct(String product) {
            this.product = product;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

}

