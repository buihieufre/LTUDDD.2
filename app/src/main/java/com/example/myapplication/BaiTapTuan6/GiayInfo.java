package com.example.myapplication.BaiTapTuan6;

public class GiayInfo {
    String search_image;
    String styleid;
    String brands_filter_facet;
    String price;
    String product_additional_info;

    public String getSearch_image() {
        return search_image;
    }

    public void setSearch_image(String search_image) {
        this.search_image = search_image;
    }

    public String getStyleid() {
        return styleid;
    }

    public void setStyleid(String styleid) {
        this.styleid = styleid;
    }

    public String getBrands_filter_facet() {
        return brands_filter_facet;
    }

    public void setBrands_filter_facet(String brands_filter_facet) {
        this.brands_filter_facet = brands_filter_facet;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProduct_additional_info() {
        return product_additional_info;
    }

    public void setProduct_additional_info(String product_additional_info) {
        this.product_additional_info = product_additional_info;
    }
    public GiayInfo(){};
    public GiayInfo(String search_image, String styleid, String brands_filter_facet, String price, String product_additional_info) {
        this.search_image = search_image;
        this.styleid = styleid;
        this.brands_filter_facet = brands_filter_facet;
        this.price = price;
        this.product_additional_info = product_additional_info;
    }
}
