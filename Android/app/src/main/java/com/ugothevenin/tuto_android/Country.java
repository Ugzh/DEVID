package com.ugothevenin.tuto_android;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

public class Country implements Comparable<Country>, Parcelable {
    private String countryName;
    private int resId;

    private String urlPicture;

    public Country(String countryName, int resId){
        this.countryName = countryName;
        this.resId = resId;
    }

    public Country(String countryName, String urlPicture){
        this.countryName = countryName;
        this.urlPicture = urlPicture;
    }

    protected Country(Parcel in) {
        countryName = in.readString();
        resId = in.readInt();
        urlPicture = in.readString();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public String getCountryName() {
        return countryName;
    }
    public int getResId() {
        return resId;
    }

    @Override
    public int compareTo(Country country) {
        String compareCountryName = country.getCountryName();
        return this.getCountryName().compareTo(compareCountryName) ;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(countryName);
        parcel.writeInt(resId);
        parcel.writeString(urlPicture);
    }
}
