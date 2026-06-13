package org.example.banking_account;

import data_operations.Student;
import library.Book;
import library.Library;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import save_read_data.MyFile;
import user_login.LogIn;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args)
    {
        //Executing student class methods
        Student myStudent = new Student("Mateusz","Male");
        //find student by its id
        myStudent.findStudent(Student.getStudents(),0);
        //find student by its gender
        myStudent.findStudentsByGender(Student.getStudents(),"Male");
        // sort students by name
        myStudent.sortedStudentByName(Student.getStudents());

        //Executing library methods
        //Creating book and library
        Book myBook = new Book("The Lord of the Rings","J. R. R. Tolkien","9780544003415");
        Library myLibrary = new Library();
        //add book to library
        myLibrary.addBook(myBook);
        //print book details
       logger.info(myBook.toString());
        //display library books
        myLibrary.displayLibraryStorage();
        //find book by its title
        myLibrary.findByTitle("The Lord of the Rings");
        //remove book from library
        myLibrary.removeBook("9780544003415");
        //Executing Banking account methods
        BankingAccount myBankingAccount = new BankingAccount("Mateusz Brokuł","PL00 1111 1111 2222 2222 2222 2222");
        myBankingAccount.deposit(100.0);
        myBankingAccount.displayInfo();
        myBankingAccount.withdraw(100.0);
        myBankingAccount.displayInfo();

        //Executing MyFile methods
        MyFile.readDataFromFile("PathToFile/someFile.txt");
        MyFile.saveDataToFile("PathToFile/someFile.txt");

        //Executing user login methods
        LogIn.authenticate("PathToFile/someFile.txt");

    }
}