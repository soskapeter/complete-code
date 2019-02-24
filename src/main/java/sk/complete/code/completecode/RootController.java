package sk.complete.code.completecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String homePage(){
        return "index.html";
    }

    @GetMapping("/oauth")
    public String signInPage(){
        return "signIn.html";
    }
}
