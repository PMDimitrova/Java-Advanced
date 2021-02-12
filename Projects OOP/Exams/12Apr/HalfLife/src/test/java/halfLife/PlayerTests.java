package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {
    private List<Gun> guns;
    private Player player;
    private Player testPlayer;

    @Before
    public void setUp() {
        this.player = new Player("User", 100);
        guns = new ArrayList<>();
    }
    @Test (expected = NullPointerException.class)
    public void testNullName(){
        testPlayer = new Player("", 1000);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSubZeroHealth(){
        testPlayer = new Player("test", -10);
    }

    @Test
    public void testSubzeroHealth(){
        player.takeDamage(1000);
        Assert.assertEquals(0, player.getHealth());
    }

    @Test
    public void testDecreaseHealth(){
        player.takeDamage(50);
        Assert.assertEquals(50, player.getHealth());
    }

    @Test
    public void testGetUsername() {
        Assert.assertEquals("User", player.getUsername());
    }

    @Test
    public void testGetHealth() {
        Assert.assertEquals(100, player.getHealth());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodList() {
        player.getGuns().remove(0);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullGun() {
        Gun gun = null;
        player.addGun(gun);
    }

    @Test
    public void testAddGun() {
        Gun gun = new Gun("rifle", 100);

        player.addGun(gun);

        Assert.assertEquals(1, player.getGuns().size());
    }

    @Test
    public void testRemoveGun() {
        Gun gun = new Gun("rifle", 100);
        Gun gun1 = new Gun("rifle1", 1001);

        player.addGun(gun);
        player.addGun(gun1);

        player.removeGun(gun1);

        Assert.assertEquals(1, player.getGuns().size());
    }

    @Test
    public void testGetGun() {
        Gun gun = new Gun("rifle", 100);
        Gun gun1 = new Gun("rifle1", 1001);

        player.addGun(gun);
        player.addGun(gun1);
        String toFind = "rifle";

        Gun output = new Gun("test", 10);

        for (Gun gunPri: player.getGuns()) {
            if (gunPri.getName().equals(toFind)){
                output = gunPri;
            }
        }

        Assert.assertEquals(gun, output);
    }

    @Test
    public void testGetNullGun() {
        Gun gun = new Gun("rifle", 100);
        Gun gun1 = new Gun("rifle1", 1001);

        player.addGun(gun);
        player.addGun(gun1);
        String toFind = "somethingOther";

        Gun output = new Gun("test", 10);

        for (Gun gunPri: player.getGuns()) {
            if (gunPri.getName().equals(toFind)){
                output = gunPri;
            }
        }

        Assert.assertNotEquals(gun, output);
    }
}
