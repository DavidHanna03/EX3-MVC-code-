import java.util.ArrayList;



public class CashRegisterMVCApp {
    
    public static void main(String[] args) {
        // Create a list of products 
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1001, "Bread", 3.99));
        products.add(new Product(1002, "Water", 4.99));
        products.add(new Product(1003, "Cheese", 2.99));
        products.add(new Product(1004, "Ketchup", 5.99));
        
        // Assembling all the pieces of the cash register MVC
        CashRegisterModel cashRegister = new CashRegisterModel(products);
        Display display = new Display();
        cashRegister.addPropertyChangeListener(display);
        Keyboard c = new Keyboard("keyboard", cashRegister);

        // Process a UPC code (for example, 1001)
        int upcCode = 1001;
        cashRegister.processUPC(upcCode);

        // A list of the products available 
        ArrayList<Product> productList = cashRegister.getProductList();
    }
}

