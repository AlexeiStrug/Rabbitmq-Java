package com.example.reabbtmq.model;

import com.example.reabbtmq.model.json.CustomLocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
import java.util.StringJoiner;

public class InvoiceCancelledMessage {

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate cancelDate;

    private String invoiceNumber;

    private String reason;

    public InvoiceCancelledMessage() {
    }

    public InvoiceCancelledMessage(LocalDate cancelDate, String invoiceNumber, String reason) {
        this.cancelDate = cancelDate;
        this.invoiceNumber = invoiceNumber;
        this.reason = reason;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InvoiceCancelledMessage.class.getSimpleName() + "[", "]")
                .add("cancelDate=" + cancelDate)
                .add("invoiceNumber='" + invoiceNumber + "'")
                .add("reason='" + reason + "'")
                .toString();
    }
}
