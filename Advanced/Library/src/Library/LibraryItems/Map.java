package Library.LibraryItems;

import Library.Author;
import Library.LibraryItem;
import Library.Publisher;

import java.util.Date;

/**
 * Created by Matthew on 09/08/2017.
 */
public class Map extends LibraryItem {
    private String isAMapOf;

    public String getIsAMapOf() {
        return isAMapOf;
    }

    public void setIsAMapOf(String isAMapOf) {
        this.isAMapOf = isAMapOf;
    }

    public Map(Date yearPublished, Author author, Publisher publisher, String name, String isAMapOf) {
        super(yearPublished, author, publisher, name);
        this.isAMapOf = isAMapOf;
    }

    @Override
    public void updateMe(LibraryItem newDetails) {
        super.updateMe(newDetails);
        if(newDetails instanceof Map) this.isAMapOf = ((Map) newDetails).isAMapOf;
    }
}
