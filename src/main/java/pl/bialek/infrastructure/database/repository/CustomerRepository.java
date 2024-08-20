package pl.bialek.infrastructure.database.repository;

import pl.bialek.business.dao.CustomerDAO;
import pl.bialek.domain.Customer;
import pl.bialek.infrastructure.database.entity.CustomerEntity;
import org.hibernate.Session;

import java.util.Objects;
import java.util.Optional;

public class CustomerRepository implements CustomerDAO {
    @Override
    public Optional<Customer> findByEmail(String email) {
        return null;
    }
    @Override
    public void issueInvoice(Customer customer) {
       return;
    }

    @Override
    public void saveServiceRequest(Customer customer) {

    }

    @Override
    public Customer saveCustomer(Customer entity) {

    }
}

