package pl.bialek.infrastructure.database.repository;

import pl.bialek.business.dao.CustomerDAO;
import pl.bialek.infrastructure.database.entity.CustomerEntity;
import org.hibernate.Session;

import java.util.Objects;
import java.util.Optional;

public class CustomerRepository implements CustomerDAO {
    @Override
    public Optional<CustomerEntity> findByEmail(String email) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String hqlQuery = "SELECT customer FROM CustomerJpaRepository customer WHERE customer.email = :email";
            Optional<CustomerEntity> queryResult = session.createQuery(hqlQuery, CustomerEntity.class)
                    .setParameter("email", email)
                    .uniqueResultOptional();
            session.getTransaction().commit();
            return queryResult;
        }
    }


    @Override
    public void issueInvoice(CustomerEntity customer) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            if (Objects.isNull(customer.getCustomerId())) {
                session.persist(customer);
            }
            customer.getInvoices().stream()
                    .filter(invoice -> Objects.isNull(invoice.getInvoiceId()))
                    .forEach(invoice -> {
                        invoice.setCustomer(customer);
                        session.persist(invoice);
                    });

            session.getTransaction().commit();
        }
    }

    @Override
    public void saveServiceRequest(CustomerEntity customer) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            customer.getCarServiceRequests().stream()
                    .filter(request -> Objects.isNull(request.getCarServiceRequestId()))
                    .forEach(session::persist);
            session.getTransaction().commit();
        }
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity entity) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
            return entity;
        }
    }
}

