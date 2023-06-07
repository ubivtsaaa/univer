package com.example.aaa;

import java.time.LocalDateTime;

public class Message {
    private String sender;
    private String recipient;
    private String content;
    private LocalDateTime timestamp;

    public Message(String sender, String recipient, String content, LocalDateTime timestamp) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setContent(String newContent) {
        this.content = newContent;
    }

    @Override
    public String toString() {
        return "[" + timestamp.toString() + "] " + sender + " -> " + recipient + ": " + content;
    }
}