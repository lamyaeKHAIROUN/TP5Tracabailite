import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
public class ProductAlreadyExisteException extends Exception {
    private static Logger LOGGER = Logger.getLogger(ProductAlreadyExisteException.class.getName());

    private FileHandler fileHandler;

    private IOException e1671629715636;

    public ProductAlreadyExisteException() {
        super();
        // TODO Auto-generated constructor stub
        try { fileHandler = new FileHandler("ProductAlreadyExisteException.log",true); LOGGER.addHandler(fileHandler); } catch (SecurityException e) { LOGGER.severe("Impossible to open FileHandler"); }catch (IOException e) { LOGGER.severe("Impossible to open FileHandler"); };
    }

    public ProductAlreadyExisteException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
        try { fileHandler = new FileHandler("ProductAlreadyExisteException.log",true); LOGGER.addHandler(fileHandler); } catch (SecurityException e) { LOGGER.severe("Impossible to open FileHandler"); }catch (IOException e) { LOGGER.severe("Impossible to open FileHandler"); };
    }
}