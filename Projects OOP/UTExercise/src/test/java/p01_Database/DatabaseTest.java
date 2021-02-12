package p01_Database;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] EXPECTED = {13, 42, 69, 73};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database =  new Database(13, 42, 69, 73);
    }

    @Test
    public void testDatabaseConstructorShouldCreateObjectWithValidState(){
        Integer[] elements = database.getElements();
        assertEquals(EXPECTED.length, elements.length);
        for (int i = 0; i <EXPECTED.length; i++) {
            assertEquals(EXPECTED[i], elements[i]);
        }

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorShouldThrowWhenCalledWithMoreThenSixteenElements () throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorShouldThrowWhenCalledWithNoElements () throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }
    @Test (expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddAtFirstFreeIndex() throws OperationNotSupportedException {
        database.add(666);
        Integer[] elements = database.getElements();
        assertEquals(5, elements.length);
        assertEquals(Integer.valueOf(666), elements[4]);
    }

    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] elements = database.getElements();
        Integer[] expected = {13,42,69};
        assertEquals(expected.length, elements.length);
        for (int i = 0; i <expected.length; i++) {
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

}
