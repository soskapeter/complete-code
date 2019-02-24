package sk.complete.code.completecode;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Date;

@Service
@SessionScope
public class UserSessionBean {

    private UserSession userSession;

    public UserSession getUserSession() {
        return userSession;
    }

    public boolean isLoggedIn() {
        return userSession != null;
    }

    public void registerMeAndLogIn(){
        userSession = new UserSession();
        userSession.setToken("MyNewTokenThatIHave");
        userSession.setCreateTime(new Date());
    }

    public void createNewFreelancerAccount() {
        if (userSession.getAccount() == null) {
            userSession.setAccount(Account.createFreelancerAccount());
        }
    }

    public void createNewHirerAccount() {
        if (userSession.getAccount() == null) {
            userSession.setAccount(Account.createHirerAccount());
        }
    }
}
