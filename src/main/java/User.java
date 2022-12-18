import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class User {

	private String ID;
	private String name;
	private String age;
	private String email;
	private String password;
	private static Logger LOGGER = Logger.getLogger(User.class.getName());



	public User() {
		super();
		Handler fh;
		try {
			fh = new FileHandler("User.log");
			LOGGER.addHandler(fh);
		} catch (SecurityException e) {
			LOGGER.severe("Impossible to open FileHandler");
		} catch (IOException e) {
			LOGGER.severe("Impossible to open FileHandler");
		}
	}

	public User(String iD, String name, String age, String email, String password) {
		super();
		ID = iD;
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		Handler fh;
		try {
			fh = new FileHandler("User.log");
			LOGGER.addHandler(fh);
		} catch (SecurityException e) {
			LOGGER.severe("Impossible to open FileHandler");
		} catch (IOException e) {
			LOGGER.severe("Impossible to open FileHandler");
		}
	}







	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User information: ID=" + ID + ", Name=" + name + ", Age=" + age + ", Email=" + email + ", Password=" + password;

	}

}
