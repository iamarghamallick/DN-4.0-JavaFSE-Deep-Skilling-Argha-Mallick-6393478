package com.example;

public interface ExternalApi {
    String getData();
    String getData(String id);
    void performAction(String command);
    void voidMethod();
}
