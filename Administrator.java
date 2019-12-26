package vending_machine_solution;

public class Administrator {

    /**
     * This class can build and manage new vending machines.
     * Primarily used for testing.
     **/
    public Administrator() {

    }


    public Machine makeEmptyMachine() {
        return new Machine();
    }

    public Machine makeOneProductEmptyMachine() {
        Machine machine = new Machine();
        machine.addNewProduct(0, "Doritos", 100);
        return machine;
    }

    public Machine makeOneProductFullMachine() {
        Machine machine = makeOneProductEmptyMachine();
        machine.addMoreInventory(0, 1);
        return machine;
    }

    public Machine makeMultiProductEmptyMachine() {
        Machine machine = new Machine();
        machine.addNewProduct(0, "Doritos", 100);
        machine.addNewProduct(1, "Fritos", 50);
        machine.addNewProduct(2, "Pepsi", 5);
        return machine;
    }

    public Machine makeMultiProductFullMachine() {
        Machine machine = makeMultiProductEmptyMachine();
        for (int i = 0; i < 3; i++) {
            machine.addMoreInventory(i, 1);
        }
        return machine;
    }

    



}
