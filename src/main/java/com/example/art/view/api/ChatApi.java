package com.example.art.view.api;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ChatApi {

    private final OllamaChatModel chatModel;

    /**
     * Endpoint to generate text based on a given prompt.
     *
     * @param prompt the input prompt to generate text
     * @return generated text response from the model
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


    /**
     * For This you may need to add flux dependency
     * Endpoint to generate a streaming response for a given message.
     *
     * @param message the input message to generate a response
     * @return a Flux stream of ChatResponse containing the generated responses
     */
    @GetMapping("/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        // Create a prompt from the user message and return a stream of responses
        Prompt prompt = new Prompt(message);
        return chatModel.stream(prompt);
    }
}
