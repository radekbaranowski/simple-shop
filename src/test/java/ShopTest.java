package barra;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShopTest
{
    private Shop shop;
    @BeforeTest
    public void setUp()
    {
        shop = new Shop();
    }

    @Test
    public void integersShouldGetProcessed()
    {
        Assert.assertEquals("You have bought 2 Goblins<br>You have bought 2 Imps<br>",shop.processOrder(2,2));
    }

    @Test
    public void stockExceededShouldGetRejected()
    {
        Assert.assertEquals("Order of A exceeds current stock.<br>Order of B exceeds current stock.<br>",shop.processOrder(25,15));
    }


}