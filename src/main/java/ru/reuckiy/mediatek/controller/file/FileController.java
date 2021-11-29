package ru.reuckiy.mediatek.controller.file;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class FileController {

    @GetMapping
    public String filePage(Model model) {
        model.addAttribute("title", "File");

        return "admin/file/file";
    }
}
