package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GarageTests {
    private Garage garage;
    private Car car1;
    private Car car2;

    @Before
    public void setUp(){
        garage = new Garage();
        car1 = new Car("Ford", 250, 1000);
        car2 = new Car("Mazda", 120, 400);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetUnmodifiableList(){
        garage.addCar(car1);
        garage.getCars().remove(0);
    }

    @Test
    public void testGetList(){
        garage.addCar(car1);
        Assert.assertEquals(1, garage.getCars().size());
    }

    @Test
    public void testGetCount(){
        garage.addCar(car1);
        garage.addCar(car2);
        Assert.assertEquals(2,garage.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullCar(){
        garage.addCar(null);
    }

    @Test
    public void testAddCar(){
        garage.addCar(new Car("Test", 123, 456));
        Assert.assertEquals("Test", garage.getCars().get(0).getBrand());
    }

    @Test
    public void testMaxSpeedMethod(){
        garage.addCar(car1);
        garage.addCar(car2);

        Assert.assertEquals(1, garage.findAllCarsWithMaxSpeedAbove(200).size());
    }

    @Test
    public void testFindMostExpensive(){
        garage.addCar(car1);
        garage.addCar(car2);

        Assert.assertEquals(car1, garage.getTheMostExpensiveCar());
    }

    @Test
    public void testFindCarsByBrands(){
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(new Car("Ford", 123, 456));

        Assert.assertEquals(2, garage.findAllCarsByBrand("Ford").size());
    }

}