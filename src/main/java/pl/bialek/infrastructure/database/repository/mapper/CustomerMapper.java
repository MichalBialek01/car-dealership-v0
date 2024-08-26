package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.Customer;
import pl.bialek.infrastructure.database.entity.CustomerEntity;

public interface CustomerMapper {
    Customer mapFromEntity(CustomerEntity customerEntity);

    CustomerEntity mapToEntity(Customer customer);
}
