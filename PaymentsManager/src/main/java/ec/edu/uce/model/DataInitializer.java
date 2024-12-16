package ec.edu.uce.model;

import ec.edu.uce.repository.CustomerRepository;
import ec.edu.uce.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DataInitializer {

    @Inject
    private CustomerRepository customerRepository;

    @Inject
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        // Crear un cliente
        Customer customer = new Customer();
        customer.setName("Juan Pérez");
        customer.setEmail("juanperez@example.com");
        customerRepository.save(customer);

        // Crear productos
        Product product1 = new Product();
        product1.setName("Producto 1");
        product1.setPrice(10.0);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Producto 2");
        product2.setPrice(15.0);
        productRepository.save(product2);
    }
}
