package library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library
{
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public boolean removeBook(String isbn) {
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getISBN().equals(isbn)) {
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
            System.out.println(book.toString());
        }
    }


}
