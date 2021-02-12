package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Person[] EXPECTED = {new Person(1, "First"),
            new Person(2, "Second"),
            new Person(3, "Third"),
            new Person(4, "Fourth")};

    @Before
    public void setUp() throws OperationNotSupportedException {
        Person p1 = new Person(1, "First");
        Person p2 = new Person(2, "Second");
        Person p3 = new Person(3, "Third");
        Person p4 = new Person(4, "Fourth");
        database = new Database(p1, p2, p3, p4);
    }

    @Test
    public void testDatabaseConstructorShouldCreateObjectWithValidState() {
        Person[] elements = database.getElements();
        assertEquals(EXPECTED.length, elements.length);
        for (int i = 0; i < EXPECTED.length; i++) {
            assertEquals(EXPECTED[i], elements[i]);
        }

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorShouldThrowWhenCalledWithMoreThenSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new p01_Database.Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorShouldThrowWhenCalledWithNoElements() throws OperationNotSupportedException {
        Person[] numbers = new Person[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddAtFirstFreeIndex() throws OperationNotSupportedException {
        Person fifth = new Person(5, "Fifth");

        database.add(fifth);
        Person[] elements = database.getElements();
        assertEquals(5, elements.length);
        assertEquals(fifth, elements[4]);
    }

    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Person[] elements = database.getElements();
        Person[] expected = {new Person(1, "First"),
                new Person(2, "Second"),
                new Person(3, "Third")};
        assertEquals(expected.length, elements.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], elements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWithEmptyData() throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWithNullParameter() throws OperationNotSupportedException{
       this.database.findByUsername(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWhenNoSuchUserIsPresent() throws OperationNotSupportedException{
        this.database.findByUsername("Not_Present_Username");
    }
    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWhenMoreThanOnePplHaveTheSameUsername() throws OperationNotSupportedException{
        Person p1 = new Person(1, "First");
        Person p2 = new Person(2, "Second");
        Person p3 = new Person(3, "Fourth");
        Person p4 = new Person(4, "Fourth");
        Database database = new Database(p1, p2, p3, p4);
        database.findByUsername("Fourth");
    }

    @Test
    public void testFindByUsernameShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person person = this.database.findByUsername("Fourth");
        assertEquals(new Person(4, "Fourth"), person);
    }

    @Test (expected =  OperationNotSupportedException.class)
    public void testFIndByIdShouldThrowWithIdNotPresent() throws OperationNotSupportedException {
        database.findById(100);
    }

    @Test (expected =  OperationNotSupportedException.class)
    public void testFIndByIdShouldThrowWithMultiplePplWithSameID() throws OperationNotSupportedException {
        Person p1 = new Person(1, "First");
        Person p2 = new Person(2, "Second");
        Person p3 = new Person(3, "Fourth");
        Person p4 = new Person(3, "Fourth");
        Database database = new Database(p1, p2, p3, p4);
        database.findById(3);
    }

    @Test
    public void testFindByIDShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person byId = this.database.findById(1);
        assertEquals(1, byId.getId());
        assertEquals("First", byId.getUsername());
    }

}
