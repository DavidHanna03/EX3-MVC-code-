// The following is an example of a view. In this example we will simply print the product name and price 
// we use the PropertyChangeListener to get notifications from the cash register

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Display implements PropertyChangeListener {
    private Product product;

    public Display() {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("ProductAdded".equals(evt.getPropertyName())) {
            Product addedProduct = (Product) evt.getNewValue();
            this.product = addedProduct;
            // Prints to the console
            System.out.println("Product name: " + product.getName() + " Price = " + product.getPrice());
        }
    }
}
