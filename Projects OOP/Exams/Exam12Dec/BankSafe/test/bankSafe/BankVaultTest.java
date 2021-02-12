package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.concurrent.ExecutionException;

public class BankVaultTest {
    private BankVault vault;

    @Before
    public void setUp(){
        vault = new BankVault();
    }

    @Test
    public void testSetUp(){
        Assert.assertNull(vault.getVaultCells().get("A1"));
    }

    @Test
    public void testConstructor(){
        Assert.assertEquals(12, vault.getVaultCells().size());
    }

    @Test (expected =  UnsupportedOperationException.class)
    public void testUnmodifiableMap(){
         vault.getVaultCells().remove("A1");
    }

    @Test
    public void testNotContainsCell(){
        Assert.assertFalse(vault.getVaultCells().containsKey("C5"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddC5Item() throws OperationNotSupportedException {
        Item item = new Item("Az", "23");
        vault.addItem("C5", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemInFullCell() throws OperationNotSupportedException {
        Item item = new Item("Az", "23");
        vault.addItem("C4",item);
        vault.addItem("C4", new Item("neshto", "jdj"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExistingItem() throws OperationNotSupportedException {
        Item item = new Item("Az", "23");
        vault.addItem("C4",item);
        try {
            vault.addItem("C3",item);

        }catch (OperationNotSupportedException exception){
            throw new IllegalArgumentException();
        }
        boolean exists = vault.getVaultCells().containsValue(item);
    }

    @Test
    public void testAddItemSucc() throws OperationNotSupportedException {
        Item item = new Item("Az", "23");
        vault.addItem("C4", item);
        Assert.assertEquals(item, vault.getVaultCells().get("C4"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveNonExisting(){
        vault.removeItem("C5", new Item("test", "test"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyCell(){
        Item item = new Item("Az", "23");
        vault.removeItem("C4", item);
    }

    @Test
    public void testSuccRemove() throws OperationNotSupportedException {
        Item item = new Item("Az", "23");
        vault.addItem("C4", item);
        vault.removeItem("C4", item);
        Assert.assertNull(vault.getVaultCells().get("C4"));
    }

}