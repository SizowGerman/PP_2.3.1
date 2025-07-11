package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.repository.UserRepo;

@Controller
@RequestMapping("/users")
public class UserControl {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("user", new User());
        return "users/list";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam String email) {
        User user = userRepo.findById(id);
        user.setName(name);
        user.setEmail(email);
        userRepo.update(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userRepo.delete(id);
        return "redirect:/users";
    }

}
