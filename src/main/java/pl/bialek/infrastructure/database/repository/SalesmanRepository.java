package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.SalesmanDAO;
import pl.bialek.domain.Salesman;
import pl.bialek.infrastructure.database.entity.SalesmanEntity;
import org.hibernate.Session;
import pl.bialek.infrastructure.database.repository.jpa.MechanicJpaRepository;
import pl.bialek.infrastructure.database.repository.jpa.SalesmanJpaRepository;
import pl.bialek.infrastructure.database.repository.mapper.SalesmanMapper;

import java.util.Objects;
import java.util.Optional;
@Repository
@AllArgsConstructor
public class SalesmanRepository implements SalesmanDAO {
    private final SalesmanJpaRepository salesmanJpaRepository;
    private final SalesmanMapper salesmanMapper;
    @Override
    public Optional<Salesman> findByPesel(String pesel) {
        return salesmanJpaRepository.findByPesel(pesel)
                .map(salesmanMapper::mapFromEntity);
    }

}
