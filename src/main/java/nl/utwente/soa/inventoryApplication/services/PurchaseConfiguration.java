package nl.utwente.soa.inventoryApplication.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PurchaseConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("nl.utwente.soa.purchaseClient");
        return marshaller;
    }

    @Bean
    public PurchaseClient purchaseClient(Jaxb2Marshaller marshaller) {
        PurchaseClient client = new PurchaseClient();
        client.setDefaultUri("http://localhost:8080/ws.PurchaseOrder/services/");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
