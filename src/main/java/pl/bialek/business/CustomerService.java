package pl.bialek.business;

import lombok.AllArgsConstructor;
import pl.bialek.business.dao.CustomerDAO;
import pl.bialek.domain.Address;
import pl.bialek.domain.Customer;

import java.util.Optional;

@AllArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;

    public void issueInvoice(Customer customer) {
        customerDAO.issueInvoice(customer);
    }

    public Customer findCustomer(String email) {
        Optional<Customer> customer = customerDAO.findByEmail(email);
        if (email.isEmpty()) {
            throw new RuntimeException("Provided customer with email: [%s] doesn't exist".formatted(customer));
        }
        return customer.get();
    }

    public void saveServiceRequest(Customer customer) {
        customerDAO.saveServiceRequest(customer);
    }

    public Customer saveCustomer(Customer customer) {
        Customer savingCustomer = Customer.builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .address(
                        Address
                                .builder()
                                .country(customer.getAddress().getCountry())
                                .city(customer.getAddress().getCity())
                                .postalCode(customer.getAddress().getPostalCode())
                                .address(customer.getAddress().getAddress())
                                .build())
                .build();
        return customerDAO.saveCustomer(savingCustomer);
    }
}

