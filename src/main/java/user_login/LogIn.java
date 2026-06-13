package user_login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogIn {


    private static final Logger logger = LogManager.getLogger(LogIn.class);
    private LogIn()
    {

    }

    public static boolean authenticate(String pathToFile) {

        File file = new File(pathToFile);

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
                return true;
            } else {
                logger.info("Invalid password or login");
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found");
        }
        return false;
    }
}