package com.example.reabbtmq.model;

import com.example.reabbtmq.model.json.CustomLocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.StringJoiner;

public class InvoicePaidMessage {

    private String invoiceNumber;

    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate paidDate;

    private String paymentNumber;

    public InvoicePaidMessage() {
    }

    public InvoicePaidMessage(String invoiceNumber, LocalDate paidDate, String paymentNumber) {
        this.invoiceNumber = invoiceNumber;
        this.paidDate = paidDate;
        this.paymentNumber = paymentNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDate paidDate) {
        this.paidDate = paidDate;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InvoicePaidMessage.class.getSimpleName() + "[", "]")
                .add("invoiceNumber='" + invoiceNumber + "'")
                .add("paidDate=" + paidDate)
                .add("paymentNumber='" + paymentNumber + "'")
                .toString();
    }
}
