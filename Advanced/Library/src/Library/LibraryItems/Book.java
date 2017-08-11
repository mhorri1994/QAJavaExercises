package Library.LibraryItems;

import Library.Author;
import Library.LibraryItem;
import Library.Publisher;

import java.util.Date;

/**
 * Created by Matthew on 09/08/2017.
 */
public class Book extends LibraryItem {
    public String ISBN;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book(Date yearPublished, Author author, Publisher publisher, String name, String ISBN) {
        super(yearPublished, author, publisher, name);
        this.ISBN = ISBN;
    }
}
