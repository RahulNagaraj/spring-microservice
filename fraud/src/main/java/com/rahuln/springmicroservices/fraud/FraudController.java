package com.rahuln.springmicroservices.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFrauster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulent = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulent);
    }
}
