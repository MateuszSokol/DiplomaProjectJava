package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        Book book = new Book("LOTR", "Tolkien", "123");

        library.addBook(book);

        assertEquals(1, library.getBooks().size());
        assertEquals("LOTR", library.getBooks().get(0).getBookTitle());
    }

    @Test
    void testRemoveBookSuccess() {
        Book book = new Book("LOTR", "Tolkien", "123");
        library.addBook(book);

        boolean removed = library.removeBook("123");

        assertTrue(removed);
        assertEquals(0, library.getBooks().size());
    }

    @Test
    void testRemoveBookFail() {
        Book book = new Book("LOTR", "Tolkien", "123");
        library.addBook(book);

        boolean removed = library.removeBook("999");

        assertFalse(removed);
        assertEquals(1, library.getBooks().size());
    }

    @Test
    void testFindByTitleSuccess() {
        Book book = new Book("LOTR", "Tolkien", "123");
        library.addBook(book);

        Book found = library.findByTitle("LOTR");

        assertNotNull(found);
        assertEquals("123", found.getIsbn());
    }

    @Test
    void testFindByTitleIgnoreCase() {
        Book book = new Book("LOTR", "Tolkien", "123");
        library.addBook(book);

        Book found = library.findByTitle("lotr");

        assertNotNull(found);
        assertEquals("123", found.getIsbn());
    }

    @Test
    void testFindByTitleNotFound() {
        Book book = new Book("LOTR", "Tolkien", "123");
        library.addBook(book);

        Book found = library.findByTitle("Hobbit");

        assertNull(found);
    }
}
