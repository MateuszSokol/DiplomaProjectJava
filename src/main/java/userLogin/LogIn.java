package userLogin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogIn {

    public void authenticate() throws FileNotFoundException {

        File file = new File("users.txt");

        try (Scanner fileScanner = new Scanner(file);
             Scanner keyboard = new Scanner(System.in)) {

            String storedUser = fileScanner.nextLine();
            String storedHashedPass = fileScanner.nextLine();

            System.out.print("Login: ");
            String inputUser = keyboard.nextLine();

            System.out.print("Password: ");
            String inputPass = keyboard.nextLine();

            String inputHashedPass = PasswordUtils.hashPassword(inputPass);

            if (inputUser.equals(storedUser) &&
                    inputHashedPass.equals(storedHashedPass)) {

                System.out.println("Password and login match");
            } else {
                System.out.println("Invalid password or login");
            }
        }
    }
}