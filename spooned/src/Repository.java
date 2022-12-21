import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
public class Repository {
    private static Logger LOGGER = Logger.getLogger(Repository.class.getName());

    private FileHandler fileHandler;

    private IOException e1671629715638;

    private String ID;

    private List<Product> products;

    public Repository() {
        this.products = new ArrayList<>();
        initRepositoryWithData();
        try { fileHandler = new FileHandler("Repository.log",true); LOGGER.addHandler(fileHandler); } catch (SecurityException e) { LOGGER.severe("Impossible to open FileHandler"); }catch (IOException e) { LOGGER.severe("Impossible to open FileHandler"); };
    }

    public Repository(String iD, List<Product> products) {
        ID = iD;
        this.products = products;
        try { fileHandler = new FileHandler("Repository.log",true); LOGGER.addHandler(fileHandler); } catch (SecurityException e) { LOGGER.severe("Impossible to open FileHandler"); }catch (IOException e) { LOGGER.severe("Impossible to open FileHandler"); };
    }

    public String getID() {
        LOGGER.info(Main.getUser().toString()+ ";" +"Pas de parametres donnés");
        return ID;
    }

    public void setID(String iD) {
        LOGGER.info(Main.getUser().toString()+ ";" +iD.toString());
        ID = iD;
    }

    public List<Product> getProducts() {
        LOGGER.info(Main.getUser().toString()+ ";" +"Pas de parametres donnés");
        return products;
    }

    public void setProducts(List<Product> products) {
        LOGGER.info(Main.getUser().toString()+ ";" +products.toString());
        this.products = products;
    }

    public Product fetchProductById(String ID) throws ProductNotFoundException {
        LOGGER.info(Main.getUser().toString()+ ";" +ID.toString());
        for (Product product : products) {
            if (product.getID().equals(ID)) {
                return product;
            }
        }
        throw new ProductNotFoundException("Il y a aucun produit avec cet ID.");
    }

    public Product addNewProduct(Product product) throws ProductAlreadyExisteException {
        LOGGER.info(Main.getUser().toString()+ ";" +product.toString());
        try {
            this.fetchProductById(product.getID());
            throw new ProductAlreadyExisteException("Un produit avec le meme ID deja existant.");
        } catch (ProductNotFoundException e) {
            products.add(product);
            return product;
        }
    }

    public Product deleteProduct(String ID) throws ProductNotFoundException {
        LOGGER.info(Main.getUser().toString()+ ";" +ID.toString());
        Product product = this.fetchProductById(ID);
        products.remove(product);
        return product;
    }

    public Product updateProduct(Product product) throws ProductAlreadyExisteException, ProductNotFoundException {
        LOGGER.info(Main.getUser().toString()+ ";" +product.toString());
        this.deleteProduct(product.getID());
        this.addNewProduct(product);
        return product;
    }

    public void diplayProducts() {
        LOGGER.info(Main.getUser().toString()+ ";" +"Pas de parametres donnés");
        StringBuilder sb = new StringBuilder();
        sb.append("Affichage de tous les produits :");
        sb.append('\n');
        for (Product product : products) {
            sb.append(product);
            sb.append('\n');
        }
        sb.append("*********************************");
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        LOGGER.info("Pas de parametres donnés");
        return (("Repository : ID=" + ID) + ", Produits=") + products;
    }

    private void initRepositoryWithData() {
        LOGGER.info(Main.getUser().toString()+ ";" +"Pas de parametres donnés");
        Product p1 = new Product("0", "Lait", "1.0", "25/12/22");
        Product p2 = new Product("1", "Oeufs", "5.0", "10/01/23");
        Product p3 = new Product("2", "Crevette", "8.0", "22/02/23");
        Product p4 = new Product("3", "Fromage", "3.0", "20/01/23");
        Product p5 = new Product("4", "Pain", "1.0", "28/12/22");
        try {
            this.addNewProduct(p1);
            this.addNewProduct(p2);
            this.addNewProduct(p3);
            this.addNewProduct(p4);
            this.addNewProduct(p5);
        } catch (ProductAlreadyExisteException e) {
            System.out.println(e.getMessage());
        }
    }
}