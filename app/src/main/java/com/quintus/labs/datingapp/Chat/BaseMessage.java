package com.quintus.labs.datingapp.Chat;

import android.widget.TextView;

public class BaseMessage {

    String message, sender, sentAt;
    int id;

    BaseMessage() {
        message = "Howdy";
        sender = "John Doe";
        sentAt = "14:25";
        id = 2;
    }

    BaseMessage(String message, String sender, String sentAt, int id) {
        this.message = message;
        this.sender = sender;
        this.sentAt = sentAt;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMessage() { return message; }

    public String getSender() { return sender; }

    public String getSentAt() { return sentAt; }
}
