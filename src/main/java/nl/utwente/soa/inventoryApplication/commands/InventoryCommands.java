package nl.utwente.soa.inventoryApplication.commands;

import nl.utwente.soa.inventoryApplication.services.InventoryService;
import nl.utwente.soa.inventoryApplication.services.PurchaseClient;
import nl.utwente.soa.inventoryApplication.services.PurchaseConfiguration;
import nl.utwente.soa.purchaseClient.Invoice;
import nl.utwente.soa.purchaseClient.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class InventoryCommands {

	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private PurchaseClient client;

	@ShellMethod("Sell inventory")
	public String sell(int amount) {
		inventoryService.subtractInventory(amount);
		return "Sold inventory";
	}

	@ShellMethod("Buy new inventory")
	public String purchase(int amount) {

		// Request to the Purchase service should be done here!!!
		Invoice invoice = client.PurchaseItems();
		System.out.println(invoice.getInvDate());
		inventoryService.addInventory(amount);
		return "More " + amount + " items in the inventory";
	}

	@ShellMethod("Get Current inventory")
	public String current() {
		return "Current inventory: " + inventoryService.getCurrentInventory();

	}
}
