package com.example.art.service;

import com.example.art.model.Faq;
import com.example.art.model.ProductInfo;
import com.google.gson.Gson;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FaqService {

    private final OllamaChatModel chatModel;

    public FaqService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public Faq generateRelatedFaq(ProductInfo productInfo) {

        String prompt = "Please return FAQ related to productType of "
                + productInfo.getProductType().toString() +
                "and delivery status of "
                + productInfo.getDelivery().toString();

        // Use Ollama chat API to get the response (replace with your implementation)
        String response = chatModel.call(new Prompt(prompt,
                OllamaOptions.create()
                        .withModel("llama3")
        )).getResult().getOutput().getContent();

        // Parse the response using Gson
        Gson gson = new Gson();
        return gson.fromJson(response, Faq.class);
    }
}
