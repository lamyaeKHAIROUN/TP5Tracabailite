import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
public class ProductNotFoundException extends Exception {
    private static Logger LOGGER = Logger.getLogger(ProductNotFoundException.class.getName());

    private FileHandler fileHandler;

    private IOException e1671709804809;

    public ProductNotFoundException() {
        super();
        // TODO Auto-generated constructor stub
        try { fileHandler = new FileHandler("ProductNotFoundException.log",true); LOGGER.addHandler(fileHandler); } catch (SecurityException e) { LOGGER.severe("Impossible to open FileHandler"); }catch (IOException e) { LOGGER.severe("Impossible to open FileHandler"); };
    }

    public ProductNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
        try { fileHandler = new FileHandler("ProductNotFoundException.log",true); LOGGER.addHandler(fileHandler); } catch (SecurityException e) { LOGGER.severe("Impossible to open FileHandler"); }catch (IOException e) { LOGGER.severe("Impossible to open FileHandler"); };
    }
}