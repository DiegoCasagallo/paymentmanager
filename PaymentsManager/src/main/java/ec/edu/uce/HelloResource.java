package ec.edu.uce;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("/test-db")
    @Produces("text/plain")
    public String testDatabaseConnection() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PaymentManagerPU");
            EntityManager em = emf.createEntityManager();
            em.close();
            emf.close();
            return "Conexión exitosa con la base de datos!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error conectando con la base de datos: " + e.getMessage();
        }
    }
}
