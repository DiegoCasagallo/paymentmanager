package ec.edu.uce.controller;

import ec.edu.uce.model.Customer;
import ec.edu.uce.model.Payment;
import ec.edu.uce.service.PaymentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


@Path("/payments")
public class PaymentController {

    @Inject
    private PaymentService paymentService;

    @POST
    @Path("/process")
    @Consumes("application/json")
    @Produces("application/json")
    public Response processPayment(Customer customer, @QueryParam("amount") double amount) {
        try {
            Payment payment = paymentService.processPayment(customer, amount);
            return Response.status(Response.Status.OK).entity(payment).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
