package Library.LibraryItems;

import Library.Author;
import Library.LibraryItem;
import Library.Publisher;

import java.util.Date;

/**
 * Created by Matthew on 09/08/2017.
 */
public class Newspaper extends LibraryItem {
    private Date publicationDate;

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public void updateMe(LibraryItem newDetails) {
        super.updateMe(newDetails);
        if(newDetails instanceof Newspaper) this.publicationDate = ((Newspaper) newDetails).getPublicationDate();
    }

    public Newspaper(Date yearPublished, Author author, Publisher publisher, String name, Date publicationDate) {
        super(yearPublished, author, publisher, name);
        this.publicationDate = publicationDate;
    }
}
