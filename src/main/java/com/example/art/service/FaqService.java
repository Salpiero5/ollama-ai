package com.example.art.service;

import com.example.art.model.Faq;
import com.example.art.model.ProductInfo;
import com.google.gson.Gson;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Service
public class FaqService {

    private final OllamaChatModel chatModel;

    public FaqService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public Faq generateRelatedFaq(ProductInfo productInfo) {

        String prompt = "Please give top 2 information related to "
                + productInfo.getProductType().toString() +
                " return items";

        // Use Ollama chat API to get the response (replace with your implementation)
        String response = chatModel.call(new Prompt(prompt,
                OllamaOptions.create()
                        .withModel("faqModel")
        )).getResult().getOutput().getContent();

        System.out.println(response);

        // Parse the response using Gson
        Gson gson = new Gson();
        return gson.fromJson(response, Faq.class);
    }

    public String generateText(@RequestParam String prompt) {
        return chatModel.call(new Prompt(
                prompt,
                OllamaOptions.create()
                        .withModel("llama3")
        )).getResult().getOutput().getContent();
    }
}
