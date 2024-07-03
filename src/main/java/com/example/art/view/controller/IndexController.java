package com.example.art.view.controller;

import com.example.art.model.Faq;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @GetMapping()
    public String getIndex(Model model) {
        model.addAttribute("faqs", createFAQs());
        return "index";
    }


    @GetMapping("test")
    public String getTestModelInput(Model model) {
        model.addAttribute("faqs", createFAQs());
        return "test";
    }

    @PostMapping("test")
    public String postTestModelInput(@RequestParam String input, Model model) {
        // TODO: Put input in LLM model, return answer as String;
        var llmResponse = input+"\n\nTHIS-NEEDS-TO-BECOME-THE-LLM-RESPONSE-USING-INPUT\n";
        model.addAttribute("response", llmResponse);
        return "test";
    }

    // This must be replaced by actually calling the model and returning the faqs
    private List<Faq> createFAQs() {
        List<Faq> faqs = new ArrayList<>();
        faqs.add(new Faq("First question", "First answer"));
        faqs.add(new Faq("Second question", "Second answer"));
        faqs.add(new Faq("Third question", "Third answer"));
        return faqs;
    }
}
