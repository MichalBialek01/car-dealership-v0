package pl.bialek.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.bialek.domain.Customer;
import pl.bialek.infrastructure.database.entity.CustomerEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    Customer mapFromEntity(CustomerEntity customerEntity);

    CustomerEntity mapToEntity(Customer customer);
}
