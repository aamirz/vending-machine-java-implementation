package vending_machine_solution;

import java.util.Random;

public class Testing {

    // this is somewhat reapted code (see Machine.java)
    // ideally these would be passed in as parameters
    // or live in a separate class
    private static final Integer NICKEL = 5;
    private static final Integer DIME = 10;
    private static final Integer QUARTER = 25;
    private static final Integer DUMMY_COIN_A = 35;
    private static final Integer DUMMY_COIN_B = 47;

    // product names
    private static final String DORITOES = "Doritoes";
    private static final String FRITOS = "Fritos";
    private static final String PEPSI = "Pepsi";
    
    private Administrator admin;
    private Random random;
    
    public Testing() {
        admin = new Administrator();
        random = new Random();
    }

    public void testEmptyMachine() {
        Machine machine = admin.makeEmptyMachine();
        machine.buttonPress(0); // should display error message
        
        machine.addUserMoney(DUMMY_COIN_A); // should display another error

        machine.addUserMoney(DUMMY_COIN_B); // should display same error ^

        // we should be able to add inventory and order it
        machine.addNewProduct(0, "Doritos", 0);

        // since these doritos cost 0 cents, the machine will try to dispense, but there
        // is no inventory present
        machine.buttonPress(0); // display inventory error message

        // adding money won't help the situation
        machine.addUserMoney(QUARTER);
        machine.buttonPress(0);

        // we want our money back
        machine.returnUserMoney();

        // we finally add some inventory and are able to order it
        machine.addMoreInventory(0, 1);
        machine.buttonPress(0);

        // we should not be able to order again
        machine.buttonPress(0);
    }

    public void testSingleProductMachine() {
        Machine machine = admin.makeOneProductFullMachine();
        // emulate a hungry patron
        machine.buttonPress(0);
        for (int i = 0; i < 4; i++) {
            machine.addUserMoney(QUARTER);
            machine.buttonPress(0);
        }

        // we are out of inventory
        machine.buttonPress(0);

        // patron starts pressing random, invalid buttons in frustration
        for (int i = 0; i < 5; i++) {
            machine.buttonPress(random.nextInt());
        }
 
    }

    public void testMultiProductMachine() {
        Machine machine = admin.makeMultiProductFullMachine();
        // we want some pepsi
        machine.buttonPress(2);
        machine.addUserMoney(NICKEL);
        machine.buttonPress(2);

        // we are rich and we want some pepsi
        machine.addUserMoney(QUARTER);
        machine.buttonPress(2); // oh no, no more pepsi
        // we want our money back
        machine.returnUserMoney();
        
        // luckily the admin comes by with plenty of pepsi
        machine.addMoreInventory(2, 100);

        machine.addUserMoney(QUARTER);
        machine.buttonPress(2); // we should get 20 cents back
        
        // we should be able to order Fritos as well
        machine.buttonPress(1);

        // we order politely this time, adding more money than we need
        for (int i = 0; i < 10; i++) {
            machine.addUserMoney(DIME);
        }
        machine.buttonPress(1); // should return 50 cents
        
    }


    public static void main(String[] args) {
        System.out.println("Testing vending machine...");
        Testing testing = new Testing();
        // testing.testEmptyMachine();
        // testing.testSingleProductMachine();
        testing.testMultiProductMachine();
    }

}
