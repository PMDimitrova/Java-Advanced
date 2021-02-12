package computers;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer computer1;
    private Computer computer2;

    @Before
    public void setUp(){
        this.computerManager = new ComputerManager();
        computer1 = new Computer("Dell", "A4532", 300.00);
        computer2 = new Computer("ASUS", "ROG", 500.00);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullAdd(){
        this.computerManager.addComputer(null);
    }
//    @Test (expected = UnsupportedOperationException.class)
//    public void testGetList(){
//        computerManager.getComputers().remove(0);
//    }
//
//    @Test (expected = NullPointerException.class)
//    public void testGetCompNullName(){
//        computerManager.addComputer(computer1);
//        computerManager.addComputer(computer2);
//
//        computerManager.getComputer(null, "");
//    }

//    @Test
//    public void testGetCount(){
//        computerManager.addComputer(computer1);
//        computerManager.addComputer(computer2);
//        Assert.assertEquals(2, computerManager.getComputers().size());
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testAddExistingComp(){
//        computerManager.addComputer(computer1);
//        computerManager.addComputer(computer2);
//
//        computerManager.addComputer(computer1);
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testAddNullObj() {
//        computerManager.addComputer(null);
//    }
//
//    @Test
//    public void testGetComp() {
//        computerManager.addComputer(computer1);
//        String manuf = computer1.getManufacturer();
//        String model = computer1.getModel();
//
//        Computer output = computerManager.removeComputer(manuf, model);
//        Assert.assertEquals("Dell", output.getManufacturer());
//        Assert.assertEquals("A4532", output.getModel());
//    }
//
//    @Test
//    public void testRemove(){
//        computerManager.addComputer(computer1);
//        computerManager.addComputer(computer2);
//        String manuf = computer1.getManufacturer();
//        String model = computer1.getModel();
//
//        Computer output = computerManager.removeComputer(manuf, model);
//
//        Assert.assertEquals(computer1, output);
//    }
//
//    @Test
//    public void testGetNoSuchComp(){
//        computerManager.addComputer(computer1);
//        computerManager.addComputer(computer2);
//
//        boolean noSuchComp = true;
//
//        for (Computer comp:computerManager.getComputers()) {
//            if (comp.getManufacturer().equals("fail")){
//                noSuchComp = false;
//            }
//        }
//
//        Assert.assertTrue(noSuchComp);
//    }
//
//    @Test
//    public void testGetByManuf(){
//        computerManager.addComputer(computer1);
//        computerManager.addComputer(computer2);
//
//        List<Computer> output = new ArrayList<>();
//        String manufacturer = "Dell";
//
//        for (int i = 0; i < computerManager.getComputers().size(); i++) {
//            if (computerManager.getComputers().get(i).getManufacturer().equals(manufacturer)){
//                output.add(computerManager.getComputers().get(i));
//            }
//        }
//
//        Assert.assertEquals(1, output.size());
//    }
}