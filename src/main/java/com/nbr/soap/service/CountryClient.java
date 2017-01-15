package com.nbr.soap.service;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.nbr.soap.service.wsdl.GetCountryNameRequest;
import com.nbr.soap.service.wsdl.GetCountryNameResponse;
import com.nbr.soap.service.wsdl.GetCountryRequest;
import com.nbr.soap.service.wsdl.GetCountryResponse;

@Service
public class CountryClient extends WebServiceGatewaySupport {
	
	public GetCountryResponse getCountry(String name) {
		GetCountryRequest request = new GetCountryRequest();
		request.setName(name);
		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws", request,
				new SoapActionCallback("http://localhost:8080/getCountryRequest"));
		return response;
	}
	
	public GetCountryNameResponse getCountryName(String name) {
		GetCountryNameRequest request = new GetCountryNameRequest();
		request.setName(name);
		GetCountryNameResponse response = (GetCountryNameResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws", request,
				new SoapActionCallback("http://localhost:8080/getCountryNameRequest"));
		return response;
	}

}
