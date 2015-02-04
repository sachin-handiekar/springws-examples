/**
 *
 */
package com.sachinhandiekar.ws.endpoint;

import com.sachinhandiekar.service.employeeservice.CreateEmployeeRequest;
import com.sachinhandiekar.service.employeeservice.CreateEmployeeResponse;
import com.sachinhandiekar.service.employeeservice.ObjectFactory;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeServiceEndpoint {

    private static final Logger logger = Logger.getLogger(EmployeeServiceEndpoint.class);


    @PayloadRoot(localPart = "CreateEmployeeRequest", namespace = "http://sachinhandiekar.com/service/EmployeeService")
    @ResponsePayload
    public CreateEmployeeResponse createEmployee(@RequestPayload CreateEmployeeRequest request) {

        logger.info("Creating employee...");
        logger.info(":: Request ::");

        logger.info("First Name : " + request.getFirstName());
        logger.info("Last Name : " + request.getLastName());
        logger.info("City : " + request.getCity());

        CreateEmployeeResponse response = new ObjectFactory().createCreateEmployeeResponse();
        response.setStatus(true);

        return response;
    }
}
