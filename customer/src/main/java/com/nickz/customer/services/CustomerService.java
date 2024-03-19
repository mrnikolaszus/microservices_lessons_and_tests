package com.nickz.customer.services;

import com.nickz.customer.controllers.CustomerRegistrationRequest;
import com.nickz.customer.entity.Customer;
import com.nickz.isIllegal.IsIllegal;
import com.nickz.isIllegal.ValidCheckResponse;
import com.nickz.rabbitmq.models.RabbitMQMessageProducer;
import com.nickz.notification.NotificationRequest;
import com.nickz.customer.repostitories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService{

    private final CustomerRepository customerRepository;
    private final IsIllegal isIllegal;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;


    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();


        customerRepository.saveAndFlush(customer);

        ValidCheckResponse checkResponse = isIllegal.isValid(customer.getId());

        if(checkResponse.isIllegal()){
            throw new IllegalStateException("isIllegal");
        }

        var notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("%s, welcome to tests", customer.getFirstName())
        );

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"

        );


//        rabbitmq:
//        exchanges:
//        internal: internal.exchange
//        queue:
//        notification: notification.queue
//        routing-keys:
//        internal-notification: internal.notification.routing-key

    }
}
