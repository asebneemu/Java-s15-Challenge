package com.library.model;

public class BasicInvoice implements Invoice {
    private double amount;

    public BasicInvoice(double amount) {
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void printInvoice() {
        System.out.println("Fatura Tutarı: " + amount + " TL");
    }
}
