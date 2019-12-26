package vending_machine_solution;

/**
* Adminsitrative utilities for managing inventory in
* the vending machine.
**/
interface VendingMachineAdministration {

    /**
     * This method is called when an administrator 
     * wishes to add a new product to the vending machine.
     * The position must be unoccupied, or an IllegalArgumentException will be thrown.
     **/
    void addNewProduct(Integer position, String name, Integer price);


    
    /**
     * Admin function - This method is called when an administrator
     * wishes to add more inventory to the vending machine. 
     * If no product exists at this position, an IllegalArgumentException will be thrown.
     */
    void addMoreInventory(Integer position, Integer quantity);
    
}
