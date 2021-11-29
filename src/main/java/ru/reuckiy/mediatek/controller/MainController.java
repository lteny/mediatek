package ru.reuckiy.mediatek.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.reuckiy.mediatek.repository.UserRepository;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Value("${spring.profile.active}")
    private String profile;

    @GetMapping
    public String main(Model model) {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("staff", userRepository.findAll());

        model.addAttribute("title", "Главная страница");
        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile));

        return "index";
    }
}
