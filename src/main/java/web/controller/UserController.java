package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.Users;
import web.service.UsersService;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UsersService usersService;
    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping("/")
    public String usersAll(Model model) {
        model.addAttribute("users", usersService.getAllUsers());
        return "users";
    }
    @GetMapping("/{id}")
    public String usersId(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", usersService.getUserId(id));
        return "users";
    }
    @GetMapping("/new")
    public String addUser(Users users) {
        return "create";
    }
    @PostMapping("/new")
    public String add(@ModelAttribute("users") Users users) {
        usersService.addUser(users);
        return "redirect:/";
    }
    @DeleteMapping("/delite/{id}")
    public String delete(@PathVariable("id") long id) {
        usersService.removeUser(id);
        return "redirect:/";
    }
    @GetMapping("edit/{id}")
    public String updateUser(Model model, @PathVariable("id") long id) {
        model.addAttribute(usersService.getUserId(id));
        return "edit";
    }
    @PatchMapping("/edit")
    public String update(@Valid Users users, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            usersService.updateUser(users);
            return "redirect:/";
        }
    }


}
