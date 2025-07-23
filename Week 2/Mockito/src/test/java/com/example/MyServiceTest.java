package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {
        // 1. Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Stub the method with an argument matcher
        when(mockApi.getData(anyString())).thenReturn("Mock Data For Any ID");

        // 2. Call the method with specific arguments
        String result = service.fetchDataById("user123");
        service.executeAction("COMMIT");

        // Assert the result
        assertEquals("Mock Data For Any ID", result);

        // 3. Use argument matchers to verify the interaction
        // Verify getData was called with any string as an argument
        verify(mockApi).getData(anyString());

        // Verify performAction was called with the exact string "COMMIT"
        verify(mockApi).performAction(eq("COMMIT"));
    }

    @Test
    public void testVoidMethod() {
        // 1. Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Stub the void method (optional, but good practice for clarity)
        // This tells Mockito to do nothing when voidMethod() is called.
        // This is the default behavior, but explicit stubbing can be clearer.
        doNothing().when(mockApi).voidMethod();

        // Call the service method that invokes the void method
        service.doSomethingVoid();

        // 3. Verify the interaction
        // Check that voidMethod() was called exactly once
        verify(mockApi, times(1)).voidMethod();
    }

    @Test
    public void testMultipleReturns() {
        // 1. Create a mock object for the external API
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Stub the method to return different values on consecutive calls
        when(mockApi.getData())
                .thenReturn("First Call Data")
                .thenReturn("Second Call Data")
                .thenReturn("Third Call Data");

        // 3. Write a test case that uses the mock object
        // First call
        assertEquals("First Call Data", service.fetchData());

        // Second call
        assertEquals("Second Call Data", service.fetchData());

        // Third and subsequent calls
        assertEquals("Third Call Data", service.fetchData());
        assertEquals("Third Call Data", service.fetchData());
    }

    @Test
    public void testInteractionOrder() {
        // 1. Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Create an InOrder verifier for the mock
        InOrder inOrder = inOrder(mockApi);

        // 2. Call the methods in a specific order
        service.performMultipleActions();

        // 3. Verify the interaction order
        // Verify that getData("setup") was called before performAction("execute")
        inOrder.verify(mockApi).getData("setup");
        inOrder.verify(mockApi).performAction("execute");
    }

    @Test
    public void testVoidMethodWithException() {
        // 1. Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Stub the void method to throw an exception
        doThrow(new IllegalStateException("Action Failed!"))
                .when(mockApi).voidMethod();

        // 3. Verify the interaction and the exception
        // Assert that calling the service method triggers the stubbed exception
        Exception exception = assertThrows(IllegalStateException.class, service::doSomethingVoid);

        // Optionally, assert the exception message
        assertEquals("Action Failed!", exception.getMessage());

        // Verify that the voidMethod was indeed called, which caused the exception
        verify(mockApi).voidMethod();
    }
}