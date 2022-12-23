package question5;

import question5.cli_App.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        Float prix1 = Float.valueOf(o1.getPrice());
        Float prix2 = Float.valueOf(o2.getPrice());
        return prix2.compareTo(prix1);
    }
}
