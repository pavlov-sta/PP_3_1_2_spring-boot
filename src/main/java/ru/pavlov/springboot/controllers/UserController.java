package ru.pavlov.springboot.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.pavlov.springboot.model.User;
import ru.pavlov.springboot.services.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") @Valid User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("user/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") int id){
        userService.removeUser(id);
        return "redirect:/";
    }

    @PatchMapping("/user/{id}")
    public String update(@ModelAttribute("user")@Valid User user){
        userService.updateUser(user);
        return "redirect:/";
    }
}
