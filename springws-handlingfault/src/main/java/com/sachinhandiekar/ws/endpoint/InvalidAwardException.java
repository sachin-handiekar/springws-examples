package com.sachinhandiekar.ws.endpoint;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT, faultStringOrReason = "Invalid Award Id...")
public class InvalidAwardException extends Exception {

    public InvalidAwardException(String message) {
        super(message);
    }
}
