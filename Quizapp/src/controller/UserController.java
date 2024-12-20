package controller;

import database.Userdata;
import model.User;
import utils.Passwordchecker;

public class UserController {
	
	private Userdata userDAO;

    public UserController() {
        this.userDAO = new Userdata();
    }
    public boolean registerUser(String username, String password, String role) {
        String hashedPassword = Passwordchecker.hashPassword(password);
        User user = new User(0, username, hashedPassword, role);
        return userDAO.addUser(user);
    }

    public boolean authenticateUser(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null) {
            return Passwordchecker.checkPassword(password, user.getPassword());
        }
        return false;
    }

}
