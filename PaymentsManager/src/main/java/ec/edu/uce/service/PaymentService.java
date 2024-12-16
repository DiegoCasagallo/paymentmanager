package ec.edu.uce.service;

import ec.edu.uce.model.Customer;
import ec.edu.uce.model.Payment;
import ec.edu.uce.repository.CustomerRepository;
import ec.edu.uce.repository.PaymentRepository;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class PaymentService {

    @Inject
    private CustomerRepository customerRepository;

    @Inject
    private PaymentRepository paymentRepository;

    @Inject
    private EntityManager entityManager;  //

    // Método para realizar un pago
    @Transactional  // CDI maneja la transacción automáticamente
    public Payment processPayment(Customer customer, double amount) {

        // Buscar al cliente en la base de datos
        Customer existingCustomer = customerRepository.findById(customer.getId());
        if (existingCustomer == null) {
            throw new IllegalArgumentException("Cliente no encontrado");
        }

        // Crear el pago
        Payment payment = new Payment();
        payment.setCustomer(existingCustomer);
        payment.setAmount(amount);
        payment.setStatus("PENDING");

        // Guardar el pago en la base de datos
        paymentRepository.save(payment);
        payment.setStatus("APPROVED");
        paymentRepository.update(payment);  // Actualizar el estado

        return payment;
    }
}
