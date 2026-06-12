package library;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library
{
    private List<Book> books = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger("log4jdemo.library.Library");
    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            logger.info(book);
        }
    }

    public boolean removeBook(String isbn) {
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }


    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayLibraryStorage()
    {
        for (Book book:books)
        {

            logger.info(book.toString());
        }
    }


}
