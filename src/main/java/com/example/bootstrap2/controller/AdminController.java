package com.example.bootstrap2.controller;


import com.example.bootstrap2.model.Role;
import com.example.bootstrap2.model.User;
import com.example.bootstrap2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/admin")

public class AdminController {


    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping()
    public String creatUser(@ModelAttribute("user") User user, Model model) {
        if (userService.loadUserByUsername(user.getEmail()) != null) {
            model.addAttribute("message", "User exists");
            return "admin";
        }
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


    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") int id, Model model, Principal principal) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("listroles", Role.values());
        model.addAttribute("authorise_user", userService.loadUserByUsername(principal.getName()));
        return "show";
    }

}