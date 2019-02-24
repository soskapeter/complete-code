package sk.complete.code.completecode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.rmi.UnexpectedException;


@Controller
public class RootController {

    private static final Logger logger = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private UserSessionBean userSessionBean;

    @GetMapping("/")
    public String homePage() {
        return "index.html";
    }

    @GetMapping("/register")
    public String getRegistered() {
        if (!userSessionBean.isLoggedIn()) {
            userSessionBean.registerMeAndLogIn();
        }
        logger.info("Token: {}", userSessionBean.getUserSession().getToken());
        logger.info("Create time: {}", userSessionBean.getUserSession().getCreateTime());
        return "register.html";
    }

    @GetMapping("/oauth")
    public String signInPage() throws UnexpectedException {
        if (!userSessionBean.isLoggedIn() || userSessionBean.getUserSession().getAccount() == null) {
            return "signIn.html";
        } else if (userSessionBean.getUserSession().getAccount().isFreelancer()) {
            return "redirect:/freelancer";
        } else if (userSessionBean.getUserSession().getAccount().isHirer()) {
            return "redirect:/hirer";
        }
        throw new UnexpectedException("What happened?");
    }

    @GetMapping("/freelancer")
    public String freelancerPage() {
        if (userSessionBean.isLoggedIn()) {
            userSessionBean.createNewFreelancerAccount();
        }
        return "freelancer.html";
    }

    @GetMapping("/hirer")
    public String hirerPage() {
        if (userSessionBean.isLoggedIn()) {
            userSessionBean.createNewHirerAccount();
        }
        return "hirer.html";
    }
}
