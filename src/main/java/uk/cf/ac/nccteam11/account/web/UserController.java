package uk.cf.ac.nccteam11.account.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.account.service.UserDTO;
import uk.cf.ac.nccteam11.account.service.UserService;
import uk.cf.ac.nccteam11.account.service.message.SaveUserRequest;
import uk.cf.ac.nccteam11.account.service.message.SaveUserResponse;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService usrService){
        this.userService = usrService;
    }

    @GetMapping("user/login")
    public ModelAndView loginPage(Model model){
        return new ModelAndView("login/login");
    }

    @GetMapping("user/sign-up")
    public ModelAndView getNewSignUpForm(Model model){
        model.addAttribute("signUpForm", new SignUpForm());
        var mv = new ModelAndView("login/sign-up", model.asMap());
        return mv;
    }

    @PostMapping("user/sign-up/add")
    @ModelAttribute
    public ModelAndView addNewUser(@Valid SignUpForm newSignUp, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            var mv = new ModelAndView("login/sign-up", model.asMap());
            return mv;
        } else {
            UserDTO userDTO = new UserDTO(newSignUp.getUser_id(), newSignUp.getFirstName(), newSignUp.getLastName(),
                    newSignUp.getEmail(), newSignUp.getPhoneNo(), newSignUp.getPassword(), newSignUp.getAddress(),
                    newSignUp.getCity(), newSignUp.getPostcode());
            SaveUserRequest saveUserRequest = SaveUserRequest.of().userDTO(userDTO).build();
            SaveUserResponse saveUserResponse = userService.addNewUser(saveUserRequest);
            var mv = new ModelAndView("redirect:/");
            return mv;
        }
    }
}
