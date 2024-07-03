package com.example.art.model;

import lombok.Data;

@Data
public class Faq {
    private String question;
    private String answer;

    public Faq() {
    }

    public Faq(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
