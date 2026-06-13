package user_login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    private static final Logger logger = LogManager.getLogger(PasswordUtils.class);
    private static PasswordUtils instance;
    private PasswordUtils()
    {


    }
    public static PasswordUtils getInstance()
    {
        if(instance == null) {
            instance = new PasswordUtils();
        }

        return instance;
    }



    public static String hashPassword(String password) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());


            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            logger.error("Error during password encryption");
        }
        return sb.toString();
    }
}