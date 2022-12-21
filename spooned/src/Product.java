import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
public class Product {
    private static Logger LOGGER = Logger.getLogger(Product.class.getName());

    private FileHandler fileHandler;

    private IOException e1671629715636;

    private String ID;

    private String name;

    private String price;

    private String expirationDate;

    public Product(String iD, String name, String price, String expirationString) {
        ID = iD;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationString;
        try { fileHandler = new FileHandler("Product.log",true); LOGGER.addHandler(fileHandler); } catch (SecurityException e) { LOGGER.severe("Impossible to open FileHandler"); }catch (IOException e) { LOGGER.severe("Impossible to open FileHandler"); };
    }

    public Product() {
        try { fileHandler = new FileHandler("Product.log",true); LOGGER.addHandler(fileHandler); } catch (SecurityException e) { LOGGER.severe("Impossible to open FileHandler"); }catch (IOException e) { LOGGER.severe("Impossible to open FileHandler"); };
    }

    public String getID() {
        LOGGER.info(Main.getUser().toString()+ ";" +"Pas de parametres donnés");
        return ID;
    }

    public void setID(String iD) {
        LOGGER.info(Main.getUser().toString()+ ";" +iD.toString());
        ID = iD;
    }

    public String getName() {
        LOGGER.info(Main.getUser().toString()+ ";" +"Pas de parametres donnés");
        return name;
    }

    public void setName(String name) {
        LOGGER.info(Main.getUser().toString()+ ";" +name.toString());
        this.name = name;
    }

    public String getPrice() {
        LOGGER.info(Main.getUser().toString()+ ";" +"Pas de parametres donnés");
        return price;
    }

    public void setPrice(String price) {
        LOGGER.info(Main.getUser().toString()+ ";" +price.toString());
        this.price = price;
    }

    public String getExpirationString() {
        LOGGER.info(Main.getUser().toString()+ ";" +"Pas de parametres donnés");
        return expirationDate;
    }

    public void setExpirationString(String expirationString) {
        LOGGER.info(Main.getUser().toString()+ ";" +expirationString.toString());
        this.expirationDate = expirationString;
    }

    @Override
    public String toString() {
        LOGGER.info("Pas de parametres donnés");
        return (((((("Produit: ID=" + ID) + ", Nom=") + name) + ", Prix=") + price) + ", Date d'expiration=") + expirationDate;
    }
}