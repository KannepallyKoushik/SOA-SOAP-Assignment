package nl.utwente.soa.inventoryApplication.commands;

import nl.utwente.soa.inventoryApplication.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class CalculateCommands {

    @Autowired private InventoryService inventoryService;

    @ShellMethod("Sell inventory")
    public String sell(
        int amount
    ) {
        inventoryService.subtractInventory(amount);
        return "Sold inventory";
    }

    @ShellMethod("Buy new inventory")
    public String purchase() {

        inventoryService.addInventory(50);

        return "Jeej new inventory";
    }

    @ShellMethod("Get Current inventory")
    public String current(){

        return "Current inventory: " +  inventoryService.getCurrentInventory();

    }


}
