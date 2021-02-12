package p03_IteratorTest;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] ELEMENTS = {"A", "B", "C", "D"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreatingListIteratorShouldThrowWithNullAsParam() throws OperationNotSupportedException {
        new ListIterator( null);
    }

    @Test
    public void testMoveShouldReturnCorrectBoolean() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test
    public void testHasNextShouldReturnCorrectBoolean() {
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test (expected = IllegalStateException.class)
    public void testPrintShouldTrowWithoutElementsPresent() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintShouldPrintCorrectElements(){
        for (int index = 0 ; listIterator.hasNext(); listIterator.move() ) {
            assertEquals(ELEMENTS[index++], listIterator.print());
        }
    }
}