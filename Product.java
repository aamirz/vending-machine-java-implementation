package carrier_direct_assessment;

public class Product {

    /**
     * This class represents a product in our vending machine.
     **/
    
    // name of the prouct
    private String name; 

    // price of the product
    private Integer price;


    public Product(String name, Integer price) {
        this.name = name;
        
        if (isValidPrice(price)) {
            this.price = price;
        }
    }

    public Integer GetPrice() {
        return price;
    }

    public void SetPrice(Integer price) {
        if (isValidPrice(price)) {
            this.price = price;
        }
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        /**
         * testing for Product object
         **/
        Product doritos = new Product("Doritos", 120);

        System.out.println("lol mom");

        // the following tests should throw an exception
        try {
            Product fritos = new Product("Fritos", -5);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
    }


    private boolean isValidPrice(Integer price) {
        // the price must be a multiple of 5 since we only
        // accept quarters, nickels, or dimes
        // the price must be positive or zero since it wouldn't make sense
        // for the vending machine to owe someone money for purchasing a
        // bag of doritos
        if (price % 5 != 0 || price <= 0) {
            throw new IllegalArgumentException("Invalid price entered for product " + name);
        }

        // we could also leave it to the caller to throw an exception, but that
        // would result in some repeated code

        return true;
    }
}
