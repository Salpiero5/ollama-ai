package com.example.art.view.controller;

import com.example.art.model.Faq;
import com.example.art.service.FaqService;
import com.example.art.service.ProductGenerationService;
import static java.lang.Boolean.TRUE;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor

public class IndexController {

    private final FaqService faqService;
    private final ProductGenerationService productGenerationService;

    @GetMapping()
    public String getIndex(@RequestParam(required = false, name = "random") Boolean random, Model model) {
        if (TRUE.equals(random)) {
            model.addAttribute("productInfo", productGenerationService.getRandom());
        } else {
            model.addAttribute("productInfo", productGenerationService.getDefault());
        }
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
        var llmResponse = faqService.generateText(input);
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
