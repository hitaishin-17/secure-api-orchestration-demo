package com.example.orchestration.workflow;

import com.example.orchestration.model.Customer;
import com.example.orchestration.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrchestrationFlow {

    private static final Logger logger = LoggerFactory.getLogger(OrchestrationFlow.class);

    private final CustomerService customerService;

    public OrchestrationFlow(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Simulates a customer onboarding workflow that could represent BPMN-like steps.
     */
    @Async
    public void onboardCustomer(Customer customer) {
        logger.info("⏳ Starting orchestration flow for customer: {}", customer.getEmail());

        try {
            // Step 1: Save customer data
            customerService.saveCustomer(customer);
            logger.info("✅ Customer saved");

            // Step 2: Send welcome notification (mock)
            sendWelcomeNotification(customer);
            logger.info("✅ Welcome notification sent");

            // Step 3: Trigger next logical step
            triggerKYCProcess(customer);
            logger.info("✅ KYC triggered");

        } catch (Exception e) {
            logger.error("❌ Error during orchestration for {}: {}", customer.getEmail(), e.getMessage());
        }
    }

    private void sendWelcomeNotification(Customer customer) {
        // Placeholder for sending Email/SMS
        logger.debug("📨 Sending welcome message to {}", customer.getEmail());
    }

    private void triggerKYCProcess(Customer customer) {
        // Placeholder for async workflow to start KYC or verification
        logger.debug("🔍 Triggering KYC process for {}", customer.getEmail());
    }
}