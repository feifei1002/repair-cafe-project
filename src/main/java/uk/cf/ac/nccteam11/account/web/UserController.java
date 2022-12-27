package uk.cf.ac.nccteam11.account.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.account.service.UserDTO;
import uk.cf.ac.nccteam11.account.service.UserService;
import uk.cf.ac.nccteam11.account.service.message.*;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService usrService){
        this.userService = usrService;
    }

    @GetMapping("login")
    public ModelAndView loginPage(Model model){
        return new ModelAndView("login/login");
    }

    @GetMapping("sign-up")
    public ModelAndView getNewSignUpForm(Model model){
        model.addAttribute("signUpForm", new SignUpForm());
        var mv = new ModelAndView("login/sign-up", model.asMap());
        return mv;
    }

    @PostMapping("sign-up")
    @ModelAttribute
    public ModelAndView addNewUser(@Valid SignUpForm newSignUp, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            var mv = new ModelAndView("login/sign-up", model.asMap());
            return mv;
        } else {
            UserDTO userDTO = new UserDTO(newSignUp.getUserId(), newSignUp.getFirstName(), newSignUp.getLastName(),
                    newSignUp.getEmail(), newSignUp.getPhoneNo(), newSignUp.getPassword(), newSignUp.getAddress(),
                    newSignUp.getCity(), newSignUp.getPostcode(), newSignUp.getRole(), newSignUp.getEnabled());
            SaveUserRequest saveUserRequest = SaveUserRequest.of().userDTO(userDTO).build();
            SaveUserResponse saveUserResponse = userService.addNewUser(saveUserRequest);
            var mv = new ModelAndView("redirect:/");
            return mv;
        }
    }

    @GetMapping("admin/users-list")
    public ModelAndView getUsersListPage(@RequestParam(name = "search", required = false) String query, Model model) {

        UserListRequest userListRequest = UserListRequest.of().searchTerm(query).build();
        var userListResponse = userService.getUsers(userListRequest);

        model.addAttribute("users", userListResponse.getUsers());

        var mv = new ModelAndView("admin/users-list", model.asMap());
        return mv;
    }

    @PostMapping("admin/user/{id}/update")
    public ModelAndView approveUser(@PathVariable("id") Integer userId, Model model){
        UpdateUserRequest updateUserRequest = UpdateUserRequest.of().userId(userId).build();
        UpdateUserResponse updateUserResponse = userService.updateUser(updateUserRequest);
        var mv = new ModelAndView("redirect:/admin/users-list");
        return mv;
    }

    @PostMapping("admin/user/{id}/delete")
    public ModelAndView deleteUser(@PathVariable("id") Integer userId, Model model){
        DeleteUserRequest deleteUserRequest = DeleteUserRequest.of().userId(userId).build();
        DeleteUserResponse deleteUserResponse = userService.deleteUser(deleteUserRequest);
        var mv = new ModelAndView("redirect:/admin/users-list");
        return mv;
    }
}
