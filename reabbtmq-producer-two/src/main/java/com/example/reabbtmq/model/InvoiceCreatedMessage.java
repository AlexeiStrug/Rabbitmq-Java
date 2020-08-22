package com.example.reabbtmq.model;

import com.example.reabbtmq.model.json.CustomLocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.StringJoiner;

public class InvoiceCreatedMessage {

    private double amount;

    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate createdDate;

    private String currency;

    private String invoiceNumber;

    public InvoiceCreatedMessage() {
    }

    public InvoiceCreatedMessage(double amount, LocalDate createdDate, String currency, String invoiceNumber) {
        this.amount = amount;
        this.createdDate = createdDate;
        this.currency = currency;
        this.invoiceNumber = invoiceNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InvoiceCreatedMessage.class.getSimpleName() + "[", "]")
                .add("amount=" + amount)
                .add("createdDate=" + createdDate)
                .add("currency='" + currency + "'")
                .add("invoiceNumber='" + invoiceNumber + "'")
                .toString();
    }
}
