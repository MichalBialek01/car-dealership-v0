package pl.bialek.infrastructure.database.repository;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import pl.bialek.business.dao.PartDAO;
import pl.bialek.domain.Part;
import pl.bialek.infrastructure.database.entity.PartEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.Objects;
import java.util.Optional;

public class PartRepository implements PartDAO {
    @Override
    public Optional<Part> findBySerialNumber(String serialNumber) {


    }
}
