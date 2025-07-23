package com.cognizant.mockito_adv;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AdvancedMockitoExercisesTest {

    // Exercise 1
    @Test
    public void testServiceWithMockRepository() {
        // 1. Arrange: Create a mock repository
        Repository mockRepository = Mockito.mock(Repository.class);
        Service service = new Service(mockRepository);

        // 2. Arrange: Stub the repository method to return predefined data
        when(mockRepository.getData()).thenReturn("Mock Data");

        // 3. Act: Call the service method that uses the repository
        String result = service.processData();

        // 4. Assert: Verify the service logic worked as expected with mock data
        assertEquals("Processed Mock Data", result);
        verify(mockRepository).getData(); // Verify that the getData method was called
    }

    // Exercise 2
    @Test
    public void testServiceWithMockRestClient() {
        // 1. Arrange: Create a mock REST client
        RestClient mockRestClient = Mockito.mock(RestClient.class);
        ApiService apiService = new ApiService(mockRestClient);

        // 2. Arrange: Stub the client method to return a predefined response
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // 3. Act: Call the service method that uses the client
        String result = apiService.fetchData();

        // 4. Assert: Verify the service logic using the mocked response
        assertEquals("Fetched Mock Response", result);
        verify(mockRestClient).getResponse();
    }

    // Exercise 3
    @Test
    public void testServiceWithMockFileIO() {
        // 1. Arrange: Create mock file reader and writer
        FileReader mockFileReader = Mockito.mock(FileReader.class);
        FileWriter mockFileWriter = Mockito.mock(FileWriter.class);
        FileService fileService = new FileService(mockFileReader, mockFileWriter);

        // 2. Arrange: Stub the reader to simulate reading from a file
        when(mockFileReader.read()).thenReturn("Mock File Content");

        // 3. Act: Call the service method that processes the file
        String result = fileService.processFile();

        // 4. Assert: Verify the logic and the interaction with the writer
        assertEquals("Processed Mock File Content", result);
        verify(mockFileReader).read(); // Ensure the file was read
        verify(mockFileWriter).write("Processed Mock File Content"); // Ensure the result was written
    }

    // Exercise 4
    @Test
    public void testServiceWithMockNetworkClient() {
        // 1. Arrange: Create a mock network client
        NetworkClient mockNetworkClient = mock(NetworkClient.class);
        NetworkService networkService = new NetworkService(mockNetworkClient);

        // 2. Arrange: Stub the client method to simulate a connection
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // 3. Act: Call the service method
        String result = networkService.connectToServer();

        // 4. Assert: Verify the service logic using the mocked connection
        assertEquals("Connected to Mock Connection", result);
        verify(mockNetworkClient).connect();
    }

    // Exercise 5
    @Test
    public void testServiceWithMultipleReturnValues() {
        // 1. Arrange: Create a mock repository
        Repository mockRepository = Mockito.mock(Repository.class);
        Service service = new Service(mockRepository);

        // 2. Arrange: Stub the method to return different values on consecutive calls
        when(mockRepository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        // 3. Act & Assert (First Call)
        String firstResult = service.processData();
        assertEquals("Processed First Mock Data", firstResult);

        // 4. Act & Assert (Second Call)
        String secondResult = service.processData();
        assertEquals("Processed Second Mock Data", secondResult);

        // 5. Verify: Check that getData() was called twice
        verify(mockRepository, times(2)).getData();
    }
}