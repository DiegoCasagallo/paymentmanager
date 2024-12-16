package ec.edu.uce.clases;

import ec.edu.uce.model.Payment;

public interface PaymentMethod {
    Payment processPayment(Payment payment);
}
