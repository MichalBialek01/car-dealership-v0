package pl.bialek.infrastructure.database.repository;

import pl.bialek.business.dao.SalesmanDAO;
import pl.bialek.domain.Salesman;
import pl.bialek.infrastructure.database.entity.SalesmanEntity;
import org.hibernate.Session;

import java.util.Objects;
import java.util.Optional;

public class SalesmanRepository implements SalesmanDAO {

    @Override
    public Optional<Salesman> findByPesel(String pesel) {

    }

}
