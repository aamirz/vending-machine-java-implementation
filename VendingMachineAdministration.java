package carrier_direct_assessment;

/**
* You MUST implement this interface.
*/
interface VendingMachineAdministration {
    /**
     * Admin function - This method is called when an administrator
     * wishes to add more inventory to the vending machine. 
     *
     */
    void addMoreProduct(Integer productPosition, Integer productQuantity);

}
