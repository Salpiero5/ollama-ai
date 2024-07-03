package com.example.art.view.controller;

import com.example.art.model.Faq;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @GetMapping()
    public String getIndex(Model model) {
        model.addAttribute("faqs", createFAQs());
        return "index";
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
