package sk.complete.code.completecode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(RootController.class)
public class RootControllerTest {

    @MockBean
    UserSessionBean userSessionBean;

    @Autowired
    private RootController rootController;


    @Test
    public void homePage() {
        Assert.assertEquals("index.html", rootController.homePage());
    }

    @Test
    public void freelancerPage() {
        Assert.assertEquals("freelancer.html", rootController.freelancerPage());
    }

    @Test
    public void hirerPage() {
        Assert.assertEquals("hirer.html", rootController.hirerPage());
    }
}
