package uk.cf.ac.nccteam11.account.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class LoginController {
    @GetMapping("/login")
    String login() {
        return "login";
    }
}
