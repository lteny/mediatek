package ru.reuckiy.mediatek.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.reuckiy.mediatek.model.User;
import ru.reuckiy.mediatek.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String usersPage(Model model) {
        List<User> userList = userRepository.findAll();

        model.addAttribute("title", "Users");
        model.addAttribute("userList", userList);
        return "admin/user/user";
    }

    @GetMapping("{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);

        return "redirect:";
    }
}
