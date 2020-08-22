package com.example.reabbtmq.model;

import java.util.StringJoiner;

public class DummyMessage {

    private String content;

    private int publishOrder;

    public DummyMessage() {
    }

    public DummyMessage(String content, int publishOrder) {
        this.content = content;
        this.publishOrder = publishOrder;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPublishOrder() {
        return publishOrder;
    }

    public void setPublishOrder(int publishOrder) {
        this.publishOrder = publishOrder;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DummyMessage.class.getSimpleName() + "[", "]")
                .add("content='" + content + "'")
                .add("publishOrder=" + publishOrder)
                .toString();
    }
}
