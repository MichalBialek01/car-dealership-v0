package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.ServiceDAO;
import pl.bialek.domain.Service;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ServiceRepository implements ServiceDAO {
    @Override
    public Optional<Service> findByServiceCode(String serviceCode) {

    }
}
