package nl.utwente.soa.inventoryApplication.services;

import nl.utwente.soa.purchaseClient.CustomerInfo;
import nl.utwente.soa.purchaseClient.Invoice;
import nl.utwente.soa.purchaseClient.PORequest;
import nl.utwente.soa.purchaseClient.PurchaseOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigInteger;

public class PurchaseClient extends WebServiceGatewaySupport {
    public Invoice PurchaseItems(){
//        Hardcoding dummy values for CustomerInfo
        CustomerInfo customer = new CustomerInfo();
        customer.setCusName("Koushik");
        customer.setCusAddress("NL");
//        Hardcoding dummy values for PurchaseOrder
        PurchaseOrder order = new PurchaseOrder();
        order.setPODate("19-03-2022");
        order.setPONumber(new BigInteger("123"));

//        preparing Puchase Order request
        PORequest request = new PORequest();
        request.setCustomer(customer);
        request.setType(order);

        Invoice response = (Invoice) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws.PurchaseOrder/services/PurchaseOrderService",request,
                new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
        return response;
    }
}