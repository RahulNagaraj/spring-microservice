package com.rahuln.springmicroservices.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // Todo: check if email is valid
        // Todo: check if email is not taken
        repository.saveAndFlush(customer);
        // Todo: check if customer is fraudster
        FraudCheckResponse response = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (response != null && response.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }

        // Todo: send notification
    }
}
