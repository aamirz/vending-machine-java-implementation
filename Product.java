package vending_machine_solution;

public class Product {

    /**
     * This class represents inventory of a product in our vending machine.
     **/
    
    // name of the prouct
    private String name; 

    // price of the product
    private Integer price;

    // amount of inventory on hand
    private Integer quantity;

    /**
     * instantiate a new product with a name that cannot be changed 
     * and 
     **/
    public Product(String name, Integer price, Integer quantity) {
        this.name = name;
        
        if (isValidPrice(price)) {
            this.price = price;
        }

        if (isValidQuantity(quantity)) {
            this.quantity = quantity;
        }
    }


    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (isValidPrice(price)) {
            this.price = price;
        }
    }

    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        if (isValidQuantity(quantity)) {
            this.quantity = quantity;
        }
    }

    public String toString() {
        return name + " costs " + price + " cents.";
    }
    
    private boolean isValidPrice(Integer price) {
        // the price must be a multiple of 5 since we only
        // accept quarters, nickels, or dimes
        // the price must be positive or zero since it wouldn't make sense
        // for the vending machine to owe someone money for purchasing a
        // bag of doritos
        if (price == null || price % 5 != 0 || price < 0) {
            throw new IllegalArgumentException("Invalid price entered for product " + name + ": " + price);
        }

        // we could also leave it to the caller to throw an exception, but that
        // would result in some repeated code

        return true;
    }

    private boolean isValidQuantity(Integer quantity) {
        if (quantity == null || quantity < 0) {
            throw new IllegalArgumentException("Invalid quantity entered for product " + name + ": " + quantity);
        }
        
        // the quantity must be non-negative
        return true;
    }


    public static void main(String[] args) {
        /**
         * testing for Product object
         **/
        Product doritos = new Product("Doritos", 120, 0);
        System.out.println(doritos);


        // the following test should throw an exception
        // due to the price
        try {
            Product fritos = new Product("Fritos", -5, 0);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // the following test shoudl throw an exception
        // due to the quantity
        try {
            Product pepsi = new Product("Pepsi", 0, -5);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
    }


    
}
