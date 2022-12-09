package com.example.finalproject4;
//Maria Santos - Final Project
public class ElementsModel {
    String name;
    int number;
    String summary;
    String symbol;


    public ElementsModel(String name, int number, String summary, String symbol) {
        this.name = name;
        this.number = number;
        this.summary = summary;
        this.symbol = symbol;
    }

    public ElementsModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
