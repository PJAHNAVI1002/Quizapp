package utils;

import org.mindrot.jbcrypt.BCrypt;

public class Passwordchecker {
	public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
	
	public static String checkPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }



}
