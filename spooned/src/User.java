import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
public class User {
    private static Logger LOGGER = Logger.getLogger(User.class.getName());

    private FileHandler fileHandler;

    private IOException e1671629715639;

    private String ID;

    private String name;

    private String age;

    private String email;

    private String password;

    public User() {
        super();
        try { fileHandler = new FileHandler("User.log",true); LOGGER.addHandler(fileHandler); } catch (SecurityException e) { LOGGER.severe("Impossible to open FileHandler"); }catch (IOException e) { LOGGER.severe("Impossible to open FileHandler"); };
    }

    public User(String iD, String name, String age, String email, String password) {
        super();
        ID = iD;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        try { fileHandler = new FileHandler("User.log",true); LOGGER.addHandler(fileHandler); } catch (SecurityException e) { LOGGER.severe("Impossible to open FileHandler"); }catch (IOException e) { LOGGER.severe("Impossible to open FileHandler"); };
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

    public String getAge() {
        LOGGER.info(Main.getUser().toString()+ ";" +"Pas de parametres donnés");
        return age;
    }

    public void setAge(String age) {
        LOGGER.info(Main.getUser().toString()+ ";" +age.toString());
        this.age = age;
    }

    public String getEmail() {
        LOGGER.info(Main.getUser().toString()+ ";" +"Pas de parametres donnés");
        return email;
    }

    public void setEmail(String email) {
        LOGGER.info(Main.getUser().toString()+ ";" +email.toString());
        this.email = email;
    }

    public String getPassword() {
        LOGGER.info(Main.getUser().toString()+ ";" +"Pas de parametres donnés");
        return password;
    }

    public void setPassword(String password) {
        LOGGER.info(Main.getUser().toString()+ ";" +password.toString());
        this.password = password;
    }

    @Override
    public String toString() {
        LOGGER.info("Pas de parametres donnés");
        return (((((((("User information: ID=" + ID) + ", Name=") + name) + ", Age=") + age) + ", Email=") + email) + ", Password=") + password;
    }
}