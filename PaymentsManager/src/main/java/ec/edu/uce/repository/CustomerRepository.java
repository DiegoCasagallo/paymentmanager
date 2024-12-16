package ec.edu.uce.repository;

import ec.edu.uce.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@ApplicationScoped
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    public void update(Customer customer) {
        entityManager.merge(customer);
    }
}
