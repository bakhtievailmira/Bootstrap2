package com.example.bootstrap2.controller;

import com.example.bootstrap2.model.Role;
import com.example.bootstrap2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;


@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String showUser(Principal principal, Model model) {
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("authorise_user", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("listroles", Role.values());
        return "show";
    }

}
