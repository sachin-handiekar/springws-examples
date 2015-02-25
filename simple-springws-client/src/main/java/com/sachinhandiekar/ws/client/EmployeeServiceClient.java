/**
 *
 */
package com.sachinhandiekar.ws.client;

import com.sachinhandiekar.service.employeeservice.CreateEmployeeRequest;
import com.sachinhandiekar.service.employeeservice.CreateEmployeeResponse;
import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

public class EmployeeServiceClient {

    static {
        BasicConfigurator.configure();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        WebServiceTemplate webServiceTemplate = (WebServiceTemplate) context.getBean("webServiceTemplate");

        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
        createEmployeeRequest.setFirstName("John");
        createEmployeeRequest.setLastName("Doe");
        createEmployeeRequest.setCity("New York");

        System.out.println("Sending request to webservice...");

        CreateEmployeeResponse createEmployeeResponse = (CreateEmployeeResponse) webServiceTemplate.marshalSendAndReceive(createEmployeeRequest);

        System.out.println("Received Response : " + createEmployeeResponse.isStatus());

    }

}
