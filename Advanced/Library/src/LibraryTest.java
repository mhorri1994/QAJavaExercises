import Library.*;
import Library.LibraryItems.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Matthew on 09/08/2017.
 */
public class LibraryTest {
    Address address = new Address("6 Rutland Avenue", "", "", "Colchester", "CO29BD", "Essex", "United Kingdom");
    Person p = new Person(address, "Matthew" );
    Address publisherAddress = new Address("77 Hazell Avenue", "", "", "Colchester", "CO29DP", "Essex", "United Kingdom");
    Publisher publisher = new Publisher("Test Publisher", publisherAddress);
    Library library = new Library();
    Author author = new Author("Test Author");
    Book book = new Book(new Date(System.currentTimeMillis()), author, publisher,"Test Book", "978-3-16-148410-0");
    Map map = new Map(new Date(System.currentTimeMillis()), author, publisher,  "Map of the United Kingdom","Rivers");
    Newspaper newspaper = new Newspaper(new Date(System.currentTimeMillis()), author, publisher, "The Times", new Date(System.currentTimeMillis()));

    @Test
    public void personExistsTest(){
        Assert.assertNotNull(p.getAddress());
        Assert.assertNotNull(p.getName());
        Assert.assertNotNull(p.getId());
        Assert.assertEquals(p.getId(), 0);
    }

    @Test
    public void addressExistsTest(){
        Assert.assertNotNull(address.getLineOne());
        Assert.assertEquals(address.getLineOne(), "6 Rutland Avenue");
        Assert.assertNotNull(address.getCountry());
    }

    @Test
    public void publisherExistsTest(){
        Assert.assertNotNull(publisher.getAddress());
        Assert.assertEquals(publisher.getName(), "Test Publisher");
    }
    @Test
    public void bookExistsTest(){
        Assert.assertNotNull(book);
        Assert.assertNotNull(book.getName());
        Assert.assertNotNull(book.getISBN());
        Assert.assertNotNull(book.getAuthor());
    }

    @Test
    public void mapExistsTest(){
        Assert.assertNotNull(map);
        Assert.assertNotNull(map.getName());
        Assert.assertNotNull(map.getIsAMapOf());
        Assert.assertNotNull(map.getAuthor());
    }

    @Test
    public void newspaperExistsTest(){
        Assert.assertNotNull(newspaper);
        Assert.assertNotNull(newspaper.getName());
        Assert.assertNotNull(newspaper.getPublicationDate());
        Assert.assertNotNull(newspaper.getAuthor());
    }

    @Test
    public void authorExistsTest(){
        Assert.assertNotNull(author);
        Assert.assertNotNull(author.getName());
    }

    @Test
    public void addLibraryItemsTest(){
        Assert.assertFalse(library.checkIfItemIsInStock(book.getId()));
        library.addItem(book);
        Assert.assertTrue(library.checkIfItemIsInStock(book.getId()));
        library.addItem(map);
        library.addItem(newspaper);
        Assert.assertTrue(library.checkIfItemIsInStock(newspaper));
    }

    @Test
    public void removeLibraryItemsTest1(){
        //There should only be one in stock
        library.addItem(map);
        Assert.assertTrue(library.checkIfItemIsInStock(map));
        library.removeItem(map);
        Assert.assertFalse(library.checkIfItemIsInStock(map));
    }

    @Test
    public void removeLibraryItemsTest2(){
        library.addItem(map);
        Assert.assertTrue(library.checkIfItemIsInStock(map.getId()));
        library.removeItem(map.getId());
        Assert.assertFalse(library.checkIfItemIsInStock(map.getId())) ;
    }

    @Test
    public void updateLibraryItemsTest1(){
        library.addItem(map);
        Map newMap = new Map(new Date(System.currentTimeMillis()), author, publisher, "Map of the United Kingdom", "Roads");
        library.updateItem(map, newMap);
        Assert.assertEquals("Roads", map.getIsAMapOf());
    }


    @Test
    public void addingNewUserTest(){
        //add new user
        library.registerPerson(p);
        Assert.assertTrue(library.checkPersonExists(p));
//        p.addLibraryItem(book);
    }

    @Test
    public void removingUserTest1(){
        //remove user by object
        library.deletePerson(p);
        Assert.assertFalse(library.checkPersonExists(p));
    }


    @Test
    public void updateUserTest2(){
        //update user name by their object
        Person p2 = new Person(null, "New Name");
        Assert.assertNotEquals("New Name", p.getName());
        library.updatePerson(p, p2);
        Assert.assertEquals("New Name", p.getName());
    }

    @Test
    public void checkingOutItemTest(){
        //check out item by object
        library.addItem(map);
        Assert.assertTrue(library.checkIfItemIsInStock(map));
        library.checkOutLibraryItem(map, p);
        Assert.assertFalse(library.checkIfItemIsInStock(map));
    }

    @Test
    public void checkInItemTest(){
        //check in item by object
        library.addItem(map);
        Assert.assertTrue(library.checkIfItemIsInStock(map));
        library.checkOutLibraryItem(map, p);
        Assert.assertFalse(library.checkIfItemIsInStock(map));
        library.checkInItem(map, p);
        Assert.assertTrue(library.checkIfItemIsInStock(map));
    }

    @Test
    public void testSave(){
        library.addItem(map);
        library.addItem(map);
        library.addItem(book);
        library.addItem(book);
        library.addItem(book);
        library.addItem(newspaper);
        library.saveLibrary();
    }

    @Test
    public void testLoad(){
        library.loadLibrary();
    }
}
