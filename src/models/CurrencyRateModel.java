package models;

public class CurrencyRateModel {
    private String data;
    private Float rate;

    public CurrencyRateModel(String data, Float rate) {
        this.data = data;
        this.rate = rate;
    }

    public CurrencyRateModel() {
    }

    public String getData() {
        return data;
    }


    public Float getRate() {
        return rate;
    }

    public void setData(String data) {
        this.data = data;
    }

    public CurrencyRateModel setRate(Float rate) {
        this.rate = rate;

        return null;
    }
}
