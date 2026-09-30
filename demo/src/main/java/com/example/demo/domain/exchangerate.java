package com.example.demo.domain;

import jakarta.persistence.*;


@Entity 
@Table (name = "exchange_rates")
public class exchangerate {

@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name= "from_currency")
private String fromCurrency;

@Column(name= "to_currency")
private String toCurrency;

@Column(name = "rate")
private double rate;

public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    // Getter and Setter for fromCurrency
    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }


    // Getter and Setter for toCurrency
    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }


    // Getter and Setter for rate
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


}
