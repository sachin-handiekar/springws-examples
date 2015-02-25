package com.sachinhandiekar.ws.endpoint;

import com.sachinhandiekar.service.awardservice.AwardServiceRequest;
import com.sachinhandiekar.service.awardservice.AwardServiceResponse;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AwardServiceEndpoint {

    private static final Logger logger = Logger.getLogger(AwardServiceEndpoint.class);


    @PayloadRoot(localPart = "AwardServiceRequest", namespace = "http://sachinhandiekar.com/service/AwardService")
    @ResponsePayload
    public AwardServiceResponse getAwardDetails(@RequestPayload AwardServiceRequest request) throws Exception {


        AwardServiceResponse awardServiceResponse = new AwardServiceResponse();
        awardServiceResponse.setStatus(true);

        if (request.getAwardId() == 1) {
            throw new Exception("Fault has occurred!!!");
        }

        return awardServiceResponse;
    }


    @PayloadRoot(localPart = "AwardServiceRequest", namespace = "http://sachinhandiekar.com/service/AwardService")
    @ResponsePayload
    public AwardServiceResponse cancelAwardRequest(@RequestPayload AwardServiceRequest request) throws Exception {


        AwardServiceResponse awardServiceResponse = new AwardServiceResponse();
        awardServiceResponse.setStatus(true);

        if (request.getAwardId() == 1)
            throw new Exception("Fault has occurred!!!");

        return awardServiceResponse;
    }

}
