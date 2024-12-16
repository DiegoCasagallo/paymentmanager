package ec.edu.uce.repository;

import ec.edu.uce.model.Product;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

@RequestScoped
public class ProductRepository {

    @Inject
    private EntityManagerFactory entityManagerFactory; // Inyectamos el EntityManagerFactory

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Guardar un producto
    public void save(Product product) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    // Actualizar un producto
    public void update(Product product) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    // Buscar un producto por su ID
    public Product findById(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            return entityManager.find(Product.class, id);
        } finally {
            entityManager.close();
        }
    }

    // Obtener todos los productos
    public List<Product> findAll() {
        EntityManager entityManager = getEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    // Eliminar un producto
    public void delete(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        try {
            Product product = findById(id);
            if (product != null) {
                entityManager.remove(product);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }
}
