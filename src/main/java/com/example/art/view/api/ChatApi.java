package com.example.art.view.api;

import com.example.art.model.Delivery;
import com.example.art.model.Faq;
import com.example.art.model.ProductInfo;
import com.example.art.model.ProductType;
import com.example.art.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatApi {

    private final OllamaChatModel chatModel;
    private final FaqService faqService;

    /**
     * Endpoint to generate text based on a given prompt.
     */
    @GetMapping("/generateText")
    public String generateText(@RequestParam String prompt) {
        // Call the model with the prompt and return the generated content()
        return chatModel.call(new Prompt(
                prompt,
                OllamaOptions.create()
                        .withModel("llama3")
        )).getResult().getOutput().getContent();
    }

    // For testing purposes
    @GetMapping("/generateFaqs")
    public Faq generateFaqs() {
        ProductInfo product = new ProductInfo();
        product.setProductType(ProductType.DIGITAL);
        product.setDelivery(Delivery.DELIVERED);
        return faqService.generateRelatedFaq(product);
    }



    /**
     * For This you may need to add flux dependency
     * Endpoint to generate a streaming response for a given message.
     */
//    @GetMapping("/generateStream")
//    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
//        // Create a prompt from the user message and return a stream of responses
//        Prompt prompt = new Prompt(message);
//        return chatModel.stream(prompt);
//    }


}
