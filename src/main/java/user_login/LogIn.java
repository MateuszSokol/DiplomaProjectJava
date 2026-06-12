package user_login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogIn {

    private static final Logger logger = LogManager.getLogger("user_login.LogIn");
    public void authenticate() throws FileNotFoundException {

        File file = new File("users.txt");

        try (Scanner fileScanner = new Scanner(file);
             Scanner keyboard = new Scanner(System.in)) {

            String storedUser = fileScanner.nextLine();
            String storedHashedPass = fileScanner.nextLine();

            logger.info("Login: ");
            String inputUser = keyboard.nextLine();

            logger.info("Password: ");
            String inputPass = keyboard.nextLine();

            String inputHashedPass = PasswordUtils.hashPassword(inputPass);

            if (inputUser.equals(storedUser) &&
                    inputHashedPass.equals(storedHashedPass)) {

                logger.info("Password and login match");
            } else {
                logger.info("Invalid password or login");
            }
        }
    }
}