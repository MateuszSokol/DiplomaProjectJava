package library;

public class Book
{
    private String bookTitle;
    private String author;
    private String isbn;

    public Book(String bookTitle,String author,String ISBN)
    {
        this.bookTitle = bookTitle;
        this.author = author;
        this.isbn = ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + isbn + '\'' +
                '}';
    }
}
