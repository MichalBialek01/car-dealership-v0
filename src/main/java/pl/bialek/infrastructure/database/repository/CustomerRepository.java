package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.CustomerDAO;
import pl.bialek.domain.Customer;
import pl.bialek.infrastructure.database.entity.CarServiceRequestEntity;
import pl.bialek.infrastructure.database.entity.CarToServiceEntity;
import pl.bialek.infrastructure.database.entity.CustomerEntity;
import org.hibernate.Session;
import pl.bialek.infrastructure.database.repository.jpa.CarServiceRequestJpaRepository;
import pl.bialek.infrastructure.database.repository.jpa.CustomerJpaRepository;
import pl.bialek.infrastructure.database.repository.jpa.InvoiceJpaRepository;
import pl.bialek.infrastructure.database.repository.mapper.CarServiceRequestMapper;
import pl.bialek.infrastructure.database.repository.mapper.CustomerMapper;
import pl.bialek.infrastructure.database.repository.mapper.InvoiceMapper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Repository
@AllArgsConstructor
public class CustomerRepository implements CustomerDAO {

    private final CustomerJpaRepository customerJpaRepository;
    private final InvoiceJpaRepository invoiceJpaRepository;
    private final CarServiceRequestJpaRepository carServiceRequestJpaRepository;

    private final CustomerMapper customerMapper;
    private final InvoiceMapper invoiceMapper;
    private final CarServiceRequestMapper carServiceRequestMapper;
    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerJpaRepository.findByEmail(email)
                .map(customerMapper::mapFromEntity);
    }
    @Override
    public void issueInvoice(Customer customer) {
        CustomerEntity customerToSave = customerMapper.mapToEntity(customer);
        CustomerEntity customerSaved = customerJpaRepository.saveAndFlush(customerToSave);

        customer.getInvoices().stream()
                .filter(invoice -> Objects.isNull(invoice.getInvoiceId()))
                .map(invoiceMapper::mapToEntity)
                .forEach(invoiceEntity -> {
                    invoiceEntity.setCustomer(customerSaved);
                    invoiceJpaRepository.saveAndFlush(invoiceEntity);
                });
    }

    @Override
    public void saveServiceRequest(Customer customer) {
        // Z obiektu domenowego customer należy pobrać wszystkie serviceRequesst i do zapisać jako encja
        List<CarServiceRequestEntity> carServiceRequestEntities = customer.getCarServiceRequests().stream()
                .map(carServiceRequestMapper::mapToEntity)
                .toList();

        carServiceRequestEntities.forEach(requestEntity -> requestEntity.setCustomer(customerMapper.mapToEntity(customer)));

        carServiceRequestJpaRepository.saveAllAndFlush(carServiceRequestEntities);
    }
    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity customerEntity = customerMapper.mapToEntity(customer);
        CustomerEntity saved = customerJpaRepository.save(customerEntity);
        return customerMapper.mapFromEntity(saved);

    }
}

