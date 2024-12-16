package ec.edu.uce.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

    @Produces
    public EntityManagerFactory createEntityManagerFactory() {

        return Persistence.createEntityManagerFactory("PaymentManagerPU");
    }
}
