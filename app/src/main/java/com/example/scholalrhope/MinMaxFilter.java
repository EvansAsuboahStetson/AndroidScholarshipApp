package com.example.scholalrhope;

import android.text.InputFilter ;
import android.text.Spanned ;
public class MinMaxFilter implements InputFilter {
    private double mIntMin , mIntMax ;
    public MinMaxFilter ( double minValue , double maxValue) {
        this . mIntMin = minValue ;
        this . mIntMax = maxValue ;
    }
    public MinMaxFilter (String minValue , String maxValue) {
        this . mIntMin = Integer. parseInt (minValue) ;
        this . mIntMax = Integer. parseInt (maxValue) ;
    }
    @Override
    public CharSequence filter (CharSequence source , int start , int end , Spanned dest ,int dstart , int dend) {
        try {
            double input = Double. parseDouble (dest.toString() + source.toString()) ;
            if (isInRange( mIntMin , mIntMax , input))
                return null;
        } catch (NumberFormatException e) {
            e.printStackTrace() ;
        }
        return "" ;
    }
    private boolean isInRange ( double a , double b , double c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a ;
    }
}