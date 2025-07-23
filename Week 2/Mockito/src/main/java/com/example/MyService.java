package com.example;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataById(String id) {
        return externalApi.getData(id);
    }

    public void executeAction(String command) {
        externalApi.performAction(command);
    }

    public void doSomethingVoid() {
        externalApi.voidMethod();
    }

    public void performMultipleActions() {
        externalApi.getData("setup");
        externalApi.performAction("execute");
    }
}
