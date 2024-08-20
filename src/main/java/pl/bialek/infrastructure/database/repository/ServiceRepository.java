package pl.bialek.infrastructure.database.repository;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import pl.bialek.business.dao.ServiceDAO;
import pl.bialek.domain.Service;
import pl.bialek.infrastructure.database.entity.ServiceEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.Objects;
import java.util.Optional;

public class ServiceRepository implements ServiceDAO {
    @Override
    public Optional<Service> findByServiceCode(String serviceCode) {

    }
}
