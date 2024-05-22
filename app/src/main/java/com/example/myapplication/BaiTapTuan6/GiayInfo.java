package com.example.myapplication.BaiTapTuan6;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class GiayInfo  implements Parcelable {
    String search_image;
    String styleid;
    String brands_filter_facet;
    String price;
    String product_additional_info;

    protected GiayInfo(Parcel in) {
        search_image = in.readString();
        styleid = in.readString();
        brands_filter_facet = in.readString();
        price = in.readString();
        product_additional_info = in.readString();
    }

    public static final Creator<GiayInfo> CREATOR = new Creator<GiayInfo>() {
        @Override
        public GiayInfo createFromParcel(Parcel in) {
            return new GiayInfo(in);
        }

        @Override
        public GiayInfo[] newArray(int size) {
            return new GiayInfo[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(search_image);
        dest.writeString(styleid);
        dest.writeString(brands_filter_facet);
        dest.writeString(price);
        dest.writeString(product_additional_info);
    }
}
