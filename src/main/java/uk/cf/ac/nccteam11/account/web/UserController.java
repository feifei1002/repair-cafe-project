package uk.cf.ac.nccteam11.account.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.account.service.UserDTO;
import uk.cf.ac.nccteam11.account.service.UserService;
import uk.cf.ac.nccteam11.account.service.message.SaveUserRequest;
import uk.cf.ac.nccteam11.account.service.message.SaveUserResponse;

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

    @PostMapping("user/sign-up/add")
    public ModelAndView addNewUser(SignUpForm newSignUp, Model model){
        UserDTO userDTO = new UserDTO(newSignUp.getUser_id(), newSignUp.getFirstName(), newSignUp.getLastName(),
                                    newSignUp.getEmail(), newSignUp.getPassword(), newSignUp.getFirstLineAddress(),
                                    newSignUp.getTown(), newSignUp.getCity(), newSignUp.getPostcode());
        SaveUserRequest saveUserRequest = SaveUserRequest.of().userDTO(userDTO).build();
        SaveUserResponse saveUserResponse = userService.addNewUser(saveUserRequest);
        var mv = new ModelAndView("redirect:/");
        return mv;
    }
}
