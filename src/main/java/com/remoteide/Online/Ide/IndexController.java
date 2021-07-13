package com.remoteide.Online.Ide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class IndexController {

    @Autowired
    private CodeExecutorService codeExecutorService;


    @GetMapping("/codeText")
    public String OnlineIDE(Model model) {
        model.addAttribute("codeText", new CodeText());
        return "codeText";
    }
    @PostMapping("/codeText")
    public String greetingSubmit(@ModelAttribute CodeText codeText, Model model) {
        model.addAttribute("codeText", codeText);
        String output = codeExecutorService.executeCode(codeText.getLanguageString(), codeText.getCode());
        model.addAttribute("output", output);
        return "Success";
    }



}
