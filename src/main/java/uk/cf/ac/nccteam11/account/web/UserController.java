package uk.cf.ac.nccteam11.account.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.account.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService usrService){
        this.userService = usrService;
    }

    @GetMapping("user/sign-up")
    public ModelAndView getNewSignUpForm(Model model){
        model.addAttribute("signUpForm", new SignUpForm());
        var mv = new ModelAndView("sign-up", model.asMap());
        return mv;
    }
}
