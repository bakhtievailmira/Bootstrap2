package com.example.bootstrap2.controller;


import com.example.bootstrap2.model.Role;
import com.example.bootstrap2.model.User;
import com.example.bootstrap2.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;


@Controller
@RequestMapping("/admin")

public class AdminController {


    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping()
    public String creatUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping()
    public String showUserList(Model model, Principal principal, @ModelAttribute("newUser") User newUser) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("listroles", Role.values());
        model.addAttribute("authorise_user", userService.loadUserByUsername(principal.getName()));
        return "admin";
    }

    @PutMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/index";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") int id, Model model, Principal principal) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("listroles", Role.values());
        model.addAttribute("authorise_user", userService.loadUserByUsername(principal.getName()));
        return "show";
    }

}