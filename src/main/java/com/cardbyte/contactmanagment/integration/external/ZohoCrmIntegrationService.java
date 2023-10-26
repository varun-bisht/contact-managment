package com.cardbyte.contactmanagment.integration.external;

import com.cardbyte.contactmanagment.common.exception.CompanyAlreadyExistInCrmException;
import com.cardbyte.contactmanagment.common.exception.ContactAlreadyExistInCrmException;
import com.cardbyte.contactmanagment.integration.external.request.ZohoCompanyRequest;
import com.cardbyte.contactmanagment.integration.external.request.ZohoContactRequest;
import com.cardbyte.contactmanagment.integration.external.response.ZohoCompanyResponse;
import com.cardbyte.contactmanagment.integration.external.response.ZohoContactResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ZohoCrmIntegrationService{

    private WebClient webClient;
    private ObjectMapper objectMapper;

    @Value("${zoho.crm.company.url}")
    private String zohoCreateUrl;

    @Value("${zoho.crm.contact.url}")
    private String zohoContactUrl;

    @Autowired
    public ZohoCrmIntegrationService() {
        this.webClient = WebClient.builder().build();
        this.objectMapper = new ObjectMapper();
    }

    public Mono<ZohoCompanyResponse> postDataToZohoCrm(ZohoCompanyRequest zohoCompanyRequest) {
        // Convert the Java object to a JSON string
        String jsonBody;
        try {
            jsonBody = objectMapper.writeValueAsString(zohoCompanyRequest);
        } catch (JsonProcessingException e) {
            return Mono.error(new IllegalArgumentException("Error converting the object to JSON.", e));
        }

        return webClient
                .post()
                .uri(zohoCreateUrl) // Specify the base URL here
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(jsonBody), String.class)
                .exchange()
                .flatMap(clientResponse -> {
                    if (clientResponse.statusCode().is5xxServerError()) {
                        return Mono.error(new IllegalArgumentException("Zoho CRM server error"));
                    }
                    return clientResponse.bodyToMono(String.class);
                })
                .flatMap(responseJson -> {
                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        ZohoCompanyResponse responseData = objectMapper.readValue(responseJson, ZohoCompanyResponse.class);
                        return Mono.just(responseData);
                    } catch (JsonProcessingException e) {
                        return Mono.error(new IllegalArgumentException("Error parsing JSON response.", e));
                    }
                })
                .onErrorResume(error -> {
                    // Handle the error and return a default response object
                    System.err.println("Error: " + error.getMessage());
                    return Mono.error(new CompanyAlreadyExistInCrmException()); // Replace with your default response
                });
    }

    public Mono<ZohoContactResponse> postContactDataToZohoCrm(ZohoContactRequest zohoContactRequest) {
        // Convert the Java object to a JSON string
        String jsonBody;
        try {
            jsonBody = objectMapper.writeValueAsString(zohoContactRequest);
        } catch (JsonProcessingException e) {
            return Mono.error(new IllegalArgumentException("Error converting the object to JSON.", e));
        }

        return webClient
                .post()
                .uri(zohoContactUrl) // Specify the base URL here
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(jsonBody), String.class)
                .exchange()
                .flatMap(clientResponse -> {
                    if (clientResponse.statusCode().is5xxServerError()) {
                        return Mono.error(new IllegalArgumentException("Zoho CRM server error"));
                    }
                    return clientResponse.bodyToMono(String.class);
                })
                .flatMap(responseJson -> {
                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        ZohoContactResponse responseData = objectMapper.readValue(responseJson, ZohoContactResponse.class);
                        return Mono.just(responseData);
                    } catch (JsonProcessingException e) {
                        return Mono.error(new IllegalArgumentException("Error parsing JSON response.", e));
                    }
                })
                .onErrorResume(error -> {
                    // Handle the error and return a default response object
                    System.err.println("Error: " + error.getMessage());
                    return Mono.error(new ContactAlreadyExistInCrmException()); // Replace with your default response
                });
    }



}
