package com.ugothevenin.tuto_android;

public class Country implements Comparable<Country>{
    private String countryName;
    private int resId;

    public Country(String countryName, int resId){
        this.countryName = countryName;
        this.resId = resId;
    }
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
}
