package com.example.art.service;

import com.example.art.model.Faq;
import com.example.art.model.ProductInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FaqService {

    private final OllamaChatModel chatModel;

    public FaqService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public List<Faq> generateRelatedFaq(ProductInfo productInfo) {

        String prompt = "Please give me 3 information related to the "
                + productInfo.getProductType().toString() + "and the delivery type" + productInfo.getDelivery().toString()
                + "And no less than 3, exactly 3";;



        String response = chatModel.call(new Prompt(prompt,
                OllamaOptions.create()
                        .withModel("faqModel")
        )).getResult().getOutput().getContent();

        System.out.println("Response -> " + response);

        List<Faq> faqList;
        try {
            ObjectMapper mapper = new ObjectMapper();
            faqList = mapper.readValue(response, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return List.of(new Faq("How long is the return period for this item?", "Within 31 days you could return your order"),
                    new Faq("How long is the warranty period for this item?", "There is no warranty for this item unfortunately, please read the repair instructions"));
        }

        return faqList.stream()
                .map(faq -> {
                    faq.setQuestion(toLowerCase(faq.getQuestion()));
                    faq.setAnswer(toLowerCase(faq.getAnswer()));
                    return faq;
                })
                .collect(Collectors.toList());
    }

    private String toLowerCase(String text) {
        return text.toLowerCase();
    }

    public String generateText(@RequestParam String prompt) {
        return chatModel.call(new Prompt(
                prompt,
                OllamaOptions.create()
                        .withModel("llama3")
        )).getResult().getOutput().getContent();
    }
}
