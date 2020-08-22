package com.example.reabbtmq.model;

import com.example.reabbtmq.model.json.CustomLocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.StringJoiner;

public class PaymentCancelStatus {

    private boolean cancelStatus;

    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate cancelDate;

    private String invoiceNumber;

    public PaymentCancelStatus() {
    }

    public PaymentCancelStatus(boolean cancelStatus, LocalDate cancelDate, String invoiceNumber) {
        this.cancelStatus = cancelStatus;
        this.cancelDate = cancelDate;
        this.invoiceNumber = invoiceNumber;
    }

    public boolean isCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(boolean cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public LocalDate getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(LocalDate cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PaymentCancelStatus.class.getSimpleName() + "[", "]")
                .add("cancelStatus=" + cancelStatus)
                .add("cancelDate=" + cancelDate)
                .add("invoiceNumber='" + invoiceNumber + "'")
                .toString();
    }
}
