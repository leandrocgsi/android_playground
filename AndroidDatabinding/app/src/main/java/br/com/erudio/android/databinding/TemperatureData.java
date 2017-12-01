package br.com.erudio.android.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.Observable;

public class TemperatureData extends BaseObservable {
    private String celsius;

    public TemperatureData(String celsius) {
        this.celsius = celsius;
    }

    @Bindable
    public String getCelsius() {
        return celsius;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
    }
}