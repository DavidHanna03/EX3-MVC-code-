import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class CashRegisterModel {
    private PropertyChangeSupport observables;
    private ArrayList<Product> myProducts;

    CashRegisterModel(ArrayList<Product> products){
        myProducts = products;
        observables = new PropertyChangeSupport( this );
    }
    public void addPropertyChangeListener(PropertyChangeListener pcl){
        observables.addPropertyChangeListener(pcl);
    }
    public void processUPC(int code){
        // Uses UPC code to find the product.
        Product product = getProduct(code);
        if (product != null){
            //Notify observers that a new product has been added
            observables.firePropertyChange("Product Added", null, product);
        } else {
            // This handels the case where a product is not found
            System.out.println("Product with UPC" + code + "Not found");
        }
    }

    private Product getProduct(int code){
        for (Product p : myProducts){
            if(p.getUPC()==code){
                return p;
            }
        }
        return null; // Returns null if the product is not found
    }

    public ArrayList<Product> getProductList(){
        return this.myProducts;
    }



    

}