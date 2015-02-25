package com.sachinhandiekar.ws.endpoint;

import com.sachinhandiekar.service.employeeservice.CreateEmployeeRequest;
import com.sachinhandiekar.service.employeeservice.CreateEmployeeResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Source;

import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;


/**
 * Created by sachin.handiekar on 25/02/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class EmployeeServiceEndpointTest {

    @Autowired
    private ApplicationContext applicationContext;

    private MockWebServiceClient mockClient;

    @Before
    public void createClient() {
        mockClient = MockWebServiceClient.createClient(applicationContext);
    }


    @Test
    public void testEmployeeServiceEndpoint() throws Exception {


        CreateEmployeeRequest request = createEmployeeRequestPayload("John", "Doe", "New York");

        //Response
        CreateEmployeeResponse createEmployeeResponse = new CreateEmployeeResponse();
        createEmployeeResponse.setStatus(true);

        mockClient.sendRequest(withPayload(getSourceFromJAXBObjcet(request)))
                .andExpect(payload(getSourceFromJAXBObjcet(createEmployeeResponse)));

    }

    private CreateEmployeeRequest createEmployeeRequestPayload(String firstName, String lastName, String city) {
        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
        createEmployeeRequest.setFirstName("John");
        createEmployeeRequest.setLastName("Doe");
        createEmployeeRequest.setCity("New York");

        return createEmployeeRequest;
    }

    private Source getSourceFromJAXBObjcet(Object jaxbObject) throws Exception {
        return new JAXBSource(JAXBContext.newInstance(jaxbObject.getClass()), jaxbObject);
    }

    private Source getSourceFromXMLString(String xmlString) throws Exception {
        return new StringSource(xmlString);
    }


}
