package sk.complete.code.completecode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RootControllerTest {

    private RootController rootController = new RootController();

    @Test
    public void homePage() {
        Assert.assertEquals("index.html", rootController.homePage());
    }

    @Test
    public void signInPage() {
        Assert.assertEquals("signIn.html", rootController.signInPage());
    }
}
