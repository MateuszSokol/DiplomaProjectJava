package user_login;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class LogInTest {

    @Test
    void testAuthenticateSuccess() throws Exception {
        File tempFile = File.createTempFile("login", ".txt");

        String user = "Mateusz";
        String pass = "secret";
        String hashed = PasswordUtils.hashPassword(pass);

        Files.writeString(tempFile.toPath(), user + "\n" + hashed);

        // symulacja wejścia użytkownika
        String simulatedInput = user + "\n" + pass + "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        boolean result = LogIn.authenticate(tempFile.getAbsolutePath());

        assertTrue(result);
    }

    @Test
    void testAuthenticateFail() throws Exception {
        File tempFile = File.createTempFile("login", ".txt");

        String user = "Mateusz";
        String pass = "secret";
        String hashed = PasswordUtils.hashPassword(pass);

        Files.writeString(tempFile.toPath(), user + "\n" + hashed);

        // błędne dane wejściowe
        String simulatedInput = "WrongUser\nWrongPass\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        boolean result = LogIn.authenticate(tempFile.getAbsolutePath());

        assertFalse(result);
    }

    @Test
    void testAuthenticateFileNotFound() {
        String fakePath = "C:/does/not/exist.txt";

        boolean result = LogIn.authenticate(fakePath);

        assertFalse(result);
    }
}
