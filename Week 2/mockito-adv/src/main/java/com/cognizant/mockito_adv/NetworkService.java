package com.cognizant.mockito_adv;

public class NetworkService {
    private final NetworkClient networkClient;
    public NetworkService(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }
    public String connectToServer() {
        return "Connected to " + networkClient.connect();
    }
}
