package vending_machine_solution;

import java.util.Hashtable;

public class Machine implements VendingMachineHardwareFunctions,
                                VendingMachine,
                                VendingMachineAdministration
{
    // constants for tracking change
    private static final Integer NICKEL_VALUE = 5;
    private static final Integer DIME_VALUE = 10;
    private static final Integer QUARTER_VALUE = 25;

    // map of vending machine positions to products
    private Hashtable<Integer, Product> machine;

    private Integer currentBalance;

    public Machine() {
        machine = new Hashtable<Integer, Product>();
        currentBalance = 0;
    }

    /**
     * User Function - This is called when a user presses a button for a
     * particular product. This is used for both price
     * checking and purchasing.
     **/
    public void buttonPress(Integer productPosition) {
        Product product = machine.get(productPosition);
        // the user gives an invalid position - we just display a default.
        if (product == null) {
            showMessage("Invalid product position entered. There is no product at this position.");
            return;
        }

        Integer quantity = product.getQuantity();

        if (quantity <= 0) {
            showMessage("We are out of " + product.getName() + ". We apologize for the inconvenience.");
        }

        Integer price = product.getPrice();
        
        // the user has insufficient funds - we just display the name and price
        if (currentBalance < price) {
            showMessage(product.toString());
        }
        // the user put in the exact amount of change needed
        else if (currentBalance == price) {
            dispenseProduct(productPosition, product.getName());
            updateBalanceAndInventory(product, quantity - 1);
        }
        // the user put in more money than needed
        else {
            dispenseProduct(productPosition, product.getName());
            dispenseChange(currentBalance - price);
            updateBalanceAndInventory(product, quantity - 1);
        }
    }

    private void updateBalanceAndInventory(Product product, Integer newQuantity) {
        product.setQuantity(newQuantity);
        currentBalance = 0;
    }
    

    /**
     * User Function - This is called when the user adds money to the
     * machine. The cents parameter represent the value
     * of the particular currency added to the machine. For example,
     * when the user adds a Nickel, this function will be
     * called with a value of 5.
     * 
     * Note: Only one coin will be added at a time. Only Nickels, Dimes,
     * and Quarters will be added.
     **/
    public void addUserMoney(Integer cents) {
        // if an invalid amount is added, return the user's change to them
        if (!validateMoney(cents)) {
            showMessage("Invalid denomination added, this machine only accept Nickels, Dimes, and Quarters." +
                         " We appreciate your consideration. We are returning your funds to you now.");
            dispenseChange(cents);
            return;
        }
        
        currentBalance += cents;
    }

    /**
     * This method is called when an administrator 
     * wishes to register a new product in the vending machine.
     * The potential position of this new product must be unoccupied,
     *  or an IllegalArgumentException will be thrown.
     **/
    public void addNewProduct(Integer position, String name, Integer price) {
        if (machine.containsKey(position)) {
            throw new IllegalArgumentException("This position " + position + " is already occupied with product!");
        }

        Product product = new Product(name, price, 0);
        machine.put(position, product);
    }

    /**
     * Admin function - This method is called when an administrator
     * wishes to add more inventory to the vending machine. 
     * If no product exists at this position, an IllegalArgumentException will be thrown.
     */
    public void addMoreInventory(Integer position, Integer quantity) {
        Product product = machine.get(position);
        if (position == null) {
            throw new IllegalArgumentException("Attempting to add inventory to a product that does not exist at position " +
                                               position);
            
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Please add a non zero amount of inventory");
        }

        Integer newQuantity = product.getQuantity() + quantity;
        product.setQuantity(newQuantity);

    }


    // explicitly validate Nickels, Quarters, and Dimes only
    private boolean validateMoney(Integer inputMoney) {
        return inputMoney != null && (inputMoney == NICKEL_VALUE ||
                                      inputMoney == DIME_VALUE ||
                                      inputMoney == QUARTER_VALUE);
    }

    
    public static void main(String[] args) {
        System.out.println("Compilation of vending machine successful");
    }


}
