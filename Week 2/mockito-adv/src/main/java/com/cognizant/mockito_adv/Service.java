package com.cognizant.mockito_adv;

public class Service {
    private final Repository repository;
    public Service(Repository repository) {
        this.repository = repository;
    }
    public String processData() {
        // In a real app, this would be complex logic.
        return "Processed " + repository.getData();
    }
}
