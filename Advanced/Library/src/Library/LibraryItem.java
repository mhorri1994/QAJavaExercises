package Library;

import java.util.Date;

/**
 * Created by Matthew on 09/08/2017.
 */
public abstract class LibraryItem {
    private static int nextID = 0;
    private int id;
    private Date yearPublished;
    private Author author;
    private Publisher publisher;
    private String name;

    public static int getNextID() {
        return nextID;
    }

    public LibraryItem(Date yearPublished, Author author, Publisher publisher, String name) {
        this.id = nextID++;
        this.yearPublished = yearPublished;
        this.author = author;
        this.publisher = publisher;
        this.name = name;
    }

    public static void setNextID(int nextID) {
        LibraryItem.nextID = nextID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Date yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
//        return "LibraryItem{" +
//                "id=" + id +
//                ", yearPublished=" + yearPublished +
//                ", author=" + author +
//                ", publisher=" + publisher +
//                ", name='" + name + '\'' +
//                '}';
        return id+","+yearPublished+","+name+",("+author.toString()+"),{"+publisher.toString()+"}";
    }

    public void updateMe(LibraryItem newDetails){
        if(newDetails.getYearPublished() != null) this.yearPublished = newDetails.getYearPublished();
        if(newDetails.getAuthor() != null) this.author = newDetails.getAuthor();
        if(newDetails.getPublisher() != null) this.publisher = newDetails.getPublisher();
        if(newDetails.getName() != null && newDetails.getName() != "") this.name = newDetails.getName();
    }
}
