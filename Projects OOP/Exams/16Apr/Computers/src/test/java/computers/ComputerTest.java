package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {
    private Computer computer;
    private List<Part> parts;

    @Before
    public void setUp() {
        this.computer = new Computer("Name");
        parts = new ArrayList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameNull() {
        computer = new Computer(null);
    }

    @Test
    public void testSetName() {
        computer = new Computer("Diff");
        Assert.assertEquals("Diff", computer.getName());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Name", computer.getName());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetUnmodifParts() {
        Part one = new Part("partOne", 1.2);
        parts.add(one);
        parts.add(new Part("partTwo", 1.1));
        boolean removedSuccessfully = computer.getParts().remove(one);
    }

    @Test
    public void testGetParts() {
        assertEquals(parts, computer.getParts());
    }

    @Test
    public void testGetTotalPrice() {
        Part one = new Part("partOne", 1.2);
        computer.addPart(new Part("partTwo", 1.1));
        computer.addPart(one);

        double sum = 2.3;
        assertEquals(2.3, computer.getTotalPrice(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullPart(){
        computer.addPart(null);
    }

    @Test
    public void testAddPart(){
        Part partToAdd = new Part("test", 3.0);

        computer.addPart(partToAdd);

        Part outputPart = computer.getParts().get(0);

        assertEquals(partToAdd, outputPart);
    }

    @Test
    public void testRemovePart(){
        Part partToAdd = new Part("test", 3.0);

        computer.addPart(partToAdd);

        computer.removePart(partToAdd);

        assertEquals(0, computer.getParts().size());
    }

    @Test
    public void testGetPart(){
        Part one = new Part("partOne", 1.2);
        computer.addPart(new Part("partTwo", 1.1));
        computer.addPart(one);

        assertEquals(one, computer.getPart("partOne"));
    }

}