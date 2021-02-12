package carTrip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest {
    private Car car;

    @Before
    public void setUp(){
        car = new Car("Ford", 40, 20, 10);
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("Ford", car.getModel());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetNullModel(){
        car.setModel("");
    }

    @Test
    public void testGetCapacity(){
        Assert.assertEquals(40, car.getTankCapacity(),0);
    }
    @Test
    public void testSetCapacity(){
        car.setTankCapacity(80);
        Assert.assertEquals(80, car.getTankCapacity(), 0);
    }

    @Test
    public void testGetFuel(){
        Assert.assertEquals(20, car.getFuelAmount(), 0);
    }

    @Test
    public void testSetFuel(){
        car.setFuelAmount(30);
        Assert.assertEquals(30, car.getFuelAmount(),0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testTooMuchFuel(){
        car.setFuelAmount(70);
    }

    @Test
    public void testGetConsumption(){
        Assert.assertEquals(10, car.getFuelConsumptionPerKm(),0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetSubzeroCons(){
        car.setFuelConsumptionPerKm(-10);
    }

    @Test
    public void testSetConsump(){
        car.setFuelConsumptionPerKm(13);
        Assert.assertEquals(13, car.getFuelConsumptionPerKm(), 0);
    }

    @Test (expected = IllegalStateException.class)
    public void testInsufficientFuelForDrive(){
        //double tripConsumotion = distance * this.getFuelConsumptionPerKm();
        car.drive(1000);
    }

    @Test
    public void testDriveSuccessful(){
        car.drive(1);
        Assert.assertEquals(10, car.getFuelAmount(), 0);
    }

    @Test (expected =  IllegalStateException.class)
    public void testOverflowRefuel(){
        car.refuel(1000);
    }

    @Test
    public void testRefuel(){
        car.refuel(5);
        Assert.assertEquals(25, car.getFuelAmount(), 0);
    }

}