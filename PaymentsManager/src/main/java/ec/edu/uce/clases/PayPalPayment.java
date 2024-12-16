package ec.edu.uce.clases;

import ec.edu.uce.model.Payment;

import java.util.Date;

public class PayPalPayment implements PaymentMethod {

    @Override
    public Payment processPayment(Payment payment) {

        payment.setStatus("approved");
        payment.setPaymentDate(new Date());
        return payment;
    }
}
