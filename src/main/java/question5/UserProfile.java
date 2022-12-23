package question5;

import question5.cli_App.User;

import java.util.LinkedList;
import java.util.List;

public class UserProfile {


    private User user;
    private List<String> operationsReadByUser;
    private List<String> operationsWritenByUsers;

    public UserProfile(User user) {
        super();
        this.user = user;
        operationsReadByUser = new LinkedList<String>();
        operationsWritenByUsers = new LinkedList<String>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getOperationsReadByUser() {
        return operationsReadByUser;
    }

    public void setOperationsReadByUser(List<String> operationsReadByUser) {
        this.operationsReadByUser = operationsReadByUser;
    }

    public List<String> getOperationsWritenByUsers() {
        return operationsWritenByUsers;
    }

    public void setOperationsWritenByUsers(List<String> operationsWritenByUsers) {
        this.operationsWritenByUsers = operationsWritenByUsers;
    }




}
